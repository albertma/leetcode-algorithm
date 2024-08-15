/**
 * 
 */
package albert.ma.dynamicprogramming;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence 
 * by deleting some or no elements without changing the order of the remaining elements.
 */
public class Palindromic {
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
