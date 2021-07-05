

public class LinkedListDeque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;
    
        public Node(T item) {
            this.item = item;
        }
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private Node sentinel;
    private int size;

    public LinkedListDeque(T sentinelItem) {
        size = 0;
        sentinel = new Node(sentinelItem);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node curr = sentinel.next;
        while (curr != sentinel){
            System.out.print(curr.item.toString() + ' ');
            curr = curr.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        Node toRemove = sentinel.next;
        toRemove.next.prev = sentinel;
        sentinel.next = toRemove.next;
        size--;
        return toRemove.item;
    }

    public T removeLast() {
        Node toRemove = sentinel.prev;
        toRemove.prev.next = sentinel;
        sentinel.prev = toRemove.prev;
        size--;
        return toRemove.item;
    }

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

    public T getRecursiveHelper (int index, Node curr) {
        if (curr == sentinel) return null;
        if (index == 0) return curr.item;
        return getRecursiveHelper(index-1, curr.next);
    }


    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(0);
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
    }
}