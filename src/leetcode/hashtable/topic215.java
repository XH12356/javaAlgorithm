package leetcode.hashtable;

import com.sun.source.tree.Tree;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class topic215 {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        int k = 1;
        System.out.println(new Solution215().findKthLargest(nums, k));
    }
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for(Integer i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int cnt = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            cnt += entry.getValue();
            if(cnt >= k){
                return entry.getKey();
            }
        }
        return map.lastEntry().getValue();

    }
}