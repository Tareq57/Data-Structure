public class Arr<E> implements StackADT<E>{

    private int defaultSize ;
    private int maxSize;
    private int top;
    private int direction;
    private E [] listArray;
    Arr() {
        maxSize=1;
        top=0;
        defaultSize=maxSize;
        listArray=(E[])new Object[maxSize];
        direction=1;
    }
    Arr(int size) {
        maxSize = size;
        top = 0;
        defaultSize=maxSize;
        listArray = (E[])new Object[size];
        direction=1;
    }
    Arr(int size, int direction)
    {
        maxSize = size;
        top = 0;
        defaultSize=maxSize;
        listArray = (E[])new Object[size];
        if(direction==-1)
            top=size-1;
        this.direction=direction;

    }
    public Arr(E[] list,int direction) {
        this.maxSize = list.length;
        defaultSize = maxSize;
        this.direction=direction;

        if(direction==-1)
        {

            top=maxSize-1;
        }
        else
        {
            if(list[0]!=null)
            top=maxSize;
            else top=0;
        }
        if(list[0]!=null)
        listArray = (E[]) new Object[2*maxSize];
        else
            listArray=(E[]) new Object[maxSize];
        if(direction==1)
        for (int i = 0; i < maxSize; i++) {
            listArray[i] = list[i];
        }
        else
        {
            for(int i=maxSize;i< listArray.length;i++)
            {
                listArray[i]=list[i-maxSize];
            }

        }


    }
    public void clear() {
        if(direction==-1)top=listArray.length-1;
        else top=0;


    }
    public void push(E it) {
        if(direction==1){

            if(top!=maxSize)
            listArray[top++] = it;
            else
            {
                maxSize = maxSize + maxSize;
                E[] temp = listArray;
                listArray = (E[]) new Object[maxSize];
                for (int i = 0; i < temp.length; i++) {
                    listArray[i] = temp[i];
                }
                listArray[top++]=it;
            }
        }
        else
        {
            if(top>=0)
                listArray[top--] = it;
            else
                {
                    maxSize = maxSize + maxSize;
                    E[] temp = listArray;
                    listArray = (E[]) new Object[maxSize];
                    for (int i = maxSize-1; i > maxSize- temp.length; i++) {
                        listArray[i] = temp[i];
                    }
                    top=maxSize-temp.length-1;
                    listArray[top--]=it;
                }

        }
    }
    public E pop() {
        E item=null;
        if(direction==1)
        {
            if(top!=0)
            {
                item=listArray[--top];
            }
            else
            {
                System.out.println("Array is Empty");
            }
        }
        else
        {
            if(top!=listArray.length) {
                item = listArray[++top];
            }

        }
        return item;
    }
    public int length() { if(direction==1)return top;
    else return listArray.length-top-1;}
    public E topValue() {
        E item=null;
        if(direction==1&&top>0)item= listArray[top-1];
        else if(top+1<maxSize&&direction==-1) item= listArray[top+1];
        return item;
    }

    public void setDirection(int p) {
        if(direction==1&&top==0)
            direction=p;
        else if(direction==-1&&top==listArray.length-1)
        {
            direction=p;
        }
        if(direction==1)top=0;
        else top=listArray.length-1;
    }
}
