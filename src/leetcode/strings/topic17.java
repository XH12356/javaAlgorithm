package leetcode.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class topic17 {
    public static void main(String[] args) {
        String  s = "";
        System.out.println(new Solution17().letterCombinations(s));
    }
}
class Solution17 {
    String[] dial = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        int index = 0;//传入的digits的索引
        ArrayList<String> res = new ArrayList<>();
        if(digits.equals("")){
            return res;
        }
        StringBuilder sb = new StringBuilder();
        backTrack(res, sb, digits, index);
        return  res;
    }
    public void backTrack(List<String> res, StringBuilder sb, String digits, int index){
        if(Objects.equals(digits, "") || index == digits.length()){//digits对应位置有数字
            res.add(sb.toString());
            return;
        }
        int iDail = digits.charAt(index) - '0';//得到dial的索引
        for (int i = 0; i < dial[iDail].length(); i++) {
            sb.append(dial[iDail].charAt(i));
            backTrack(res, sb, digits, index + 1);//下一个带加入字符，要查询digits的下一个索引
            sb.deleteCharAt(sb.length() - 1);//删除最后一个字符，为了下一次循环的加入

        }

    }
}