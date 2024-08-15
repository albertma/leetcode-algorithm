package albert.ma.dynamicprogramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of strings wordDict, 
 * return true if s can be segmented into a space-separated sequence of one or more dictionary words.
*  Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {
    public WordBreak() {
        
    }

	public boolean wordBreak(String s, List<String> wordDict) {
		return this.dynamicProg(s, wordDict);
	}

	/**
	 * Idea
	 * 我们需要枚举s[0..i-1]是否能被空格拆分成若干字典中出现的单词。
	 * 从前往后计算考虑转移方程，每次转移的时候，我们需要枚举包含位置i-1的最后一个单词, 
	 * 看它是否出现在字典中以及除去这部分的字符串是否合法即可。
	 * 我们需要枚举s1 = s[0..j-1]组成的字符串和 s2 = s[j..i-1]组成的字符串是否合法，
	 * 如果两个字符串均合法，那么按照定义s1和s2拼成的字符串也同样合法。
	 * dp[i]用于保存前i个字符组成的字符串s[0..i-1]是否能被空格拆分成若干字典中出现的单词。
	 * dp[j] && check(s[j..i-1])
	 * check(s[j..i-1]) 表示子串s[j..i-1]是否出现在字典中。
	 *  
	 * @param s
	 * @param workDict
	 * @return
	 */
	public boolean dynamicProg(String s, List<String> workDict) {
		int L = s.length();
		//dp[i]用于保存前i个字符组成的字符串s[0..i-1]是否能被空格拆分成若干字典中出现的单词。
		boolean dp[] = new boolean[L+1];
		Set<String> dictionary = new HashSet<String>(workDict);
		//初始化空字符串可以被找到。
		dp[0]=true;
		for(int i = 1; i <= L; i++) {
			//[0...j-1 |j..i]
			for(int j = 0; j < i; j++) {
				String subStr = s.substring(j,i);
				//dp[i]对应的S分解成S1和S2，
				//dp[j]是s1是否为单词组成，即为s[0,j-1], 
				//s2为subStr即为s[j,i-1], i是为string的size
				if(dp[j]&&dictionary.contains(subStr)) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[L];
	}
}
