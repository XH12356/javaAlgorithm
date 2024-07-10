package leetcode.hashtable;

import java.util.Arrays;

public class topic204 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(new Solution204_1().countPrimes(n));
    }
}

/**
 * 初始化长度 O(n) 的标记数组，表示这个数组是否为质数。数组初始化所有的数都是质数.
 * 从 2 开始将当前数字的倍数全都标记为合数。标记到n时停止即可。
 *
 * 注意每次找当前素数 x 的倍数时，是从 x^2
 * 开始的。因为如果 x>2，那么 2∗x 肯定被素数 2 给过滤了，最小未被过滤的肯定是 x ^2
 */
class Solution204_1 {
    public int countPrimes(int n) {
        boolean[] count = new boolean[n];
        int sum = 0;
        Arrays.fill(count, true);
        for (int i = 2; i < Math.sqrt(n); i++) {
            if(count[i]){
                for (int j = i * i; j < n; j += i) {
                    count[j] = false;
                }

            }

        }
        for (int i = 2; i < n; i++) {
            if(count[i]){
                sum++;
            }
        }
        return sum;
    }
}


class Solution204 {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        int sum = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sum++;
            }

        }
        return sum;

    }
}