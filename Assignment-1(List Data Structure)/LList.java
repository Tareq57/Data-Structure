import java.util.List;

public class LList<T> implements List_ADT<T>{
    private node<T> head;
    private node<T> tail;
    private node<T>curr=new node<>(null,null);
    private int lise_size;

    public LList() {
        curr = tail = head = new node<T>(null,null);
        lise_size=0;
    }

    public LList(T[] temp) {
        this.lise_size = temp.length;
        tail=new node<>(temp[lise_size-1],null);
        curr=tail;
        if(lise_size==1)
        {
            head=tail;// list size jodi 1 hoy taile tail ar head same
        }
        for(int i=lise_size-2;i>=0;i--)
        {
            curr=new node<>(temp[i],curr);
            if(i==0)
                head=curr;
        }
        curr=new node<>(null,head);

    }

    @Override
    public void clear() {
        curr = tail = head = new node<>(null,null);
        lise_size = 0;
    }

    @Override
    public void insert(T item) {
        curr.setNext(new node<>(item, curr.next()));
        if (tail == curr) tail = curr.next();
        lise_size++;
    }

    @Override
    public void append(T item) {
        tail = tail.setNext(new node(item, null));
        lise_size++;
    }

    @Override
    public T remove() {
        if (curr.next()== null||lise_size==0) return null;
        T item = curr.next().item();
        lise_size--;
        if (tail == curr.next()) {
            tail = curr;
            curr=new node<>(null,head);
            for(int i=0;i<lise_size;i++)
            {
                if(curr.next()==tail)
                {
                    break;
                }
                curr=curr.next();
            }
        }
        else if(curr.next()==head)
        {
            curr.setNext(head.next());
            head=head.next();
        }
        else
        curr.setNext(curr.next().next());
        return item;
    }

    @Override
    public void moveToStart() {
        curr=new node<>(null,head);
    }

    @Override
    public void moveToEnd() {
        curr=head;
        for(int i=1;curr.next()!=tail;i++)
        {
            curr=curr.next();
        }
    }

    @Override
    public void prev() {
        if (curr.next() == head) return;
        node<T> temp = head;
        while (temp.next() != curr) temp = temp.next();
        curr = temp;
    }

    @Override
    public void next() {
        if (curr.next() != tail) curr = curr.next();
    }

    @Override
    public int length() {
        return lise_size;
    }

    @Override
    public int currPos() {
        if(curr.next()==null)
            return -1;
        node<T> temp = head;
        int i;
        for (i=0; curr.next() != temp; i++)
            temp = temp.next();
        return i;

    }

    @Override
    public void moveToPos(int pos) {
        if(pos>=lise_size||pos<0)
        {
            return;
        }
        curr=new node<>(null,head);
        for(int i=0;i<pos;i++)
        {
            curr=curr.next();
        }
    }

    @Override
    public T getValue() {
        if(curr.next()==null)return null;
        return curr.next().item();
    }

    @Override
    public int Search(T item) {
        int pos=-1;
        node<T> temp=head;
        for(int i=0;i<lise_size;i++)
        {
            if(temp.item().equals(item))
            {
                pos=i;
                break;
            }
            temp=temp.next();
        }
        return pos;
    }
}
class node<T> {
    private T item;
    private node<T> next;
    node(T item, node<T> next_item)
    { this.item=item; next = next_item; }
    node(node<T> next_item) { next = next_item; }
    node<T> next() { return next; }
    node<T> setNext(node<T> next_item)
    { return next = next_item; }
    T item() { return item; }
    T set_item(T item) { return this.item=item; }

}
