import java.util.Scanner;

public class Arr_implementation_checking {
    public static void main(String[] args) {
        int K,X;
        Scanner input=new Scanner(System.in);
        K=input.nextInt();
        X=input.nextInt();
        Integer[] temp=new Integer[K];
        for(int i=0;i<K;i++)
        {
            temp[i]=input.nextInt();
        }
//        Arr<Integer> arr=new Arr<>(K,X,temp);
        LList<Integer>arr=new LList<>(temp);
        print(arr);
        int res=-1;
        while (true)
        {

            int q,p;
            q=input.nextInt();
            p=input.nextInt();
            if(q==0)break;
            if(q==1){
                res=-1;arr.clear();}
            if(q==2){
                res=-1;arr.insert(p);}
            if(q==3){
                res=-1;arr.append(p);}
            if(q==4) {
                System.out.println(arr.remove());
                print(arr);
                continue;
            }
            if(q==5){
                res=-1;arr.moveToStart();}
            if(q==6){
                res=-1;arr.moveToEnd();}
            if(q==7){
                res=-1;arr.prev();}
            if(q==8){
                res=-1;arr.next();}
            if(q==9) res=arr.length();
            if(q==10) res=arr.currPos();
            if(q==11){
                res=-1;arr.moveToPos(p);}
            if(q==12){
                res=arr.getValue();}
            if(q==13) res=arr.Search(p);
            print(arr);
            System.out.println(res);
        }

    }
    public static void print(LList<Integer>arr)
    {
        System.out.print("< ");
        int pos=arr.currPos();
        arr.moveToStart();
        for(int i=0;i<arr.length();i++)
        {
            if(pos==i)
                System.out.print("| ");
            System.out.print(arr.getValue()+" ");
            if(i<arr.length()-1)
            arr.next();
        }
        arr.moveToPos(pos);
        System.out.println(" >");
    }


}




