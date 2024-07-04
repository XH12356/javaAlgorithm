package leetcode.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class topic628 {
    public static void main(String[] args) {
        int[] ints = {-1,-2,-3};

        System.out.println(new Solution628().maximumProduct(ints ));
    }
}
class Solution628 {
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int l = nums.length;

//        if(nums[1] >= 0){
//            return nums[l - 1] * nums[l - 2] * nums[l - 3];
//        }


        return Math.max(nums[0] * nums[1] * nums[l - 1], nums[l - 1] * nums[l - 2] * nums[l - 3]);
    }
}