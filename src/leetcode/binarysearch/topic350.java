package leetcode.binarysearch;

import java.util.*;

public class topic350 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(new Solution350().intersect(nums1, nums2)));
    }
}

class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> tm1 = new TreeMap<>(Comparator.naturalOrder());
        TreeMap<Integer, Integer> tm2 = new TreeMap<>(Comparator.naturalOrder());
        for (Integer num : nums1) {
            tm1.put(num, tm1.getOrDefault(num, 0) + 1);
        }
        for (Integer num : nums2) {
            tm2.put(num, tm2.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : tm1.entrySet()){
            int key1 = entry.getKey();
            if(tm2.containsKey(key1)){
                int cnt = Math.min(tm1.get(key1), tm2.get(key1));
                for (int i = 0; i < cnt; i++) {
                    list.add(key1);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;


    }
}
