package leetcode.strings;

public class topic680 {
    public static void main(String[] args) {
        String s = "avc";
        System.out.println(new Solution680_1().validPalindrome(s));
    }
}

/**
 * 不用stringbuilder，不用删除该字符，传递给另一个方法左右指针的索引即可
 */
class Solution680_1{
    public boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0, j = s.length() - 1; i + 1 <= j; ) {
            if(sb.charAt(i) == sb.charAt(j)){
                i++;
                j--;
            }else {
                StringBuilder sbCopy = new StringBuilder(sb);
                boolean reversable1 = reversable(sbCopy.deleteCharAt(i));
                sbCopy = new StringBuilder(sb);
                boolean reversable2 = reversable(sbCopy.deleteCharAt(j));
                return reversable1 || reversable2;

            }
        }
        return true;

    }
    public  boolean reversable(StringBuilder sb){
        for (int i = 0, j = sb.length() - 1; i + 1 <= j;) {
            if(sb.charAt(i) == sb.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return  true;
        
    }

}

/**
 * 暴力，通过418 / 471
 */
class Solution680 {
    public boolean validPalindrome(String s) {
        StringBuilder sa = new StringBuilder(s);
        StringBuilder saCopy = new StringBuilder(sa);
        if(sa.compareTo(saCopy.reverse()) == 0){
            return true;
        }
        int cnt = 0;
        for (int i = 0; i < sa.length(); i++) {
             saCopy =  new StringBuilder(sa);
             saCopy.deleteCharAt(i);
            StringBuilder saCopy2 = new StringBuilder(saCopy);
//            System.out.println(saCopy2);
            if(saCopy2.reverse().compareTo(saCopy) == 0){
                return  true;
            }
        }
        return  false;
    }
}
