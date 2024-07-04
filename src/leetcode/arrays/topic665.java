package leetcode.arrays;

public class topic665 {
    public static void main(String[] args) {

        int[] ints = {4,2,1};

        System.out.println(new Solution665().checkPossibility(ints));
    }
}

/**
 * nums[i] = nums[i + 1];或nums[i + 1] = nums[i ];后，再次遍历
 */
class Solution665 {
    public boolean checkPossibility(int[] nums) {
//
//        if(nums.length == 1 || nums.length == 2)
//            return  true;
//
//        int count = 0;
//        for (int i = 0 ; i < nums.length - 2; i++) {
//            if(nums[i] <= nums[i + 1] && nums[i + 1] <= nums[i + 2]){
//                continue;
//            }else if (nums[i] >= nums[i + 1] && nums[i + 1] >= nums[i + 2]){
//                return  false;
//            }else{
//                if(nums[i] > nums[i + 1] && nums[i + 1] <)
//                nums[i + 1] = nums[i];
//                count++;
//
//                for (int num : nums) {
//                    System.out.print(num + " ");
//
//                }
//                boolean a = nums[1] >= nums[2];
//                System.out.println();
//
//                if(count == 2){
//                    return  false;
//                }
//
//
//            }
//
//        }
//        return true;


//        int count = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    count++;
//                    break;
//                }
//            }
//            if (count == 2) {
//                return false;
//            }
//        }
//
//        return true;
        if(nums.length == 1){
            return true;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {

                int temp = nums[i];
                nums[i] = nums[i + 1];

                if(isSorted(nums)){
                    return true;
                }
                nums[i] = temp;
                nums[i + 1] = nums[i];
                if(isSorted(nums)){
                    return true;
                }
                return false;

            }
        }

        return true;
    }

    public boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;

    }
}
