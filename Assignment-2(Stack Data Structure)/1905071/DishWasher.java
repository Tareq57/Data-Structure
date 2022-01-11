import java.util.Scanner;

public class DishWasher {
    public static void main(String[] args) {


        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int x=input.nextInt();
        int[] cost = new int[x];
        for(int i=0;i<x;i++)
        {
            cost[i]=input.nextInt();
        }
         Lstack<Integer>friendStack=new Lstack<>();
        //Array Based Implementation
        Arr<Item> dirtyStack=new Arr<>();
        Arr<Item> cleanStack=new Arr<>();


//          Linked list Based Implementation
//        Lstack<Item> dirtyStack=new Lstack<>();
//        Lstack<Item> cleanStack=new Lstack<>();


        //One Array Two Stack Based Implementation
//        Item[] A=new Item[n*x+1];
//        Arr<Item> dirtyStack=new Arr<>(A,1);
//        Arr<Item> cleanStack=new Arr<>(A,-1);


        int free_time=-1;
        while (true)
        {
            int id=input.nextInt();
            int push_time=input.nextInt();
            int item_id=input.nextInt();
            if(item_id==x)
            {
                friendStack.push(id);
            }
            //Extra Checking
            if(cleanStack.length()!=0)
            {
                free_time=cleanStack.topValue().getPush_time();
            }
            //jodi amr time push_time er thekeo kom tokhn push_time porjonto loop chalay shobgulo pop korbo
            while(dirtyStack.length()!=0&&dirtyStack.topValue().getPush_time()+cost[dirtyStack.topValue().getItem_id()-1]<=push_time)
            {
                Item item=dirtyStack.pop();
                free_time= free_time+cost[item.getItem_id()-1];
                cleanStack.push(new Item(item.getId(),free_time, item.getItem_id()));
            }
            //jodi dirtystack ekhono 0 na hoy
            if(dirtyStack.length()!=0)
            {
                Item item=dirtyStack.topValue();
                if(item.getPush_time()>=free_time){
                    if(item.getPush_time()==free_time)
                        free_time= item.getPush_time()+cost[item.getItem_id()-1];
                    else free_time=item.getPush_time()+cost[item.getItem_id()-1]-1;
                }
                else
                {
                    if(id==0&&push_time==0&&item_id==0)
                        break;
                    dirtyStack.push(new Item(id,push_time,item_id));
                    continue;
                }
                cleanStack.push(new Item(item.getId(),free_time,item.getItem_id()));
                dirtyStack.pop();
            }
            if(id==0&&push_time==0&&item_id==0)
                break;
            //finally dirty stack e push
            dirtyStack.push(new Item(id,push_time,item_id));
        }
        //jodi erporeo kisu beche jay tahole again oigula wash korte hbe
        while (dirtyStack.length()!=0)
        {
            Item item=dirtyStack.pop();
            if(item==null)break;
            free_time= free_time+cost[item.getItem_id()-1];
            cleanStack.push(new Item(item.getId(),free_time, item.getItem_id()));
        }
        int size=cleanStack.length();
        int[] res=new int[size];
        for(int i=0;i<size;i++)
        {
            Item item=cleanStack.pop();
            res[i]=item.getPush_time();
        }

        System.out.println(res[0]);
        for(int i=size-1;i>=1;i--)
        {
            System.out.print(res[i]+",");
        }
        System.out.println(res[0]);
        if(friendStack.length()!=n)
            System.out.println("N");
        else System.out.println("Y");
        while (friendStack.length()!=1)
        {
            System.out.print(friendStack.pop()+",");
        }
        if(friendStack.length()==1)
            System.out.println(friendStack.pop());
    }
}
