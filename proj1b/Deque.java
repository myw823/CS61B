public interface Deque<T>{

    public void addFirst(T T);

    public void addLast(T T);

    public boolean isEmpty();

    public int size();

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);

}