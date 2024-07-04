package leetcode.arrays;

public class topic849 {
    public static void main(String[] args) {
        int[] nums = {1,0,1};
        System.out.println(new Solution849().maxDistToClosest(nums));


    }
}
// 0001000100
class Solution849 {
    public int maxDistToClosest(int[] seats) {
        int leftIndex = 0, rightIndex = 0, max = 0;
        for (int i = 0; i < seats.length; i++) {
            if(seats[i] == 1){
                leftIndex = i;
                break;
            }
        }

        for (int i = seats.length - 1; i >= 0; i--) {
            if(seats[i] == 1){
                rightIndex = i;
                break;
            }
        }
        for (int i = leftIndex; i < rightIndex; i++) {
            int j = i + 1;
//            System.out.println(i);
            while(seats[i] == 1 && seats[j] == 0 ){
//                System.out.println(j);
                j++;
            }
            max = Math.max(max, (j - i) / 2);

        }
        int res = 0;
        System.out.println(leftIndex);
        System.out.println(rightIndex);
        System.out.println(max);
        res = Math.max(leftIndex, seats.length - rightIndex - 1);
        res = Math.max(res, max);

        return res;

    }
}