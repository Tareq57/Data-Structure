public class AQueue<E> implements QueueADT<E>{
    private static final int defaultSize = 10;
    private int maxSize;
    private int front;
    private int rear;
    private E[] listArray;
    AQueue() { this(defaultSize); }
    AQueue(int size) {
        maxSize = size+1;
        rear = 0; front = 1;
        listArray = (E[])new Object[maxSize];
    }
    AQueue(E[] arr)
    {
        maxSize = arr.length+1;
        rear = 0; front = 1;
        listArray = (E[])new Object[maxSize];
        for(int i=0;i<arr.length;i++)
        {
            enqueue(arr[i]);
        }
    }
    @Override
    public void clear()
    { rear = 0; front = 1; }
    @Override
    public void enqueue(E it) {
        if(((rear+2) % maxSize) != front)
        {
            rear = (rear+1) % maxSize;
            listArray[rear] = it;
        }
        else
        {
            E[] temp=listArray;
            maxSize=2*maxSize;
            listArray = (E[])new Object[maxSize];
            rear = 0; front = 1;
            for(int i=0;i<temp.length;i++)
            {
                enqueue(temp[i]);
            }

        }

    }
    @Override
    public E dequeue() {
        if(length()!=0)
        {
            E it = listArray[front];
            front = (front+1) % maxSize;
            return it;
        }
        else
        {
            return  null;
        }
    }
    @Override
    public E frontValue() {
        if(length()!=0)
        return listArray[front];
        else return null;
    }
    @Override
    public E rearValue() {
        if(length()!=0)
        return listArray[rear];
        else return null;
    }
    @Override
    public E leaveQueue()
    {
        if(length()!=0)
        {
            E it = listArray[rear];
            rear = (rear-1) % maxSize;
            return it;
        }
        else
        {
            return  null;
        }
    }
    public int length()
    { return ((rear+maxSize) - front + 1) % maxSize; }
}
