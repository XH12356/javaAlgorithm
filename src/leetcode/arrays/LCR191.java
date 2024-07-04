package leetcode.arrays;

import java.util.Arrays;

public class LCR191 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 4, 5};
        int k = 806;
        System.out.println(Arrays.toString(new SolutionLCR191().statisticalResult(nums)));
    }
}
class SolutionLCR191 {
    public int[] statisticalResult(int[] arrayA) {
        int[] res = new int[arrayA.length];
        int cnt0 = 0, indexFor0 = 0;
        boolean flag1 = true;
        //数数组里面的0的个数
        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] == 0){
                cnt0++;
            }
            if(cnt0 == 2){//两个0
                return res;
            }else if (cnt0 == 1 && flag1){
                flag1 = false;
                indexFor0 = i;
            }


        }
        int sum = 1;

        System.out.println(indexFor0);
        //一个0
        if(cnt0 == 1){
            for (int i = 0; i < arrayA.length; i++) {
                if(i != indexFor0){
                    sum *= arrayA[i];
                }
            }
            res[indexFor0] = sum;
            return res;
        }

        //没有0
        for (int array : arrayA) {
            sum *= array;
        }
        for (int i = 0; i < arrayA.length; i++) {
            res[i] = sum  / arrayA[i];

        }
        return res;


    }
}