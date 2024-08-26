package albert.ma.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LongestIncreasingSubsequenceSolutionsTest {
    
    LongestIncreasingSubsequence s;
    @Before
    public void setup(){    
        s = new LongestIncreasingSubsequence();
    }
    
    @Test
    public void lengthOfLISTest() {
        
        int[] a = {0,1,0,3,2,3};
        int len = s.lengthOfLIS(a);
        assertEquals(4, len);
    }
    
    @Test
    public void lOfLISTest() {
        
        int[] a = {7,7,7,7,7,7};
        int len = s.lengthOfLIS(a);
        assertEquals(1, len);
    }

    @Test
    public void findNumberOfLIS() {
        int[] nums = {1,3,5,4,7};
        int counter = s.findNumberOfLIS(nums);
        System.out.println("counter:"+ counter);
    }
    
}
