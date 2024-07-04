package leetcode.arrays;

public class topic724 {
    public static void main(String[] args) {
        int[] nums = {2, 1, -1};
        System.out.println(new Solution724().pivotIndex(nums));

    }
}
class Solution724 {
    public int pivotIndex(int[] nums) {

        int leftSum = 0, rightSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        for (int i = 0; i < nums.length ; i++) {
            if(leftSum == rightSum){
                return i;
            }
            if(i  == nums.length - 1){
                return -1;
            }

            leftSum += nums[i];
            rightSum -= nums[i + 1];

        }
        return  -1;

    }
}