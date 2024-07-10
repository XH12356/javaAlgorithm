package leetcode.binarysearch;

public class topic69 {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(new Solution69().mySqrt(x));
    }
}
class Solution69 {
    public int mySqrt(int x) {
        double sqrt = Math.sqrt(x);
        System.out.println((int)sqrt);
        return  (int)Math.sqrt(x);

    }
}
