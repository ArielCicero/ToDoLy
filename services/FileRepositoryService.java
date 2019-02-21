package todoly.services;

import java.nio.file.Path;
import java.util.Collection;

import todoly.exceptions.RepositoryException;
import todoly.model.Task;

public class FileRepositoryService extends RepositoryService {
	
	Path path;
	
	public FileRepositoryService(Path path) {
		this.path = path;
	}

	@Override
	public Collection<Task> getTasks() throws RepositoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveTasks(Collection<Task> tasks) throws RepositoryException {
		// TODO Auto-generated method stub

	}

}
