package leetcode.arrays;

import java.util.Arrays;

public class topic11 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,8,7,6,5,4,3,2,1};
        System.out.println(new Solution11_1().maxArea(nums));
    }
}

/**
 * 双指针计算面积, 每次移动指向数据小的指针
 */
class Solution11_1 {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        for (int i = 0, j = height.length - 1; i != j; ) {
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            System.out.printf("i: %s\n", i);
            System.out.printf("j: %s\n", j);
            System.out.println(area);
            System.out.println();

            left = i;
            right = j;
            if (height[i] <= height[j]) {
                do {
                    i++;
                }
                while (height[left] >= height[i] && i < j);
            } else {
                do{
                    j--;
                }
                while (height[right] >= height[j] && i < j);
            }
        }

        return area;

    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                System.out.println(i);
                System.out.println(j);
                area = Math.max(area, (j - i) * Math.min(height[i], height[j]));

            }
        }
        return area;

    }
}