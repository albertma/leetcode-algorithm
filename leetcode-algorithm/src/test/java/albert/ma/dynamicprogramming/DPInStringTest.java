/**
 * 
 */
package albert.ma.dynamicprogramming;

import static org.junit.Assert.assertEquals;

import org.junit.Test;



/**
 * 
 */
public class DPInStringTest {

    @Test
    public void testLongestPalidromeSubseq() {
       DPInString p = new DPInString();
       int longest = p.longestPalidromeSubseq("bbbab");
       assertEquals(longest, 4);
    }
    
    @Test
    public void  longestPalidromeSubstring() {
        DPInString p = new DPInString();
        String str = p.longestPalindrome1("aaaa");
        System.out.println("longest str:"+ str);
    }
    
    @Test
    public void longestPalidromeSubstring2() {
        DPInString p = new DPInString();
        String str = p.longestPalindrome2("cbbd");
        System.out.println("longest str:" + str);
    }
}
