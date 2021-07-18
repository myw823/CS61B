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

    // overloading isPalindrome() method
    public boolean isPalindrome(String word, CharacterComparator cc) {
        for (int i=0, j=word.length()-1; i<j; i++,j--) {
            if (!cc.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
        }
        return true;
    }

}
