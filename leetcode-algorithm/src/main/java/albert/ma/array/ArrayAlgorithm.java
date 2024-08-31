/**
 * 
 */
package albert.ma.array;



/**
 * 
 */
public class ArrayAlgorithm {

    /**
     * Binary search in a ascending array.
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end) {
            if(target < nums[start] || target > nums[end]){
                return - 1;
            }
            int mid = start + (end - start)/2;
            if(nums[mid] < target) {
               start = mid + 1; 
            }else if(nums[mid] > target) {
               end = mid - 1; 
                
            }else if(nums[mid] == target) {
                
                return mid;
            }
            
            
        }
        return -1;
    }
    
    /**
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. 
     * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int slow=0, fast = 0;
        int size = nums.length;
        
        for(fast = 0; fast < size; fast++) {
            if(nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
    
    /**
     * 
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int slow = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast-1]!= nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
           
        }
        return slow;
    }
    
    /**
     * Given an integer array nums, 
     * move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        
       
        int slow = 0;
        
        for(int fast = 0; fast < n; fast ++) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        while(slow < n) {
            nums[slow] = 0;
            slow++;
        }
    }
    
    /**
     * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
     *  '#' means a backspace character. Note that after backspacing an empty text, the text will continue empty.
     * 
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int sLen = backspaceString(sChar);
        int tLen = backspaceString(tChar);
        if(sLen != tLen) {
            return false;
        }
        for(int i = 0; i < sLen; i++) {
            if(sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
        
    }
    
    private int backspaceString(char[] s) {
        int len = s.length;
        int slow = 0;
        for(int fast = 0; fast < len; fast++) {
            if(s[fast] != '#') {
                s[slow] = s[fast];
                slow++;
            }
            else {
                if(slow > 0) { // back space the slow pointer when slow is larger than 0.
                    slow --;
                }
            }
        }
        return slow;
    }
    
    /**
     * Given an integer array nums sorted in non-decreasing order, 
     * return an array of the squares of each number sorted in non-decreasing order.
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int []sorted = new int[len];
        if (nums[0] < 0 && nums[len -1] >= 0) {
            int min = 0;
            for(int i = 1; i < len; i++) {
                if(nums[i-1] < 0 && nums[i] >= 0) {
                    if(Math.abs(nums[i-1]) > nums[i]) {
                        min = i;
                    }else {
                        min = i-1;
                    }
                    break;
                }
            }
            mergeSquareSorted(nums, min, sorted);
            
        }else if(nums[len-1] <= 0){
            for(int i = len -1; i >= 0; i--) {
                sorted[len-1-i] = nums[i]* nums[i];
            }
        }else {
            for(int i = 0; i < len; i++) {
                sorted[i] = nums[i]*nums[i];
            }
        }
        return sorted;
    }
    
    
    private int[] mergeSquareSorted(int[] nums, int min, int[] sorted) {
        int size = nums.length;
        int left = min - 1;
        int right = min + 1;
        sorted[0] = nums[min] * nums[min];
        int index = 1;
        while(index < size) {
          //left and right are all valid.
            if(left >= 0 && right < size) { 
                if(nums[left]*nums[left] <= nums[right]*nums[right]) {
                    //left pointer square value is smaller
                    sorted[index] = nums[left]*nums[left];
                    left--;
                }else {
                    //right pointer square value is smaller
                    sorted[index] = nums[right]*nums[right];
                    right++;
                }
            }else if(left < 0 && right < size) {
                //left pointer reach the left boundary.
                sorted[index] = nums[right]*nums[right];
                right++;
            }else if(left >= 0 && right >= size) {
                //right pointer reach the right boundary.
                sorted[index] = nums[left]*nums[left];
                left--;
            }
            index ++;
        }
        return sorted;
    }
    
}
