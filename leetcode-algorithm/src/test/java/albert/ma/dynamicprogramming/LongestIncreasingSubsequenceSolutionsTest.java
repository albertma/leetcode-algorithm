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
    
    @Test
    public void findLongestChainTest() {
        int[][] pairs = {{1,2}, {2, 3}, {3,4}};
        int size = s.findLongestChain(pairs);
        System.out.println("longest chain size:" + size);
    }
    
    @Test
    public void findLongestChainTest1() {
        //int[][] pairs = {{1,2}, {7, 8}, {4,5}};
        //int[][] pairs = {{3,4},{2,3},{1,2}};
        int[][] pairs = {{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};
        int size = s.findLongestChain(pairs);
        System.out.println("longest chain size:" + size);
    
    }
    @Test
    public void findLongestChainTest2() {
        //int[][] pairs = {{1,2}, {7, 8}, {4,5}};
        int[][] pairs = {{3,4},{2,3},{1,2}};
        //int[][] pairs = {{-10,-8},{8,9},{-5,0},{6,10},{-6,-4},{1,7},{9,10},{-4,7}};
        int size = s.findLongestChain(pairs);
        System.out.println("longest chain size:" + size);
    
    }
    
    @Test
    public void longestSubsequenceTest() {
//        int [] arr = {1,5,7,8,5,3,4,2,1};
//        int diff = -2;
        int[] arr = {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};
        int diff = 0;
        int count = s.longestSubsequence(arr, diff);
        System.out.println("count size:" + count);
    }
    
}
