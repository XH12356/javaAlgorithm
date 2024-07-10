package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class topic692 {
    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(new Solution692().topKFrequent(words, k));

    }
}

class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (String word : words) {
            hashmap.put(word, hashmap.getOrDefault(word, 0) + 1);
        }
        TreeMap<String, Integer> treemap = new TreeMap<>((key1, key2) -> {
            int cnt1 = hashmap.get(key1);
            int cnt2 = hashmap.get(key2);
            if (cnt1 == cnt2) {
                return key1.compareTo(key2);
            } else {
                return cnt2 - cnt1;
            }
        });
        treemap.putAll(hashmap);
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(treemap.pollFirstEntry().getKey());
        }
        return res;

    }
}