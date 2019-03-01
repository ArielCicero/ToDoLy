package todoly.interfaces;

public interface RepositoryInterface<T> {
    
    T load();
    
    void save(T object);
    
}
