/**
 * 
 */
package albert.ma.dynamicprogramming;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence 
 * by deleting some or no elements without changing the order of the remaining elements.
 */
public class DPInString {
    /**
     * Given a string s, return the longest palindromic substring in s.
     * boolean dp[i][j]: s[i..j] is palinromic string, value is true, otherwise false.
     * 0<=i<=j<n
     * dp[i][j] = dp[i+1][j-1] if s[i]==s[j] 
     * dp[i][j] = false if s[i]!=s[j]
     * dp[i][i] = true
     * 
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        dp[0][0]=true;
        int maxLen = 1;
        int start = 0;
        for(int len = 1; len <= n; len++) {
           
            for(int i=0; i< n; i++) {
                //initalize the [i,i], every character is a smallest palindrome.
                dp[i][i] = true;
                
                
                int j = i + len - 1;
                if(j >= n) {
                    break;
                }
                if(s.charAt(i) == s.charAt(j)) {
                    if(j-i <= 2) {
                        dp[i][j] = true;
                        
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                    
                }else {
                    dp[i][j] = false;
                }
                
                if(dp[i][j] && maxLen < j-i+1) {
                    System.out.println("start:" + start + " maxLen:" + maxLen + " j:" + j);
                    start = i;
                    maxLen = j-i+1;
                   
                }
                
            }
        }
        System.out.println("start:"+ start + " maxLen:"+ maxLen);
        return s.substring(start, start+maxLen);
       
        
    }
    /**
     * Middle out algorithm
     * left and right pointer to left and right until to bounds of s.
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int n = s.length();
        int middle = 0;
        int maxSize = 0;
        for(int i = 1; i < n; i++ ) {
            int size1 = middleoutAlgorithm(s, i, i);
            int size2 = middleoutAlgorithm(s, i, i+1);
            
            int size = Math.max(size1, size2);
            if(maxSize < size) {
                maxSize = size;
                middle = i;
            }
        }
        int start = middle - (maxSize-1)/2;
        int end = start + maxSize;
        return s.substring(start, end);
    }
    
    /**
     * 
     * @param s
     * @param front
     * @param tail
     * @return
     */
    public int middleoutAlgorithm(String s, int front, int tail) {
        if(front > tail) {
            throw new IllegalArgumentException("illegal arguments");
        }
        int n = s.length();
        while(front >=0 && tail < n &&s.charAt(front) == s.charAt(tail)) {
                front--;
                tail++;
        }
        return tail-front-1;
    }
    
    
    public int longestPalidromeSubseq(String s){
        int len = s.length();
        //step 1. Make sure status. Array fn store the from i to j s[i..j] contains longest palindromic string size:pd[i][j]
        //step 2. Make formula. 
        //When: s[i]==s[j], fn[i][j]=fn[i+1][j-1]+2; 
        //When: s[i]!=s[j], fn[i][j] = Max(fn[i+1][j], fn[i][j-1])
        //step 3. Initialize value. when fn[i][i]=1, from end i=len-1 to start=0(0<=i<=j<n) , from start j = i+1 to end=n-1
        //step 4. return fn[0][n-1]
        //[f(0,0), f(0,1), f(0,2),..,f(0,n-2), f(0,n-1)]
        //[f(1,0), f(1,1), f(1,2),..,f(1,n-2), f(1,n-1)]
        //[f(2,0), f(2,1), f(2,2),..,f(2,n-2), f(2,n-1)]
        //[f(..,0), f(..,1), f(..,2),..,f(..,n-2), f(..,n-1)]
        //[f(n-1,0),f(n-1,1), f(n-1,2),..,f(n-1,n-2), f(n-1,n-1)]
        //It is like triangle, enumeration is from bottom right to top.
        //****
        //-***
        //--**
        //---*
        int[][] fn = new int[len][len];
        for(int i = len -1; i >= 0; i--) {
            fn[i][i] = 1;
            for(int j = i+1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    fn[i][j] = fn[i+1][j-1] + 2;
                }else {
                    fn[i][j] = Math.max(fn[i+1][j], fn[i][j-1]);
                }
            }
        }
        return fn[0][len-1];
     }
    
    
    
}
