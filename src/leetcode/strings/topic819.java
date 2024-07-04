package leetcode.strings;

import java.util.*;

public class topic819 {
    public static void main(String[] args) {
        String a = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] b = {"hit"};
        System.out.println(new Solution819().mostCommonWord(a, b));
    }
}
class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        String s = paragraph.toLowerCase();
        String[] split = s.split("[^a-zA-Z]+");
        TreeMap<String, Integer> mapPara = new TreeMap<>();
        HashSet<String> setBan = new HashSet<>();
        for(String spli : split){
            mapPara.put(spli, mapPara.getOrDefault(spli, 0) + 1);
        }
//        System.out.println(mapPara);
        Collections.addAll(setBan, banned);
        for(Map.Entry<String , Integer> entry : mapPara.entrySet()){
            String key = entry.getKey();
            if(setBan.contains(key)){
                mapPara.put(key, 0);
            }
        }
        //使用list对map中的value排序
//        System.out.println(mapPara);
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(mapPara.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

//        System.out.println(list);
        return list.get(0).getKey();


    }
}
