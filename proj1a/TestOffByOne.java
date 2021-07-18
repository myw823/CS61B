import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestequalChars() {
        assertTrue("a b", offByOne.equalChars('a', 'b'));
        assertTrue("r q", offByOne.equalChars('r', 'q'));
        assertTrue("& %", offByOne.equalChars('&', '%'));

        assertFalse("a a", offByOne.equalChars('a', 'a'));
        assertFalse("z a", offByOne.equalChars('z', 'a'));
        assertFalse("a B", offByOne.equalChars('a', 'B'));

    }
}
