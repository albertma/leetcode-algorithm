/**
 * 
 */
package albert.ma.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 */
public class BackPackSolution {

    /**
     * Given an integer n, return the least number of perfect square numbers that sum to n.
     * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. 
     * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     * 
     * Solution
     * Consider 
     * 
     * f[i] = 1+ min(f[i-j^2]) (from j=1 to sqrt(i))
     * @param n
     * @return
     */
    public int numSquares(int n) {
        
        int []dp = new int[n+1];
        dp[0] = 0;
        for(int i=1; i <= n; i++) {
           
            int minn = Integer.MAX_VALUE;
            for(int j=1; j*j<= i; j++) {
                minn = Math.min(minn, dp[i-j*j]);
            }
            dp[i] = minn + 1;//
        }
        return dp[n];
    }
    
    /**
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
     * You may assume that you have an infinite number of each kind of coin.
     * The answer is guaranteed to fit into a signed 32-bit integer.
     * 
     * Solution:
     * dp[0] = 1;
     * loop j in coin amount
     * loop i from amount- currentcoin to amount
     *    dp[i]+=dp[i-j] 
     * 
     * 
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[]coins) {
        int n = amount + 1;
        int m = coins.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i= 0; i < m; i++) {
            System.out.println("---------current coin:" + coins[i]);
            for(int j= coins[i]; j <= amount; j++ ) {
                int currIndex = j-coins[i];
                System.out.println("dp[" + j + "] += dp[" + currIndex +"]");
                dp[j] += dp[currIndex];
//                System.out.println("j:"+ j + " dp:" + Arrays.toString(dp));
            }
        }
        
        System.out.println("dp:" + Arrays.toString(dp));
        return dp[amount];

    }
    
   /**
    * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
    * The test cases are generated so that the answer can fit in a 32-bit integer.
    * 
    * 
    * @param nums
    * @param target
    * @return
    */
    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int j = 0; j < nums.length; j++) {
                int left = i - nums[j];
                if(left >= 0) {
                    dp[i] += dp[left];
                }
            }
        }
        return dp[target];
    }
    
    /**
     * You are given an array of binary strings strs and two integers m and n.
     * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
     * A set x is a subset of a set y if all elements of x are also elements of y.
     * dp[i][j][k] 表示前i个字符串中， 使用j个0和k个1的情况下最多可以得到的字符串数量。假设数组str的长度的l，则最终答案为dp[l][m][n]
     * 
     * 
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        
        return 0;

    }
}




























