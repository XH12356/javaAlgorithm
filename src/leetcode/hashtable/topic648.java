package leetcode.hashtable;

import java.util.*;

public class topic648 {
    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");

        String sentence = "the cattle was rattled by the battery";
        System.out.println(new Solution648().replaceWords(dictionary, sentence));
    }
}
class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        TreeSet<String> treeSet = new TreeSet<>((set1, set2) ->{
            if(set1.length() == set2.length()){
                return set1.compareTo(set2);
            }else{
                return set1.length() - set2.length();
            }
        });

        treeSet.addAll(dictionary);
        String[] split = sentence.split("\\s+");

        for (int i = 0; i < split.length; i++) {
            for(String set : treeSet){
                if(split[i].startsWith(set)){
                    split[i] = set;
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]);
            if(i != split.length - 1){
                sb.append(" ");
            }
        }

        return sb.toString();

    }
}
