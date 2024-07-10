package leetcode.binarysearch;

public class topic367 {
    public static void main(String[] args) {
        int num = 2000105819;
        System.out.println(new Solution367().isPerfectSquare(num));
    }
}
class Solution367 {
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }
        long left = 1;
        long right = num;
        long mid ;
        while (left <= right){
            mid = left + (right - left + 1) / 2;
            if(mid * mid > num){
                right -= 1;
            }else if (mid * mid < num){
                left = mid;
            }else {
                return true;
            }
        }
        return false;

    }
}
