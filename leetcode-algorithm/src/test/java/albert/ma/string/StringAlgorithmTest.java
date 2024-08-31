/**
 * 
 */
package albert.ma.string;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class StringAlgorithmTest {

     StringAlgorithm s;
     @Before
     public void setup() {
        s = new StringAlgorithm(); 
     }
     
     @Test
     public void reverseStringTest() {
         char[] a = {'h','e','l','l','o'};
         s.reverseString(a);
         char[] b = {'o','l','l','e','h'};
         assertArrayEquals(b,a);
     }
    
}
