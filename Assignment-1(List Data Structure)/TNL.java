import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TNL{
    private  static<T>  void print(Arr<T> list, int size)
    {
        for(int i=0;i<size;i++)
        {
            if(list.getValue().equals(i))
            {
                System.out.print(list.getValue());
                if(i!=size-1){
                    System.out.print(",");
                    list.next();
                }

            }
            else if(i!=size-1)
                System.out.print(",");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int K ,L,M,T;
        Scanner input=new Scanner(System.in);
        K=input.nextInt();
        L=input.nextInt();
        Integer[] B=new Integer[L];
        for(int i=0;i<L;i++)
            B[i]=input.nextInt();
        M=input.nextInt();
        Integer[] TR= new Integer[M];
        for(int i=0;i<M;i++)
            TR[i]=input.nextInt();
        Arrays.sort(B);
        Arrays.sort(TR);
        Arr<Integer>BS=new Arr<>(L,K,B);
        Arr<Integer>TS=new Arr<>(M,K,TR);
//        LList<Integer>BS=new LList<>(B);
//        LList<Integer>TS=new LList<>(TR);
        T=input.nextInt();
        for(int tc=1;tc<=T;tc++)
        {
            if(tc==1) {
                for (int i = 0; i < K - 1; i++)
                    System.out.print(i + ",");
                System.out.println(K - 1);// for printing a new line
                print(BS, K);
                print(TS, K);
            }

        }
    }
}

