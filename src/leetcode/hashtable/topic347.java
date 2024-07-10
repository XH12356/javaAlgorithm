package leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class topic347 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int k = 2;
        System.out.println(Arrays.toString(new Solution347().topKFrequent(nums, k)));
    }
}
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(Integer num : nums){
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, Integer> treemap = new TreeMap<>((key1, key2) ->{
            int compare = map1.get(key2).compareTo(map1.get(key1));
            if(compare == 0){
                return key1.compareTo(key2);
            }else {
                return compare;
            }
        });
        treemap.putAll(map1);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = treemap.pollFirstEntry().getKey();
        }
        return  res;
    }
}
