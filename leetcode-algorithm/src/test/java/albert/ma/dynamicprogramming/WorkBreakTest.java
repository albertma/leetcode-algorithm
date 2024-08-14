package albert.ma.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;


class WorkBreakTest {
    
    WordBreak wordbreak;
    @Before
    void setup() {
        
    }

	@Test
	void testWordBreak() {
	    wordbreak = new WordBreak();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String[] dict = new String[] {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		List<String> wordDict = Arrays.asList(dict);
		boolean isValid = this.wordbreak.wordBreak(s, wordDict);
		Assert.assertFalse(isValid);
	}

}
