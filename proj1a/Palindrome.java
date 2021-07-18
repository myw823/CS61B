public class Palindrome {
    public Deque wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i=0; i<word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }
}
