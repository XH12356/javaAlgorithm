package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

public class topic290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(new Solution290().wordPattern(pattern, s));
    }
}
class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] sp = s.split(" ");
        if(pattern.length() != sp.length){
            return false;
        }
        HashSet<Character> paSet = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            paSet.add(pattern.charAt(i));
        }
        HashSet<String> spSet = new HashSet<>(Arrays.asList(sp));
        if(paSet.size() != spSet.size()){
            return false;
        }


        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if(map.get(pattern.charAt(i)) == null){
                map.put(pattern.charAt(i), sp[i]);
                continue;
            }
            if(!map.get(pattern.charAt(i)).equals(sp[i])){
                return false;
            }
        }
        return  true;


    }
}