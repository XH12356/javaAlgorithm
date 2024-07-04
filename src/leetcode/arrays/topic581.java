package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class topic581 {
    public static void main(String[] args) {
        int[] ints = {1};

        System.out.println(new Solution581().findUnsortedSubarray(ints));
    }
}
class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        int begin = -1, end = nums.length ;
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);

        for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != nums2[i]){
                begin = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0  ; i--) {
            if(nums[i] != nums2[i]){
                end = i;
                break;
            }
        }

        if(begin == -1 || end == nums.length){
            return 0;
        }
        return  end - begin + 1;

    }
}