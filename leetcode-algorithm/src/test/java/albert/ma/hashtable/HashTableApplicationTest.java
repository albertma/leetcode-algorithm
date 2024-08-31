/**
 * 
 */
package albert.ma.hashtable;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */
public class HashTableApplicationTest {

    private HashTableApplication app;
    
    @Before
    public void setup() {
        app = new HashTableApplication();
    }
    
    
    @Test
    public void isAnagramTest() {
        String s = "anagram", t = "nagaram";
        assert(app.isAnagram(s, t));
    }
    
    @Test
    public void isHappyTest() {
       
        assert(app.isHappy(19));
        assert(!app.isHappy(2));
    }
    
    @Test
    public void twoSumTest() {
        int[] indices = app.twoSum(new int[] {3,2,4}, 6);
        System.out.println(Arrays.toString(indices));
        assertArrayEquals(new int[] {0,0}, indices );
    }
}
