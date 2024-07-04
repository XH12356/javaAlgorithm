package leetcode.arrays;

public class topic941 {
    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1,0};
        System.out.println(new Solution941().validMountainArray(nums));
    }
}
class Solution941 {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return  false;
        }
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]){
                return  false;
            }
            if(arr[i] > arr[i + 1]){
                leftIndex = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 1 ; i--) {
            if(arr[i] == arr[i - 1]){
                return  false;
            }
            if(arr[i] > arr[i - 1]){
                rightIndex = i;
                break;
            }

        }
        System.out.println(leftIndex);
        System.out.println(rightIndex);
        return leftIndex == rightIndex;


    }
}


