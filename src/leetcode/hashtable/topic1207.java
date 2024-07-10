package leetcode.hashtable;

import java.util.*;

public class topic1207 {
    public static void main(String[] args) {

        int[] arr = {1,2,2,1,1,3};
        System.out.println(new Solution1207().uniqueOccurrences(arr));
    }
}
class Solution1207 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(Integer ar : arr){
            map.put(ar, map.getOrDefault(ar, 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>(map.values());
        return map.values().size() == set.size();



    }
}
