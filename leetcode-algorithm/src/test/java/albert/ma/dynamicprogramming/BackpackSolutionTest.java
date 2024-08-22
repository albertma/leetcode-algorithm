package albert.ma.dynamicprogramming;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BackpackSolutionTest {
    
    BackPackSolution s;
    @Before
    public void setup() {
        s = new BackPackSolution();
    }
    
    @Test
    public void numSquareTest() {
        int num = s.numSquares(5);
        System.out.println("5 square num :"+ num);
    }

    @Test
    public void coinChange() {
        int amount = 5; 
        int[] coins = new int[]{1,2};
        int combination = s.change(amount, coins);
        System.out.println("amount:"+ amount + "  coins:"+ Arrays.toString(coins) + "  combination:" + combination);
    }
    
    @Test
    public void combinationSum4Test() {
        int[] nums = new int[] {1,2,3};
        int target = 4;
        int combination = s.combinationSum4(nums, target);
        System.out.println("Combination:"+ combination );
    }
}
