public class ArrayDeque<T> {
    private T[] items;
    private int itemsCount;

    public ArrayDeque() {
        items = new Object[8];
        itemsCount = 0;
    }

    private void doubleSize() {
        T[] newArr = new Object[itemsCount * 2];
        System.arraycopy(items , 0, newArr, 0, arr.length);
        items= newArr;
    }

    private void halveSize() {
        T[] newArr = new Object[itemsCount / 2];
        System.arraycopy(items , 0, newArr, 0, arr.length);
        items= newArr;
    }

    public void addFirst(T item) {
        if(itemsCount == items.length) {
            doubleSize();
        }
        System.arraycopy(items, 0, items, 1, itemsCount);
        items[0] = item;
        itemsCount++;
    }

    public void addLast(T item) {
        if(itemsCount == items.length) {
            doubleitemsCount();
        }
        items[itemsCount] = item;
        itemsCount++;
    }

    public boolean isEmpty() {
        return itemsCount == 0;
    }

    public int itemsCount() {
        return itemsCount;
    }

    public void printDeque() {
        System.out.println(String.join(' ',items));
    }

    public T removeFirst() {
        if (items.length >= 16 && itemsCount < (items.length / 4) ) {
            halveSize();
        }
        T removed = items[0];
        System.arraycopy(items, 1, items, 0, itemsCount - 1);
        itemsCount--;
        return removed;
    }

    public T removeLast() {
        if (items.length >= 16 && itemsCount < (items.length / 4) ) {
            halveSize();
        }
        T removed = items[itemsCount - 1];
        items[itemsCount - 1] = null;
        itemsCount--;
        return removed;
    }

    public T get(int index) {
        return items[index];
    }


}
