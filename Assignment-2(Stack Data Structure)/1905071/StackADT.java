public interface StackADT<E>{
    void clear();
    void push(E item);
    E pop();
    int length();
    E topValue();
}
