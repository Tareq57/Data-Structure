public interface BinNode <T>{
    public T element();
    public void setElement(T elem);
    public BinNode<T> left();
    public BinNode<T> right();
    public boolean isLeaf();
}
