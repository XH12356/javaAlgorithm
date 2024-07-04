package leetcode.strings;


import java.util.HashMap;

public class topic13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new Solution13().romanToInt(s));

    }
}

/*
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

M CM XC IV
 */
class Solution13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {

            if (i + 1 < s.length() && (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))) {
                res = res + map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i++;
            } else {
                res += map.get(s.charAt(i));
            }

        }

        return res;

    }
}