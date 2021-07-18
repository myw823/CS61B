public class ArrayDeque<T> implements Deque<T> {
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
        System.arraycopy(items, nextFirst+1, newArr, newArr.length/4, items.length-1-nextFirst);
        System.arraycopy(items, 0, newArr, newArr.length / 4 + items.length-1-nextFirst, nextLast+1);
        nextFirst = (newArr.length / 4) - 1;
        nextLast = (newArr.length / 4) + itemsCount;
        items = newArr;
    }

    private void halveSize() {
        T[] newArr = (T[]) new Object[items.length / 2];
        if (nextFirst > nextLast) {
            System.arraycopy(items, nextFirst + 1, newArr, newArr.length / 4, items.length - 1 - nextFirst);
            System.arraycopy(items, 0, newArr, newArr.length / 4 + items.length - 1 - nextFirst, nextLast);
        } else if (nextFirst < nextLast) {
            System.arraycopy(items, nextFirst + 1, newArr, newArr.length / 4, itemsCount);
        }
        
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

    public int size() {
        return itemsCount;
    }

    public void printDeque() {
        int curr = nextFirst + 1;
        while (curr != nextLast - 1) {
            if (curr >= items.length) {
                curr -= items.length;
            }
            System.out.print(items[curr].toString() + ' ');
            curr++;
        }
        System.out.println(items[curr].toString());
    }

    public T removeFirst() {
        if (itemsCount <= items.length * 0.25) {
            halveSize();
        }
        if (itemsCount == 0) {
            return null;
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
        if (itemsCount == 0) {
            return null;
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
   /*public static void main(String[] args) {
        ArrayDeque<Character> answer = new ArrayDeque<Character>();
        answer.addLast('a');
        answer.addLast('b');
        answer.addFirst('c');
        answer.addLast('d');
        answer.addLast('e');
        answer.addFirst('f');
        answer.addFirst('g');
        answer.addLast('h');
        answer.addFirst('i');
    }*/
}
