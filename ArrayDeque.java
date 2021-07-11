import java.util.Arrays;

public class ArrayDeque<T> {
    private T[] items;
    private int itemsCount;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        itemsCount = 0;
        nextFirst = items.length / 2 - 1;
        nextLast = items.length / 2;
    }

    private void doubleSize() {
        T[] newArr = (T[]) new Object[items.length * 2];
        System.arraycopy(items, 0, newArr, newArr.length / 4, itemsCount);
        nextFirst = (newArr.length / 4) - 1;
        nextLast = (newArr.length / 4) + itemsCount;
        items = newArr;
    }

    private void halveSize() {
        T[] newArr = (T[]) new Object[items.length / 2];
        System.arraycopy(items, nextFirst + 1, newArr, newArr.length / 4, itemsCount);
        nextFirst = (newArr.length / 4) - 1;
        nextLast = (newArr.length / 4) + itemsCount;
        items = newArr;
    }

    public void addFirst(T item) {
        if (items[nextFirst] != null) {
            doubleSize();
        }
        items[nextFirst] = item;
        nextFirst--;
        if (nextFirst < 0) {
            nextFirst = items.length - 1;
        }
        itemsCount++;
    }

    public void addLast(T item) {
        if (items[nextLast] != null) {
            doubleSize();
        }
        items[nextLast] = item;
        nextLast++;
        if (nextLast >= items.length) {
            nextLast = 0;
        }
        itemsCount++;
    }

    public boolean isEmpty() {
        return itemsCount == 0;
    }

    public int itemsCount() {
        return itemsCount;
    }

    public void printDeque() {
        if(itemsCount == 0) System.out.println("No item in deque");
        else if(nextFirst < nextLast) {
            System.out.println(String.join(' ',Arrays.copyOfRange(items, nextFirst + 1, nextLast) ) );
        }
        else if(nextFirst >= nextLast) {
            System.out.print(String.join(' ',Arrays.copyOfRange(items, nextFirst + 1, items.length) ) );
            System.out.println(String.join(' ',Arrays.copyOfRange(items, 0, nextLast) ) );
        }
    }

    public T removeFirst() {
        if(itemsCount <= items.length * 0.25) {
            halveSize();
        }
        T toRemove = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        itemsCount -= 1;
        return toRemove;
    }

    public T removeLast() {
        if(itemsCount <= items.length * 0.25) {
            halveSize();
        }
        T toRemove = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;
        itemsCount -= 1;
        return toRemove;

    }

    public T get(int index) {
        if(nextFirst + 1 + index >= items.length) {
            return items[nextFirst + 1 + index - items.length];
        }
        return items[nextFirst + 1 + index];
    }
}

