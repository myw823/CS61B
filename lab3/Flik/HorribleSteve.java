package Flik;
import org.junit.Test;
import static org.junit.Assert.*;

public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            System.out.println(String.valueOf(i) + String.valueOf(j));
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }

    @Test
    public void TestisSameNumber() {
        assertTrue(Flik.isSameNumber(356, 356));
        assertFalse(Flik.isSameNumber(87, 5));
    }
}
