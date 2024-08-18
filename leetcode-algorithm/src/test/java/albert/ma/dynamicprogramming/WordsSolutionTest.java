/**
 * 
 */
package albert.ma.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/**
 * 
 */
public class WordsSolutionTest {
    
    @Test
    public void testMinDistance() {
       String w1 = "horse";
       String w2 = "ros";
       WordsSolution s = new WordsSolution();
       int dis = s.minDistance(w1, w2);
       assertEquals(3, dis);
       
    }
    @Test
    public void testMinSumDif() {
        String s1 = "sea";
        String s2 = "eat";
        WordsSolution s = new WordsSolution();
        int sumDif = s.minimumDeleteSum(s1, s2);
        assertEquals(231, sumDif);
    }
}
