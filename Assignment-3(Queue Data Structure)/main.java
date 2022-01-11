import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int size=input.nextInt();
        Integer[] arr=new Integer[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=input.nextInt();
        }
//        AQueue<Integer> array=new AQueue<>(arr);
        LQueue<Integer> array=new LQueue<>(arr);
        print(array);
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
                array.enqueue(p);
            }
            if(q==3)
            {
                res= Integer.toString(array.dequeue());
            }
            if(q==4)
            {
                res= Integer.toString(array.length());
            }
            if(q==5)
            {
                res= Integer.toString(array.frontValue());
            }
            if(q==6)
            {
                res= Integer.toString(array.rearValue());
            }
            if(q==7)
            {
                res=Integer.toString(array.leaveQueue());
            }
            print(array);
            System.out.println(res);

        }

    }

    private static void print(LQueue<Integer> array) {
        System.out.print("< ");
        int[] arr=new int[array.length()];

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=array.dequeue();
        }
        for (int j : arr) {
            array.enqueue(j);
            System.out.print(j + " ");
        }
        System.out.println(">");
    }
}
