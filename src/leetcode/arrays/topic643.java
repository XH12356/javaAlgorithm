package leetcode.arrays;

import java.awt.event.ItemEvent;

public class topic643 {
    public static void main(String[] args) {
        int[] ints = {5};

        System.out.println(new Solution643_1().findMaxAverage(ints, 1));
    }
}

/**
 * 滑动窗口
 */
class Solution643_1{
    public double findMaxAverage(int[] nums, int k) {
        double avg = Double.NEGATIVE_INFINITY;

        double temp = 0;
        for (int i = 0; i < k; i++) {
            temp += nums[i];
        }
        avg = temp / k;

        for (int i = 0; i < nums.length - k; i++) {
            temp = temp - nums[i] + nums[i + k];
            avg = Math.max(avg, temp / k);
//            System.out.println(avg);
        }

        return  avg;
    }
}

/**
 * 数据太多时超时
 */
class Solution643 {
    public double findMaxAverage(int[] nums, int k) {

        double avg = Double.NEGATIVE_INFINITY;
        double temp = 0;

        if(nums.length == k){
            for (int num : nums) {
                temp += num;
            }
            return temp / k;

        }
        for (int i = 0; i < nums.length - k + 1; i++) {
            temp = 0;
            for (int j = i; j < i + k; j++) {
                temp += nums[j];
            }
            temp /= k;
            avg = Math.max(avg, temp);
        }
        return avg;

    }
}