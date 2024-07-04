package leetcode.arrays;

public class topic674 {
    public static void main(String[] args) {
        int[] nums = {2,1,3};

        System.out.println(new Solution674().findLengthOfLCIS(nums));
    }
}

class Solution674 {
    public int findLengthOfLCIS(int[] nums) {

        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println(nums[j - 1] + " " + nums[j]);
                if (nums[j - 1] >= nums[j]) {
                    res = Math.max(res, j - i );
                    i = j - 1;

                    break;
                }
                if(j == nums.length - 1){
                    res = Math.max(res, j - i + 1);
                }

            }
        }
        return res;

    }
}
