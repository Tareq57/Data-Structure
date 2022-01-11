class BSTNode<Key, T> implements BinNode<T> {
    private Key key;
    private T element;
    private BSTNode<Key,T> left;
    private BSTNode<Key,T> right;
    public BSTNode() {
        left = right = null;
    }
    public BSTNode(Key k, T val)
    {
        left = right = null; key = k; element = val;
    }
    public BSTNode(Key k, T val, BSTNode<Key,T> l, BSTNode<Key,T> r)
    {
        left = l; right = r; key = k; element = val;
    }

    public BSTNode(T element) {
        this.element = element;
        left = right = null; key = null;
    }

    public Key key() { return key; }
    public void setKey(Key k) { key = k; }
    public T element() {
        return element;
    }
    public void setElement(T v) {
        element = v;
    }
    public BSTNode<Key,T> left() {
        return left; }
    public void setLeft(BSTNode<Key,T> p) { left = p; }
    public BSTNode<Key,T> right() { return right; }
    public void setRight(BSTNode<Key,T> p) { right = p; }
    public boolean isLeaf()
    { return (left == null) && (right == null); }
}
