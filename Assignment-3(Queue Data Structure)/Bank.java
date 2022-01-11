import java.util.Scanner;
public class Bank {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int time=0,time1=0,time2=0;
        int[] time_check=new int[3];
        customer[] customers=new customer[n];
        LQueue<customer> booth1=new LQueue<>();
        LQueue<customer> booth2=new LQueue<>();
        LQueue<customer> teller1=new LQueue<>();
        LQueue<customer> teller2=new LQueue<>();

//        AQueue<customer> booth1=new AQueue<>();
//        AQueue<customer> booth2=new AQueue<>();
//        AQueue<customer> teller1=new AQueue<>();
//        AQueue<customer> teller2=new AQueue<>();
        for(int i=0;i<n;i++)
        {
            int enter=input.nextInt();
            int service=input.nextInt();
            customers[i]=new customer(enter,service);
            customers[i].setId(i);
        }
        int pos=0;
        while (booth1.length()!=0||booth2.length()!=0||teller1.length()!=0||teller2.length()!=0||pos<n)
        {
            //if its time to leave the customer in teller1
            if(teller1.length()!=0&&time==teller1.frontValue().getLeave())
            {
                customers[teller1.frontValue().getId()].setQueue(1);
                customers[teller1.frontValue().getId()].setLeave(teller1.frontValue().getLeave());
//                System.out.println("At time "+(time)+" customer "+(teller1.frontValue().getId()+1)+" leaves from teller1");
                teller1.dequeue();
            }
            //if its time leave the customer in teller2
            if(teller2.length()!=0&&time==teller2.frontValue().getLeave())
            {
                customers[teller2.frontValue().getId()].setQueue(2);
                customers[teller2.frontValue().getId()].setLeave(teller2.frontValue().getLeave());
//                System.out.println("At time "+(time)+" customer "+(teller2.frontValue().getId()+1)+" leaves from teller2");
                teller2.dequeue();
            }
            //if teller1 is empty
            if(teller1.length()==0&&booth1.length()!=0)
            {
                if(time1< booth1.frontValue().getEnter())
                    time1=booth1.frontValue().getEnter();
                booth1.frontValue().setLeave(time1+booth1.frontValue().getService());
                time1=booth1.frontValue().getLeave();
                teller1.enqueue(booth1.dequeue());
                time_check[1]= teller1.frontValue().getLeave();
//                System.out.println("At time "+(time)+" customer "+(teller1.frontValue().getId()+1)+" enters into teller1");

            }
            // if teller2 is empty
            if(teller2.length()==0&&booth2.length()!=0)
            {
                if(time2< booth2.frontValue().getEnter())
                    time2=booth2.frontValue().getEnter();
                booth2.frontValue().setLeave(time2+booth2.frontValue().getService());
                time2=booth2.frontValue().getLeave();
                teller2.enqueue(booth2.dequeue());
                time_check[2]= teller2.frontValue().getLeave();
//                System.out.println("At time "+(time)+" customer "+(teller2.frontValue().getId()+1)+" enters into teller2");

            }

            //If in that time we have to enqueue a customer
            if(pos<n&&customers[pos].getEnter()==time)
            {
                if(booth1.length()+ teller1.length()==booth2.length()+ teller2.length())
                {
//                    System.out.println("At time "+time+" customer "+(customers[pos].getId()+1)+"enters booth1");
                    booth1.enqueue(customers[pos]);
                    if(time1==0)time1=time;

                }
                else if((booth1.length()+ teller1.length())> (booth2.length()+ teller2.length()))
                {
//                    System.out.println("At time "+time+" customer"+ (customers[pos].getId()+1)+" enters booth2");
                    booth2.enqueue(customers[pos]);
                    if(time2==0)time2=time;

                }
                else{
//                    System.out.println("At time "+time+" customer "+(customers[pos].getId()+1)+"enters booth1");
                    booth1.enqueue(customers[pos]);
                }

                pos++;
            }

            //customer switching
            if((booth1.length()+ teller1.length())- (booth2.length()+ teller2.length())>1)
            {
                customer item=booth1.leaveQueue();
                booth2.enqueue(item);
//                System.out.println("At time "+time+" customer "+(item.getId()+1)+" switches from booth 1 to booth 2");
            }
            else if((booth2.length()+ teller2.length())-( booth1.length()+ teller1.length())>1)
            {
                customer item=booth2.leaveQueue();
                booth1.enqueue(item);
//                System.out.println("At time "+time+" customer "+(item.getId()+1)+" switches from booth 1 to booth 2");

            }
            if((teller1.length()==0&&booth1.length()!=0)||(teller2.length()==0&&booth2.length()!=0))continue;
            //time calculation
            if(pos<n)
                time_check[0]=customers[pos].getEnter();
            else time_check[0]=0;
            if(teller1.length()==0)
                time_check[1]= 0;
            if(teller2.length()==0)time_check[2]= 0;
            if(time_check[0]>0)time=time_check[0];
            else if(time_check[1]>0)time=time_check[1];
            else if(time_check[2]>0)time=time_check[2];
            for(int i=0;i<3;i++)
            {

                if(time>time_check[i]&&time_check[i]>0)
                    time=time_check[i];

            }
        }
        System.out.println("Booth1 finishes service at t= "+time1);
        System.out.println("Booth2 finishes service at t= "+time2);
    }
}
