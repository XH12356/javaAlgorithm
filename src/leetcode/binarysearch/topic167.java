package leetcode.binarysearch;

import java.util.Arrays;

public class topic167 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,4};
        int target = 6;
        System.out.println(Arrays.toString(new Solution167().twoSum(numbers, target)));
    }
}
class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int iStart = 0;
        int iEnd = numbers.length - 1;
        for (; iStart < iEnd; ) {
            if(numbers[iStart] + numbers[iEnd] > target){
                iEnd--;
            }else if(numbers[iStart] + numbers[iEnd] < target){
                iStart++;
            }else {
                return new int[]{iStart + 1, iEnd + 1};
            }
        }
        return new int[]{iStart + 1, iEnd + 1};


    }
}
