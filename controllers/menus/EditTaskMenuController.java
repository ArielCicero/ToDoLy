package todoly.controllers.menus;

import java.util.Scanner;

import todoly.controllers.Controller;
import todoly.views.menus.EditTaskMenuView;

public class EditTaskMenuController extends Controller {

	public EditTaskMenuController(Scanner scanner) {
		displayMenu(new EditTaskMenuView(), scanner);
	}
}
