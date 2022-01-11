public class BST<Key,T extends Comparable<? super T>> implements BST_Interface<T> {
    private BSTNode<Key,T> root;
    private int cnt;

    public BST(BSTNode<Key, T> root, int cnt) {
        this.root = root;
        this.cnt = cnt;
    }

    public BST() {
        root=null;
        cnt=0;
    }
    @Override
    public void Insert(T item)
    {
        if(root==null)
        {
            root=new BSTNode<>(item);
        }
        else
        root=InsertHelp(root,item);
        cnt++;
        printBST(root);
        System.out.println();
    }
    @Override
    public void Delete(T item) {
        if(Find(item))
        {

            root=DeleteHelp(root,item);
            printBST(root);
            System.out.println();
            cnt--;
        }
        else System.out.println("Invalid Operation");
    }
    @Override
    public boolean Find(T item) {
        return FindHelp(root,item);
    }


    private BSTNode<Key,T> InsertHelp(BSTNode<Key,T> root, T item) {
        if(root==null){return  new BSTNode<>(item);}
        if(root.element().compareTo(item)>0)
             root.setLeft(InsertHelp(root.left(),item));
        else  root.setRight(InsertHelp(root.right(),item));
        return root;
    }


    private BSTNode<Key,T> DeleteHelp(BSTNode<Key,T> root, T item) {
        if(root.element().compareTo(item)==0)
        {
            if(root.left()==null)return root.right();
            else if(root.right()==null)return root.left();
            else {
                BSTNode<Key,T> temp=FindMin(root.right());
                root.setElement(temp.element());
                root.setRight(DeleteMin(root.right()));
            }
        }
        else if(root.element().compareTo(item)>0)
             root.setLeft(DeleteHelp(root.left(),item));
        else root.setRight(DeleteHelp(root.right(),item));
        return root;
    }
    private boolean FindHelp(BSTNode<Key,T> root, T item) {
        if(root==null)return false;
        else if(root.element().compareTo(item)==0)return true;
        else if(root.element().compareTo(item)>0)return FindHelp(root.left(),item);
        else return FindHelp(root.right(),item);

    }
    private BSTNode<Key,T> DeleteMin(BSTNode<Key,T> root) {
        if(root.left()==null)return root.right();
        else root.setLeft(DeleteMin(root.left()));
        return root;
    }

    private BSTNode<Key,T> FindMin(BSTNode<Key,T> root) {
        if(root.left()==null)return root;
        else return FindMin(root.left());
    }


    @Override
    public void InOrder() {
        InOrderHelp(root);
        System.out.println();
    }

    private void InOrderHelp(BSTNode<Key,T> root) {
        if(root==null)return;
        InOrderHelp(root.left());
        System.out.print(root.element()+" ");
        InOrderHelp(root.right());
    }

    @Override
    public void PostOrder() {
        PostOrderHelp(root);
        System.out.println();
    }

    private void PostOrderHelp(BSTNode<Key,T> root) {
        if(root==null)return;
        PostOrderHelp(root.left());
        PostOrderHelp(root.right());
        System.out.print(root.element()+" ");
    }

    @Override
    public void PreOrder() {
        PreOrderHelp(root);
        System.out.println();
    }

    private void PreOrderHelp(BSTNode<Key,T> root) {
        if(root==null)return;
        System.out.print(root.element()+" ");
        PreOrderHelp(root.left());
        PreOrderHelp(root.right());
    }


    //Print helper function
    private void printBST(BSTNode<Key,T> root) {
        if(root==null)return;
        System.out.print(root.element());
        if(root.left()!=null||root.right()!=null) {
            System.out.print("(");
            printBST(root.left());
            System.out.print(")");
            System.out.print("(");
            printBST(root.right());
            System.out.print(")");
        }

    }

}
