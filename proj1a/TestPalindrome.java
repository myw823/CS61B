import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void TestPalindrome() {
        String inputWord = "rotator";
        Palindrome palindrome = new Palindrome();
        boolean actual = palindrome.isPalindrome(inputWord);

        assertTrue(inputWord, actual);

        inputWord = "cat";
        actual = palindrome.isPalindrome(inputWord);
        assertFalse(inputWord+" should return false", actual);

        assertTrue("denned should return true", palindrome.isPalindrome("denned"));

        assertTrue("z", palindrome.isPalindrome("z"));
        assertTrue("", palindrome.isPalindrome(""));


        
    }
}

