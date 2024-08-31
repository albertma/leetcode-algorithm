/**
 * 
 */
package albert.ma.string;

/**
 * 
 */
public class StringAlgorithm {

    
    public void reverseString(char[] s) {
        int f = 0,t = s.length -1;
        while (t > f) {
            char  a = s[f];
            s[f] = s[t];
            s[t] = a;
            t --;
            f ++;
        }
    }
}
