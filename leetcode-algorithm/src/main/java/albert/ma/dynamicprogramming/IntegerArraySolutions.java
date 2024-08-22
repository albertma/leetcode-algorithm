package albert.ma.dynamicprogramming;



public class IntegerArraySolutions {
    
    /**
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     * 
     * dp[i]为前i个元素，以第i个数字结尾的最长上升子序列的长度，nums【i】必须被选取
     * dp[i]=max(dp[j])+1, 0<=j<i and nums[j]<nums[i]
     * 
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
                if(nums[j]<nums[i]) {
                   dp[i]=Math.max(dp[i], dp[j]+1); 
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
        
    }
}


