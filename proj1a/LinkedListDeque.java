public class LinkedListDeque<T> implements Deque<T>{
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node curr = sentinel.next;
        while (curr != sentinel){
            System.out.print(curr.item.toString() + ' ');
            curr = curr.next;
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (sentinel.next == null || size == 0) {
            return null;
        }
        Node toRemove = sentinel.next;
        toRemove.next.prev = sentinel;
        sentinel.next = toRemove.next;
        size--;
        return toRemove.item;
    }

    @Override
    public T removeLast() {
        if (sentinel.prev == null || size == 0) {
            return null;
        }
        Node toRemove = sentinel.prev;
        toRemove.prev.next = sentinel;
        sentinel.prev = toRemove.prev;
        size--;
        return toRemove.item;
    }

    @Override
    public T get(int index) {
        Node curr = sentinel.next;
        while (index != 0) {
            curr = curr.next;
            if (curr == sentinel) return null;
            index--;
        }
        return curr.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper (int index, Node curr) {
        if (curr == sentinel) return null;
        if (index == 0) return curr.item;
        return getRecursiveHelper(index-1, curr.next);
    }


    /*public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>();
        boolean emptyOrNot = deque.isEmpty();
        deque.addLast(3);
        deque.addLast(4);
        deque.addFirst(2);
        deque.addFirst(1);
        emptyOrNot = deque.isEmpty();
        deque.printDeque();
        deque.addFirst(111);
        deque.addLast(999);
        deque.printDeque();
        deque.removeFirst();
        deque.removeLast();
        deque.printDeque();
        int thirdNumber = deque.getRecursive(2);
        int fifthNumber = deque.getRecursive(4);
        System.out.println(fifthNumber);
    }*/
}
