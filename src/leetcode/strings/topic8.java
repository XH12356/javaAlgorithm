package leetcode.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class topic8 {
    public static void main(String[] args) {
        String s = "20000000000000000000";
        System.out.println(new Solution8().myAtoi(s));
    }
}
class Solution8 {
    public int myAtoi(String s) {
        String trim = s.trim();
        Pattern pattern = Pattern.compile("^[-+\\d][\\d]*");
        Matcher matcher = pattern.matcher(trim);
        String group;
        if(matcher.find()){
             group = matcher.group();
        }else{
            return  0;
        }
        StringBuilder sb = new StringBuilder(group);
        int signal = 1;
        if(sb.charAt(0) == '-'){
            signal = -1;
        }
        if (sb.charAt(0) == '-' || sb.charAt(0) == '+'){
            sb.deleteCharAt(0);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0){
            return 0;
        }
        Pattern pattern2 = Pattern.compile("^[\\d]*");
        Matcher matcher2 = pattern2.matcher(sb);
        if(matcher2.find()){
            group = matcher2.group();
        }else{
            return 0;
        }
        int res = 0;
        try{
             res = Integer.parseInt(group);
        }catch (NumberFormatException e){
            return signal == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return  signal * res;
//
//        long aLong = Long.parseLong(group);
//
//        if(signal == 1 ){
//            if(aLong > Integer.MAX_VALUE){
//                return Integer.MAX_VALUE;
//            }else{
//                return (int)aLong;
//            }
//        }else{
//            if((-1) * aLong < Integer.MIN_VALUE){
//                return  Integer.MIN_VALUE;
//            }else{
//                return  (-1) * (int)aLong;
//            }
//
//        }


    }
}