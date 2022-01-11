import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        BST<Integer,Integer> bst=new BST<>();
        try {
            File file = new File("src/BST_testcase.txt");
            Scanner scan=new Scanner(file);
            while (scan.hasNextLine())
            {
                String[] str=scan.nextLine().split(" ");
                if(str[0]!=null&&str[0].equals("I")&&str[1]!=null)
                {
                    int p=Integer.parseInt(str[1]);
                    bst.Insert(p);
                }
                if(str[0]!=null&&str[0].equals("F")&&str[1]!=null)
                {
                    int p=Integer.parseInt(str[1]);
                    if(bst.Find(p)) System.out.println("True");
                    else System.out.println("False");

                }
                if(str[0]!=null&&str[0].equals("D")&&str[1]!=null)
                {
                    int p=Integer.parseInt(str[1]);
                    bst.Delete(p);
                }
                if(str[0]!=null&&str[0].equals("T"))
                {
                    if(str[1].equals("In"))
                        bst.InOrder();
                    if(str[1].equals("Pre"))
                        bst.PreOrder();
                    if(str[1].equals("Post"))
                        bst.PostOrder();
                }
            }
            scan.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

}
