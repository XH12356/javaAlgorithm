package leetcode.arrays;

public class topic747 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new Solution747().dominantIndex(nums));

    }
}

class Solution747 {
    public int dominantIndex(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if(maxValue < nums[i]){
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        for (int num : nums) {
            if (maxValue == num) {
                continue;
            }
            if (maxValue < 2 * num) {
                return -1;
            }
        }
        return  maxIndex;

    }
}
