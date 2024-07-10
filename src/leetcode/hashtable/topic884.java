package leetcode.hashtable;

import java.util.*;

public class topic884 {
    public static void main(String[] args) {
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(new Solution884().uncommonFromSentences(s1, s2)));
    }
}
class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] s1p = s1.split(" ");
        String[] s2p = s2.split(" ");
        for(String s : s1p){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for(String s : s2p){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }
        return  list.toArray(new String[]{});


    }
}