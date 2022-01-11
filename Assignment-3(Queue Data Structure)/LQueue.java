class LQueue<E> implements QueueADT<E> {
    private Link<E> front;
    private Link<E> rear;
    private Link<E> curr;
    private int size;
    public LQueue() {
        init();
    }

    public LQueue(int size) {
        init();
    }
    public LQueue(E[] arr)
    {
        init();
        for(int i=0;i<arr.length;i++)
        {
            enqueue(arr[i]);
        }
    }
    private void init() {
        front = rear = new Link<E>(null);
        size = 0;
    }
    @Override
    public void clear() {
        init();
    }
    @Override
    public void enqueue(E it) {
        rear.setNext(new Link<E>(it, null));
        rear = rear.next();
        size++;
    }
    @Override
    public E dequeue() {
        if(size!=0)
        {
            E it = front.next().element();
            front.setNext(front.next().next());
            if (front.next() == null) {rear = front;}
            size--;
            return it;
        }
        else return null;
    }
    @Override
    public E frontValue() {
        if(size!=0)
        return front.next().element();
        else return null;
    }
    @Override
    public E rearValue() {
        if(size!=0)
        return rear.element();
        else return  null;
    }
    @Override
    public int length() {
        return size;
    }

    @Override
    public E leaveQueue() {
        E it = rear.element();
        Link<E> curr=front;
        while (curr.next().next()!=null)
            curr=curr.next();
        curr.setNext(null);
        if(front.next()==null)rear=front;
        size--;
        return it;


    }
}
class Link<E> {
    private E element;
    private Link<E> next;
    Link(E it, Link<E> nextval)
    { element = it; next = nextval; }
    Link(Link<E> nextval) { next = nextval; }
    Link<E> next() { return next; }
    Link<E> setNext(Link<E> nextval)
    { return next = nextval; }
    E element() { return element; }
    E setElement(E it) { return element = it; }

    @Override
    public String toString() {
        return "Link{" +
                "element=" + element +
                ", next=" + next +
                '}';
    }
}
