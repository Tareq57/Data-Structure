public interface QueueADT<E>{
    public void clear();
    public void enqueue(E it);
    public E dequeue();
    public E frontValue();
    public E rearValue();
    public int length();
    public E leaveQueue();
}
