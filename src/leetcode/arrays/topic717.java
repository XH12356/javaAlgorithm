package leetcode.arrays;

public class topic717 {
    public static void main(String[] args) {
        int[] nums = {1,0,0};
        System.out.println(new Solution717().isOneBitCharacter(nums));
    }
}
class Solution717 {
    public boolean isOneBitCharacter(int[] bits) {

        for (int i = 0; i < bits.length; ) {
//            System.out.println(i);
            if(bits[i] == 1){
                if(i == bits.length - 2){
                    return  false;
                }
                i += 2;
            }else{
                i += 1;
            }
//            System.out.println(i);
            if(i == bits.length){
                return true;
            }
        }
        return false;



    }
}