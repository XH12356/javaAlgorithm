package leetcode.arrays;

import java.util.Arrays;

public class topic605 {
    public static void main(String[] args) {
        int[] ints = {1,0,0,0,0,1};

        System.out.println(new Solution605_1().canPlaceFlowers(ints ,2));
    }
}

/**
 * 复制到一个数组里，数组左右各补一个0，按窗口为3检测
 */
class Solution605_1{
    public boolean canPlaceFlowers(int[] flowerbed, int n){
        int[] fbcopy = new int[flowerbed.length + 2];
        System.arraycopy(flowerbed, 0, fbcopy, 1, flowerbed.length);

        int cnt = 0;
        for (int i = 0; i < fbcopy.length - 2; i++) {
            if(fbcopy[i] == 0 && fbcopy[i + 1] == 0 && fbcopy[i + 2] == 0){
                cnt++;
                i++;
            }
        }
        return cnt >= n;


    }
}
class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        int begin = 0, end = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                for (int j = i; j < flowerbed.length; j++) {
                    begin = i;
                    end = j;
                    if (flowerbed[j] == 1) {
                        if (begin == 0) {
                            // 0 0 0 0 1 0 0
                            cnt += (end - begin) / 2;
                        } else {
                            // 1 0 0 0 0 1
                            cnt += (end - begin - 1) / 2;

                        }
                        i = j;
                        break;

                    } else if (end == flowerbed.length - 1) {
                        // 1 1 0 0 0

                        cnt += (end - begin + 1) / 2;

                        i = j;
                        break;
                    }
                }
            }
        }

        return cnt >= n;

    }
}