package leetcode.strings;

public class topic434 {
    public static void main(String[] args) {
        String s = "Hello,";
        System.out.println(new Solution434().countSegments(s));
    }
}

class Solution434 {
    public int countSegments(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ' '){

                while (i < s.length() - 1 && !(s.charAt(i) != ' ' && s.charAt(i + 1) == ' ')){
                    i++;
                }
                cnt++;
            }

        }

        return  cnt;

    }
}