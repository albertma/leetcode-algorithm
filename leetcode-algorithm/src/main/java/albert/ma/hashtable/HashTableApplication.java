/**
 * 
 */
package albert.ma.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Hash table application
 */
public class HashTableApplication {
    /**
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        int []table = new int[26];
        int len = s.length();
        for(int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            table[index]++;
        }
        
        for(int i = 0; i < len; i++) {
            int index = t.charAt(i) - 'a';
            table[index]--;
        }
        
        for(int i = 0; i < table.length; i++) {
            if(table[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for(int i = 0; i < magazine.length(); i++) {
            Character ch = magazine.charAt(i);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
           
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            Character ch = ransomNote.charAt(i);
            Integer count = map.getOrDefault(ch, 0);
            if(count > 0) {
                count --;
                map.put(ch, count);
            }else {
                return false;
            }
        }
        return true;
    }
    
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> list = new HashSet<Integer>();
        for(int i= 0; i < m; i++) {
           hashSet.add(nums1[i]); 
        }
        
        for(int j = 0; j < n; j++) {
           if(hashSet.contains(nums2[j])) {
              list.add(nums2[j]); 
           }
        }
        return list.stream().mapToInt(i->i).toArray();
        
    }
    
    /**
     * Write an algorithm to determine if a number n is happy.
     * A happy number is a number defined by the following process:
     * Starting with any positive integer, replace the number by the sum of the squares of its digits.
     * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle.
     * which does not include 1.
     * Those numbers for which this process ends in 1 are happy.
     * Return true if n is a happy number, and false if not.
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> numSet  = new HashSet<Integer>();
        int value = n;
        while(true) {
            if(value == 1) {
                return true;
            }
            if(numSet.contains(value)) {
                return false;
            }
            numSet.add(value);
            
            value = getNextNumber(value);
        }
    }


    private int getNextNumber(int value) {
        int remain  = value;
        int sum = 0;
        while (remain > 0) {
            int num = remain%10;
            sum +=  num*num;
            remain = remain/10;
        }
        
        return sum;
    }
    
    /**
     * 
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer>  tab = new Hashtable<>();
        for(int i = 0; i < nums.length; i++) {
            tab.put(nums[i], i);
        }
        for(int j = 0; j < nums.length; j++) {
            int a = nums[j];
            int b = target - a;
            Integer bIdx = tab.get(b);
            if(bIdx != null && j != bIdx) {
                return new int[]{j, bIdx.intValue()};
            }
        }
        return null;
    }
    
}
