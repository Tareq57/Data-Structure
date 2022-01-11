import java.util.Arrays;

public class Arr<T> implements List_ADT<T>{
    private int curr_pos;
    private int list_size;
    private int max_size;
    private T[] array;
    private int default_size;

    public Arr() {
        list_size=0;
        curr_pos=0;
        max_size=1;
        default_size=1;
        array=(T[]) new Object[max_size];
    }
    public  Arr(T[] list)
    {
        this.list_size=list.length;
        this.max_size=list_size;
        default_size=max_size;
        curr_pos=0;
        array=(T[])new Object[max_size];
        for(int i=0;i<list_size;i++)
        {
            array[i]=list[i];
        }
    }
    public Arr(int list_size, int max_size, T[] list) {
        this.list_size = list_size;
        this.max_size = max_size;
        default_size=max_size;
        curr_pos=0;
        array=(T[]) new Object[max_size];
        for(int i=0;i<list_size;i++)
        {
            array[i]=list[i];
        }

    }

    @Override
    public void clear() {
        list_size=0;
        curr_pos=0;

    }

    @Override
    public void insert(T item) {
        if(list_size==max_size)
        {
            max_size=max_size+default_size;
            T[] temp=array;
            array=(T[]) new Object[max_size];
            for(int i=0;i<list_size;i++)
            {
                array[i]=temp[i];
            }
        }
        for(int i=list_size-1;i>=curr_pos;i--)
        {
            array[i+1]=array[i];
        }
        array[curr_pos]=item;
        list_size++;

    }

    @Override
    public void append(T item) {
        if(list_size==max_size)
        {
            max_size=max_size+default_size;
            T[] temp=array;
            array=(T[]) new Object[max_size];
            for(int i=0;i<list_size;i++)
            {
                array[i]=temp[i];
            }
        }
        array[list_size]=item;
        list_size++;

    }

    @Override
    public T remove() {
        if(curr_pos<0||curr_pos>=list_size)
        {
            return null;
        }
        else {
            T item=array[curr_pos];
            for(int i=curr_pos;i<list_size-1;i++)
            {
                array[i]=array[i+1];
            }
            list_size--;
            if(list_size==curr_pos)
            {
                curr_pos--;
                if(curr_pos<0)curr_pos=0;
            }
            return item;
        }

    }

    @Override
    public void moveToStart() {
        curr_pos=0;
    }

    @Override
    public void moveToEnd() {

        curr_pos=list_size-1;
    }

    @Override
    public void prev() {

        curr_pos--;
        if(curr_pos<0)
        {
            curr_pos++;
            return;
        }
    }

    @Override
    public void next() {

        curr_pos++;
        if(curr_pos==list_size)
        {
            curr_pos=list_size-1;
            return;
        }
    }

    @Override
    public int length() {
        return list_size;
    }

    @Override
    public int currPos() {
        return curr_pos;
    }

    @Override
    public void moveToPos(int pos) {
        if(pos>=list_size||pos<0)
        {
            return;
        }
        curr_pos=pos;
    }

    @Override
    public T getValue() {
        if(curr_pos<0||curr_pos>=list_size)
            return  null;
        else
        {
            return array[curr_pos];
        }

    }

    @Override
    public int Search(T item) {
        int pos=-1;
        for(int i=0;i<list_size;i++)
        {
            if(item.equals(array[i]))
            {
                pos=i;
                break;
            }
        }

        return pos;
    }
}
