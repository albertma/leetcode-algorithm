package albert.ma.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingSubsequence {
    
    /**
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     * 
     * dp[i]为前i个元素，以第i个数字结尾的最长上升子序列的长度，nums【i】必须被选取
     * dp[i]=max(dp[j])+1, 0<=j<i and nums[j]<nums[i]
     * 
     * 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取。
     * 我们从小到大计算 dp 数组的值，在计算 dp[i] 之前，我们已经计算出 dp[0…i−1] 的值，则状态转移方程为：
     * 
     * dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
     * 
     * 即考虑往 dp[0…i−1] 中最长的上升子序列后面再加一个 nums[i]。由于 dp[j] 代表 nums[0…j] 中以 nums[j] 结尾的最长上升子序列，
     * 所以如果能从 dp[j] 这个状态转移过来，那么 nums[i] 必然要大于 nums[j]，才能将 nums[i] 放在 nums[j] 后面以形成更长的上升子序列。
     * 最后，整个数组的最长上升子序列即所有 dp[i] 中的最大值。
     * LIS length=max(dp[i]),其中0≤i<n

     * 
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        if(n == 0) {
            return 0;
        }
        dp[0] = 1;
        int maxLen = 1;
        for(int i= 1; i<n; i++) {
            dp[i] = 1;
           
            for(int j = 0; j<i; j++) {
                //当前的num[i], 查询0~i的nums[j]只要有小于nums[i]
                if(nums[j]<nums[i]) {
                   dp[i]=Math.max(dp[i], dp[j]+1); 
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
        
    }
    
    /**
     * 
     * Given an integer array nums, return the number of longest increasing subsequences.
     * Notice that the sequence has to be strictly increasing.
     * 定义 dp[i] 为考虑前 i 个元素，以第 i 个数字结尾的最长上升子序列的长度，注意 nums[i] 必须被选取
     * cnt[i] 表示以 nums[i] 结尾的最长上升子序列的个数。
     * 设nums的最长上升子序列的长度为maxLen，那么答案为所有满足dp[i] = maxLen的i对应的cnt[i]之和。
     * 
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLen = 0, ans = 0;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }else if(dp[j] + 1 == dp[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            
            if(dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i];
            }else if( dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
        
    }
    
    /**
     * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
     * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
     * Return the length longest chain which can be formed.
     * 
     * @param pairs
     * @return
     */
    public int findLongestChain(int [][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {


            @Override
            public int compare(int[] o1, int[] o2) {
               
                return Integer.compare(o1[0], o2[0]);
            }
        });
     
       
       int n = pairs.length;
       int[] dp = new int[n];
       int maxCount = 0;
       for(int i = 0; i < n; i++) {
           dp[i] = 1;
          
           for(int j = 0; j < i; j++) {
               if(pairs[i][0] > pairs[j][1] ) {
                   dp[i] =  Math.max(dp[i], dp[j]+1);
               }
           }
           if(maxCount < dp[i]) {
               maxCount = dp[i];
           }
           
       }
       return maxCount;
    }
    
    /**
     * dp[i] = dp[j] + 1 if arr[i]-difference =  arr[j]
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {
        
        int maxLen = 1;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for(int value: arr) {
            
            dp.put(value, dp.getOrDefault(value-difference, 0)+1);
            
            maxLen = Math.max(maxLen, dp.get(value));
        }
        return maxLen;
    }
    
    /**
     * Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
     * 
     * @param nums
     * @return
     */
    public int longestArithSeqLength(int[] nums) {
        
        Map<Integer, HashMap<Integer, Integer>> dp  = new HashMap<Integer, HashMap<Integer, Integer>>();
        Integer pre = Integer.MAX_VALUE;
        for(int value: nums) {
            if(pre != Integer.MAX_VALUE) {
                
            }
        }
        return 0;
    }
}
















