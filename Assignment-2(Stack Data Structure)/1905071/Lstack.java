public class Lstack<E> implements StackADT<E> {
    private node<E> top; // Pointer to first element
    private int size=0; // Number of elements
    public Lstack() { top =new node(null,null);size = 0; }
    public Lstack(int size) { top =new node(null,null); size = 0; }
    public Lstack(E[] array)
    {
        top =new node(null,null);
        int check=array.length;
        for(int i=0;i<check;i++)
        {
            push(array[i]);
        }
        size=check;
    }
    public void clear() { top = new node(null,null); size = 0; }
    public void push(E item) {
        top = new node<E>(item, top);
        size++;
    }
    public E pop() {
        E it = top.item();
        top = top.next();
        size--;
        return it;
    }
    public E topValue() {
       return top.item();
    }
    public int length() { return size; }
}

class node<E> {
    private E item;
    private node<E> next;
    node(E item, node<E> next_item)
    { this.item=item; next = next_item; }
    node(node<E> next_item) { next = next_item; }
    node<E> next() { return next; }
    node<E> setNext(node<E> next_item)
    { return next = next_item; }
    E item() { return item; }
    E set_item(E item) { return this.item=item; }

}
