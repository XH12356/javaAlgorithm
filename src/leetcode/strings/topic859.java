package leetcode.strings;

public class topic859 {
    public static void main(String[] args) {
        String s = "abcaa";
        String goal = "abcbb";
        System.out.println(new Solution859().buddyStrings(s,goal));
    }
}

class Solution859 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int index1 = -1, index2 = -1, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)){
                switch (cnt){
                    case 0:
                        cnt++;
                        index1 = i;
                        break;
                    case 1:
                        cnt++;
                        index2 = i;
                        break;
                    default://超过三处不等，返回false
                        return  false;
                }
            }
        }


        //两处不等，交换后相等则为ture，否则为false
        if(cnt == 2 ){
            return s.charAt(index1) == goal.charAt(index2) && s.charAt(index2) == goal.charAt(index1);
        }else if(cnt == 1){
            return false;
        }else{//s和goal相等
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if(s.charAt(i) == s.charAt(j)){//自我两处相等，可交换
                        return true;
                    }

                }
            }
            //相等，但自己不可交换
            return false;
        }




    }
}
