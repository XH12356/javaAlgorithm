package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class topic1513 {
    public static void main(String[] args) {
        String s = "0110111";
        System.out.println(new Solution1513().numSub(s));

    }
}

class Solution1513 {
    public int numSub(String s) {
        //<几个连续1，个数>
        HashMap<Integer, Long> map = new HashMap<>();
        StringBuilder sb = new StringBuilder(s);
        sb.insert(0, '0');
        sb.append('0');

        int iStart = 0;//起始指针位置
        for (int i = 0; i < sb.length() - 1; i++) {
            if(sb.charAt(i) == '0' && sb.charAt(i + 1) == '1'){
                iStart = i + 1;
                continue;
            }
            if(sb.charAt(i) == '1' && sb.charAt(i + 1) == '0'){
                map.put(i - iStart + 1, map.getOrDefault(i - iStart + 1, 0L) + 1);
            }
        }
        System.out.println(map.toString());
        long res = 0L;
        for(Map.Entry<Integer, Long> entrySet: map.entrySet()){
            long temp = 0L;
            int key = entrySet.getKey();
            if(key != 0){
                for (int i = 1; i <= key; i++) {
                    temp += i;
                }
                res += temp * entrySet.getValue();
            }
        }
        if(res > Math.pow(10,9) + 7){
            return (int)(res % (Math.pow(10,9) + 7));
        }
        return (int)res;

    }
}