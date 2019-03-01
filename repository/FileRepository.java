package todoly.repository;

import todoly.interfaces.RepositoryInterface;
import todoly.interfaces.TaskListInterface;

public class FileRepository implements RepositoryInterface<TaskListInterface> {

	public FileRepository(String path) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TaskListInterface load() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TaskListInterface taskList) {
		// TODO Auto-generated method stub
		
	}


}
