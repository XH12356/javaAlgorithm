package leetcode.hashtable;

import java.util.*;

public class topic451 {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(new Solution451().frequencySort(s));

    }
}
class Solution451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        TreeMap<Character, Integer> treemap = new TreeMap<>((key1, key2) ->{
            int val1 = hashmap.get(key1);
            int val2 = hashmap.get(key2);
            if(val1 == val2){
                return key1.compareTo(key2);
            }else {
                return val2 - val1;
            }
        });
        treemap.putAll(hashmap);
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : treemap.entrySet()){
            int val = entry.getValue();
            sb.append(String.valueOf(entry.getKey()).repeat(Math.max(0, val)));
        }
        return sb.toString();


    }
}
