package leetcode.strings;

public class topic686 {
    public static void main(String[] args) {
        String a = "aaaaaaaaaaaaaaaaaaaaaab";
        String b = "ba";
        System.out.println(new Solution686_1().repeatedStringMatch(a, b));
    }
}

/**
 * 至少将 a 复制长度大于等于 b 的长度，才有可能匹配
 *
 * 由于主串是由 a 复制多次而来，并且是从主串中找到子串 b，
 * 因此可以明确子串的起始位置，不会超过 a 的长度
 *
 * 长度越过 a 长度的起始匹配位置，必然在此前已经被匹配过了
 *
 * 复制次数「上界」最多为「下界 + 1」
 *
 */
class Solution686_2{
    public int repeatedStringMatch(String a, String b){
        StringBuilder sa = new StringBuilder();
        int cnt = 0;
        while (sa.length() < b.length()){
            sa.append(a);
            cnt++;
        }
        sa.append(a);
        cnt++;
        if(sa.indexOf(b) == -1) return -1;
        return sa.indexOf(b) + b.length() > a.length() * (cnt - 1) ? cnt : cnt - 1;


    }
}

class Solution686_1 {
    public int repeatedStringMatch(String a, String b) {

        StringBuilder sa = new StringBuilder(a);
        int cnt = 1;
        while (sa.indexOf(b) == -1 && sa.length() < 50 * b.length()) {
            sa.append(a);
            cnt++;
        }
        return sa.length() >= 50 * b.length() ? -1 : cnt;

    }

}

class Solution686 {
    public int repeatedStringMatch(String a, String b) {
//        if(b.length() % a.length() != 0 && a.length() % b.length() != 0){
//            return  -1;
//        }
        if (a.length() > b.length()) {
            StringBuilder sa = new StringBuilder(a);

            int i = 0;
            while (i < a.length() && sa.substring(i, i + b.length()).compareTo(b) == 0) {
                i += b.length();
            }
            if (i != a.length()) {
                return -1;
            } else {
                return 1;
            }

        }

        StringBuilder sb = new StringBuilder(b);
        int times = b.length();
        while (times >= 0) {

            if (sb.substring(0, a.length()).compareTo(a) != 0) {
                char c = sb.charAt(b.length() - 1);
                sb.append(c);
                sb.deleteCharAt(0);
            } else {
                break;
            }
            times--;

        }
        ;
        if (times == b.length()) {
            return b.length() / a.length();
        } else if (times >= 0) {
            return b.length() / a.length() + 1;
        } else {
            return -1;
        }


//        int iA = 0;
//        int iB = 0;
//        for (; iB < b.length(); ) {
//            while (iA < a.length() && a.charAt(iA) != b.charAt(iB)) {
//                iA++;
//            }
//            if(iA == a.length()){
//                return  -1;
//            }
//
//        }


    }
}