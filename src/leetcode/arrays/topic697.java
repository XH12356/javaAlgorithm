package leetcode.arrays;

import java.util.*;

public class topic697 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        System.out.println(new Solution697().findShortestSubArray(nums));
    }
}

class Solution697 {
    public int findShortestSubArray(int[] nums) {

//        TreeSet<Integer> set = new TreeSet<>(Comparator.naturalOrder());
//        for(int num : nums){
//            set.add(num);
//        }
        //map放值和其对应次数
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //找出map中最大次数
        int maxValue = Integer.MIN_VALUE;
        for (Integer value : map.values()) {
            maxValue = Math.max(maxValue, value);
        }

        //最大次数对应的值放入set
        HashSet<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxValue)) {
                set.add(entry.getKey());
            }
        }

        //根据不同值，遍历数组，找到最短数组长度
        int minLength = nums.length;
        for (Integer value : set) {

            int i = 0, j = nums.length - 1;
            while (!value.equals(nums[i])) {
                i++;
            }
            while (!value.equals(nums[j])) {
                j--;
            }
            minLength = Math.min(minLength, j - i + 1);
        }

        return minLength;


    }
}