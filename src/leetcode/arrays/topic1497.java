package leetcode.arrays;

import java.util.*;

public class topic1497 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,7,-9,4,4,7,3,2,10,8,15,2,1,-8,10,-5,10,-2,21,9,20,0,4,24,5,12,-10,8,9,18,13,-8,10,-4,-3,0,16,-4,8,14,15,-9,0,0,-6,11,-3,10,11,7,-1,-5,5,11,2,5,9,-2,8,9,-10,6,-2,7,8,3,0,-2,11};
        int k = 18;
        System.out.println(new Solution1497().canArrange(nums, k));
    }
}

/**
 * 求余整除问题：
 * 法1：暴力求解，设一个与arr长度相同的boolean数组，如果这两个数被使用，则设为boolean
 *
 * 法2：
 * 如果a与b的和能被k整除，那么他们分别被k除的余数之和，也能被k整除
 * 如果有负数，负数+k在除k得到余数，这样余数都是正的
 * 余数数组长度为k，索引为余数值
 */
class Solution1497 {
    public boolean canArrange(int[] arr, int k) {
        int[] mod = new int[k];
        for (int j : arr) {
            int temp = (j % k + k) % k;
            mod[temp] += 1;
        }

//        if(k == 2 && mod[1] % 2 != 0){
//            return false;
//        }
        System.out.println(Arrays.toString(mod));

        for (int i = 1; i < mod.length / 2 + 1 ; i++) {
            System.out.println(i);
            System.out.println(mod.length - i);
            if(i == mod.length - i && mod[i] % 2 != 0){
                return  false;
            }
            if(mod[i] != mod[mod.length - i]){//和为定值的两个余数的数量相等
                return false;
            }
        }

        return true;




    }
}