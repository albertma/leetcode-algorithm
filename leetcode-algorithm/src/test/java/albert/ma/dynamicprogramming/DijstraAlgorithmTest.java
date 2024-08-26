package albert.ma.dynamicprogramming;

import org.junit.Before;
import org.junit.Test;

public class DijstraAlgorithmTest {
    
    DijkstraAlgorithm dj;
    
    @Before
    public void setup() {
       dj = new DijkstraAlgorithm();
    }

    
    @Test
    public void djTest() {
        String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String args[] = s.split(" ");
        double value = dj.dijkstra(args);
        System.out.println("value:" + value);
    }
}
