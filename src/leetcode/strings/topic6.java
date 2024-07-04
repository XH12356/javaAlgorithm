package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class topic6 {
    public static void main(String[] args) {

        String s = "AB";
        int i = 1;
        System.out.println(new Solution6().convert(s,i));
    }
}
class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int direct = 1, line = 0;
        for (int i = 0; i < s.length(); i++) {
            list.get(line).append(s.charAt(i));
            if(line == numRows - 1){
                direct = -1;
            }else if(line == 0){
                direct = 1;
            }
            line += direct;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : list){
            res.append(sb);
        }
        return res.toString();


    }
}