package leetcode.hashtable;

import java.util.*;

public class topic205 {
    public static void main(String[] args) {
        String  s = "badc";
        String t = "baba";
        System.out.println(new Solution205().isIsomorphic(s, t));
    }
}
class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        HashSet<Character> setS = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            setS.add(s.charAt(i));
        }
        HashSet<Character> setD = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            setD.add(t.charAt(i));
        }
        if(setS.size() != setD.size()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i), t.charAt(i));
                continue;
            }
            if(map.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }
        }
        return true;

//        HashMap<Character, Integer> mapS = new HashMap<>();
//        HashMap<Character, Integer> mapD = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            mapD.put(t.charAt(i), mapD.getOrDefault(t.charAt(i), 0) + 1);
//        }
//        ArrayList<Integer> listD = new ArrayList<>(mapD.values());
//        ArrayList<Integer> listS = new ArrayList<>(mapS.values());
//        listD.sort(Comparator.naturalOrder());
//        listS.sort(Comparator.naturalOrder());
//        if(listS.size() != listD.size()){
//            return false;
//        }
//        for (int i = 0; i < listD.size(); i++) {
//            if(!Objects.equals(listS.get(i), listD.get(i))){
//                return false;
//            }
//        }
//        return true;
    }
}