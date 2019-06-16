import java.lang.Math; // headers MUST be above the first class

public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    Solution myObject = new Solution();
    int[] arr = {1,3,5,6};
    System.out.print(myObject.searchInsert(arr, 5));
  }
}

// using kadane's algorithm O(n)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int pos = -1;
        for(int i=0; i<nums.length; i++) {
           
            if(nums[i] == target || nums[i] > target) {
                pos = i;
                break;
            }
        }
        if(pos == -1) {
            return nums.length;
        }
        return pos;
    }

    // O(log n)
    public int searchInsert1(int[] nums, int target) {
        int start = 0, end = nums.length;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < target) 
                start = mid + 1;
            else
                end = mid;
        }
        
        return start;
    }
}
