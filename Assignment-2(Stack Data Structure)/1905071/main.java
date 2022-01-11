import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int size=input.nextInt();
        int direction=1;
        Integer[] arr=new Integer[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=input.nextInt();
        }
        Arr<Integer> array=new Arr<>(arr,direction);
//        Lstack<Integer>array=new Lstack<>(arr);
       print(array,direction);
        String res="-1";
        while (true)
        {
            int p,q;
            q=input.nextInt();
            p=input.nextInt();
            if(q==0)break;
            if(q==1)
            {
                res="-1";
                array.clear();
            }
            if(q==2)
            {
                res="-1";
                array.push(p);
            }
            if(q==3)
            {
                res= Integer.toString(array.pop());
            }
            if(q==4)
            {
                res= Integer.toString(array.length());
            }
            if(q==5)
            {
                if(array.topValue()==null)
                    res="null";
                else
                res= Integer.toString(array.topValue());
            }
            if(q==6)
            {
                res="-1";
                direction=p;
                array.setDirection(p);
            }
            print(array,direction);
            System.out.println(res);

        }

    }

    private static void print(Arr<Integer> array,int direction) {
        System.out.print("< ");
        int[] arr=new int[array.length()];

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=array.pop();
        }
        for(int i=arr.length-1;i>=0;i--)
        {
            array.push(arr[i]);
            if(direction==1)
            System.out.print(arr[i]+" ");
            else System.out.print(arr[arr.length-i-1]+" ");
        }
        System.out.println(">");
    }
}
