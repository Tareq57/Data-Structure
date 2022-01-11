import java.security.Key;

public interface BST_Interface<T> {
    public void Insert(T item);
    public void Delete(T item);
    public boolean Find(T item);
    public void InOrder();
    public void PostOrder();
    public void PreOrder();
}
