import java.lang.Math; // headers MUST be above the first class

public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    Solution myObject = new Solution();
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.print(myObject.maxSubArray(arr));
  }
}

// using kadane's algorithm O(n)
class Solution {
    // using kadane's algorithm O(n)
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for(int i=1; i< nums.length; i++) {
            nums[i] = Math.max(nums[i-1], 0) + nums[i];
            result = Math.max(result, nums[i]);
        }

        return result;
    }

    /**
    - using brute force O(n ^ 3)
    */
    // finding all possible subarray and finding the biggest sum
    public int sub_sum(int[] nums, int start, int offset) {
        int sum = 0;
        for(int i = 0; i<offset, i++) {
            sum += nums[start];
            start++;
        }
        return sum;
    }
    public int maxSubArray1(int[] nums) {
        int result = Integer.MIN_VALUE;
        for(int i=1; i<= nums.length; i++) {
            int j =0;
            while(j < nums.length) {
                int sum = this.sub_sum(nums, j, i);
                result = Math.max(result, sum);
                j++;
            }
        }

        return result;
    }

    /**
    - improved brute force O(n ^ 2)
    */
     public int maxSubArray2(int[] nums) {
        int result = Integer.MIN_VALUE;
        for(int i=1; i<= nums.length; i++) {
            int sum = 0;
            for(int j =0; j<= nums.length; j++) {
                if(i+j > nums.length)
                    break;
                sum += nums[j+i -1];
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}
