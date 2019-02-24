package todoly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import todoly.enums.Context;
import todoly.exceptions.InvalidUserInputException;
import todoly.interfaces.ServiceInterface;
import todoly.model.Task;
import todoly.presenters.ListTasksMenue;
import todoly.presenters.MainMenue;
import todoly.presenters.Presenter;

public class TextBasedInterface extends ApplicationInterface{
	
	private Map<Context,Presenter> presenters;
	private ServiceInterface taskService;
	private Context context;
	private Scanner scanner = new Scanner(System.in);
	private String input;
	
	
	public TextBasedInterface(ServiceInterface taskService) {
		this.taskService = taskService;
		context = Context.MAIN_MENUE;
		setViews();
	}
	
	public void run() {
		Presenter presenter = presenters.get(context);
		setPresenterProperties(presenter);
		presenter.displayView();
		input = scanner.nextLine();
		
		try {
			context = presenter.getContext(input);
		} catch (InvalidUserInputException e) {
			presenter.setErrorMessage(e.getMessage());
		}
	}
	
	private void setPresenterProperties(Presenter presenter){
		Map<String, Object> properties = new HashMap<>();
		switch (context) {
		case MAIN_MENUE:
			properties.put("taskAmount",Integer.toString(getTaskAmount()));
			properties.put("taskDoneAmount",Integer.toString(getTaskDoneAmount()));
			presenter.setProperties(properties);
			break;
		case LIST_TASKS:
			properties.put("tasks",listTasksByDueDate());
			presenter.setProperties(properties);
			break;
		}
		
	}

	@Override
	protected Integer getTaskAmount() {
		return taskService.getTaskAmount();
	}

	@Override
	protected Integer getTaskDoneAmount() {
		return taskService.getTaskDoneAmount();
	}
	
	@Override
	protected List<Task> listTasksByDueDate(){
		return taskService.listTasksByDueDate();
	}

	public boolean isRunning() {
		return context != Context.SAVE_AND_QUIT;
	}
	
	public void save() {
		taskService.save();
		scanner.close();
	}
	
	@SuppressWarnings("serial")
	private void setViews() {
		presenters = new HashMap<Context, Presenter>(){{
						put(Context.MAIN_MENUE,new MainMenue());
						put(Context.LIST_TASKS,new ListTasksMenue());
					}};
	}
}
