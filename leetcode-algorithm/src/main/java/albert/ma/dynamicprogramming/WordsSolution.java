/**
 * 
 */
package albert.ma.dynamicprogramming;

/**
 * 
 */
public class WordsSolution {
    /**
     * Question:
     * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
     * You have the following three operations permitted on a word:
     * 1.Insert a character
     * 2.Delete a character
     * 3.Replace a character
     *
     * Equal to
     * Insert a character into  A
     * Insert a character into  B
     * Change a character from  A
     * 
     * 
     * Idea: word1->word2
     * 1.d[i][j] edited distance from A first i characters to B first j characters
     * 2.
     * 2.1.d[i][j-1]为A的前i个字符和B的前j-1个字符编辑距离的子问题。
     * 即对于B的第j个字符，我们在A的末尾添加了一个相同的字符，那么d[i][j]最小可以为d[i][j-1] + 1;
     * 2.2.d[i-1][j]为A的前i-1个字符和B的前j个字符编辑距离的子问题。 
     * 即对于A的第i个字符，我们在B的末尾添加了一个相同的字符，那么d[i][j]最小可以为d[i-1][j] + 1;
     * 2.3.d[i-1][j-1]为A的前i-1个字符和B的前j-1个字符编辑距离的子问题。
     * 即对于B的第j个字符，我们修改A的第i个字符使他们相等，那么d[i][j]最小可以为d[i-1][j-1]+1。
     * 如果A的第i个字符和B的第j个字符原本相同，那么实际上就不需要修改，D[i][j]=D[i-1][j-1]
     * 转移方程
     * 若 A和B的最后一个字母相同
     * D[i][j] = min(D[i][j-1] + 1, D[i-1][j] +1, D[i-1][j-1])
     * 若 A和B的最后一个字母不同
     * D[i][j]=1+min(D[i][j−1], D[i−1][j], D[i−1][j−1])
     * 边界情况
     * 一个空串和一个非空串的编辑距离为D[0][j] = j, D[i][0] = i
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        //有一个字符串是空串
        if(m == 0 || n == 0) {
            return Math.max(m, n);
        }
        
        //DP array
        int[][] DP = new int[m+1][n+1];
        
        //bounds initialized
        for(int i = 0; i < m+1; i++) {
            DP[i][0] = i;
        }
        for(int j = 0; j < n+1; j++) {
            DP[0][j] = j;
        }
        
        //calc all DP value
        for(int i= 1; i < m+1; i++) {
            for (int j =1; j < n+1; j++) {
               int left = DP[i-1][j] + 1;
               int down = DP[i][j-1] + 1;
               int left_down = DP[i-1][j-1];
               //Last characters of Word1 and Word2 are not equal.
               if(word1.charAt(i-1) != word2.charAt(j-1)) {
                   left_down += 1;
               }
               DP[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        
        return DP[m][n];
    }
    
    /**
     * Q:
     * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
     * 
     * Idea
     * s1[0..i] and s2[0..j]
     * dp[i][j] it is the minimum sum of deleted ascii characters to make two strings s1[i] and s2[j] equal.  
     * 1. if s1[i-1] == s2[j-1] then dp[i][j] = dp[i-1][j-1; 
     * 2. if s1[i-1]!=s2[j-1]   then dp[i][j] = min(dp[i-1][j]+s1[i-1], dp[i][j-1]+s2[j-1])
     * 
     * 
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        
        if(s1 == null || s2 == null) {
            throw new IllegalArgumentException("s1 or s2 should not be null");
        }
        
        int m = s1.length();
        int n = s2.length();
        if(m == 0 && n == 0) {
            return 0;
        }
        int [][]dp = new int[m+1][n+1];
        dp[0][0] = 0;
        
        //if s1 is blank string, summerize s2 characters.
        for (int j= 1; j<= n; j++) {
            dp[0][j] = dp[0][j-1]+ s2.codePointAt(j-1);
        }
         
        //if s2 is blank string, summerize s1 characters.
        for (int i = 1; i <=m; i++) {
            dp[i][0] = dp[i-1][0]+s1.codePointAt(i-1);
        }
      
        
        for(int i=1; i <= m; i++) {
            for(int j=1; j<=n; j++) {
                if(s1.codePointAt(i-1) != s2.codePointAt(j-1)) {
                    dp[i][j] = Math.min(dp[i-1][j]+s1.codePointAt(i-1),dp[i][j-1]+s2.codePointAt(j-1));
                }else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
            
        return dp[m][n];
    }
    /**
     * Given two strings s and t, return the number of distinct subsequences of s which equals t.
     * The test cases are generated so that the answer fits on a 32-bit signed integer.
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        return 0;
    } 
    
}
