/**
 * 
 */
package albert.ma.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



/**
 * 
 */
public class PalindromicTest {

    @Test
    public void testLongestPalidromeSubseq() {
       Palindromic p = new Palindromic();
       int longest = p.longestPalidromeSubseq("bbbab");
       assertEquals(longest, 4);
    }
    
}
