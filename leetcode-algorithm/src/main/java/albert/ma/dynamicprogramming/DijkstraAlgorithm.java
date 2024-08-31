package albert.ma.dynamicprogramming;

import java.util.Stack;

public class DijkstraAlgorithm {

    public Double dijkstra(String [] args) {
        
        Stack<String> ops = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        
        for(String s: args) {
            if(s.equals("(")) ;
            else if(s.equals("+")) {
                ops.push(s);
            }else if(s.equals("-")) {
                ops.push(s);
            }else if(s.equals("*")) {
                ops.push(s);
            }else if(s.equals("/")) {
                ops.push(s);
            }else if(s.equals("sqrt")) {
                ops.push(s);
            }else if(s.equals(")")) {
                String op = ops.pop();
                double  v = vals.pop();
                
                if (op.equals("+")) {
                    v = vals.pop() + v;
                }else if(op.equals("-")) {
                    v = vals.pop() - v;
                }else if(op.equals("*")) {
                    v = vals.pop() * v;
                }else if(op.equals("/")) {
                    v = vals.pop() / v;
                }else if(op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                //将结果push到栈中
                vals.push(v);
                
                
            }else {
                vals.push(Double.parseDouble(s));
            }
        }
        
        return vals.pop();
        
    }
}
