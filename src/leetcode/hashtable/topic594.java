package leetcode.hashtable;

import java.util.*;

public class topic594 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,4,5,1,1,1,1};
        System.out.println(new Solution594().findLHS(nums));
    }
}
class Solution594 {
    public int findLHS(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map.toString());
        if(map.size() < 2){
            return 0;
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        //key相邻的差1，则返回value1+value2
        int max = 0;
        for (int i = 0; i < entries.size() - 1; i++) {
            if(Math.abs(entries.get(i).getKey() - entries.get(i + 1).getKey()) == 1){
                max = Math.max(max, entries.get(i).getValue() + entries.get(i + 1).getValue());
//                return  entries.get(i).getValue() + entries.get(i + 1).getValue();
            }
        }
        return max;

////        list.sort(Comparator.reverseOrder());
//        if(list.size() < 2){
//            return 0;
//        }
//        System.out.println(list.toString());
//        return list.get(0) + list.get(1);
    }
}