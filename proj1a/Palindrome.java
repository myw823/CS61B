public class Palindrome {

    public Deque wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i=0; i<word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque deque = wordToDeque(word);
        return isPalindromeHelper(deque);
    }

    private boolean isPalindromeHelper(Deque deque) {
        if (deque.size() <= 1) {
            return true;
        } else if (deque.removeFirst() != deque.removeLast()) {
            return false;
        }
        return isPalindromeHelper(deque);
    }

}
