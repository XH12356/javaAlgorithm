package leetcode.hashtable;

import java.util.*;

public class topic970 {
    public static void main(String[] args) {
        int x = 2;
        int y = 1;
        int bound  = 10;
        System.out.println(new Solution970().powerfulIntegers(x, y, bound));

    }
}
class Solution970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        TreeSet<Integer> setX = new TreeSet<>(Comparator.naturalOrder());
        if(x == 1){
            setX.add(1);
        }else{
            for (int i = 0; ; i++) {
                int tmp = (int) Math.pow(x, i);
                if(tmp <= bound){
                    setX.add(tmp);
                }else{
                    break;
                }
            }
        }
        TreeSet<Integer> setY = new TreeSet<>(Comparator.naturalOrder());
        if(y == 1){
            setY.add(1);
        }else{
            for (int i = 0; ; i++) {
                int tmp = (int) Math.pow(y, i);
                if(tmp <= bound){
                    setY.add(tmp);
                }else{
                    break;
                }
            }
        }
        HashSet<Integer> res = new HashSet<>();
        for(Integer sx : setX){
            for(Integer sy : setY){
                int tmp = sx + sy;
                if(tmp <= bound){
                    res.add(tmp);
                }else{
                    break;
                }
            }
        }
        return new ArrayList<>(res);

    }
}
