/**
 * 
 */
package albert.ma.array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class ArrayAlgorithmTest {
    private ArrayAlgorithm a;
    
    @Before
    public void setup() {
        a = new ArrayAlgorithm();
    }
    
    @Test
    public void backspaceCompareTest() {
        assert(a.backspaceCompare("ab##", "c#d#"));
        assert(a.backspaceCompare("ab#c", "ad#c"));
        assert(!a.backspaceCompare("a#c", "b"));
       
    }
    
    @Test
    public void sortedSquaresTest() {
        int[] s = new int[]{-4,-1,0,3,10};
        assertArrayEquals(new int[] {0,1,9,16,100}, a.sortedSquares(s));
        assertArrayEquals(new int[] {4,9,9,49,121}, a.sortedSquares(new int[] {-7,-3,2,3,11}));
    }
    
}
