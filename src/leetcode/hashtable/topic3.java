package leetcode.hashtable;

import com.sun.source.tree.Tree;

import java.util.*;

public class topic3 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution3().lengthOfLongestSubstring(s));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        TreeMap<Integer, Character> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsValue(s.charAt(i))){
                map.put(i, s.charAt(i));
            }else{
                Iterator<Map.Entry<Integer, Character>> iter = map.entrySet().iterator();
                while (iter.hasNext()){
                    Map.Entry<Integer, Character> next = iter.next();
                    if(next.getValue() != s.charAt(i)){
                        iter.remove();
                    }else{
                        iter.remove();
                        map.put(i, s.charAt(i));
                        break;
                    }
                }
            }
            maxLen = Math.max(maxLen, map.size());
        }
        return maxLen;
    }
}