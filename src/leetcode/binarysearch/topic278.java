package leetcode.binarysearch;

public class topic278 {
    public static void main(String[] args) {

        int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
    }
}
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
//ftt
//123

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int mid = 0;
        while (left <= right){
            mid = left + (right - left) / 2;
            if(isBadVersion(mid) == true){
                right = mid - 1;
            }else if(isBadVersion(mid) == false) {
                left = mid + 1;
            }
        }
        if(isBadVersion(mid) == true){
            return mid;
        }else{
            return mid + 1;
        }


    }

    @Override
    boolean isBadVersion(int version) {
        return false;
    }
}