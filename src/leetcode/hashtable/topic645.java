package leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;

public class topic645 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1};
        System.out.println(Arrays.toString(new Solution645().findErrorNums(nums)));
    }
}
class Solution645 {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(Integer num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Integer key : map.keySet()){
            if(map.get(key) == 2){
                res[0] = key;
                break;
            }
        }
        for (int i = 1; i < nums.length + 1; i++) {
            if(map.get(i) == null){
                res[1] = i;
                break;
            }
        }
        return res;

    }
}