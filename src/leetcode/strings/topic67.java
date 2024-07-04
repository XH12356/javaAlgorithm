package leetcode.strings;

import java.util.Arrays;

public class topic67 {
    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(new Solution67().addBinary(a, b));
    }
}
//11111
//22
class Solution67 {
    public String addBinary(String a, String b) {
//        return Integer.toString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2), 2);

        int[] arr = new int[a.length()];
        int[] brr = new int[b.length()];
        for (int i = 0; i < a.length(); i++) {
            arr[i] = a.charAt(i) - '0';
        }
        for (int i = 0; i < b.length(); i++) {
            brr[i] = b.charAt(i) - '0';
        }

        return a.length() > b.length() ? addBinary2(arr, brr) : addBinary2(brr, arr);
    }

    public String addBinary2(int[] longChars, int[] shortChars) {
        for (int i = 0; i < shortChars.length; i++) {
            longChars[longChars.length -  1 - i] += shortChars[shortChars.length - 1 - i];
        }
        int[] newLongChars = new int[longChars.length + 1];
//        int[] arr = new int[longChars.length + 1];
        System.arraycopy(longChars, 0, newLongChars, 1, longChars.length);
        for (int i = newLongChars.length - 1; i > 0; i--) {
            if (newLongChars[i]  >= 2) {
                newLongChars[i] -= 2;
                newLongChars[i - 1] += 1;
            }
        }
        int startI = 0;
        if(newLongChars[0]  == 0){
            startI = 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startI; i < newLongChars.length; i++) {
            sb.append(newLongChars[i]);
        }
        return sb.toString();
//        if(newLongChars[0]  == 0){
//            System.arraycopy(newLongChars, 1, longChars, 0, longChars.length);
//            return new String(Arrays.toString(longChars));
//        }else {
//            return Arrays.toString(newLongChars);
//
//        }


    }
}