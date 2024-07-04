package leetcode.arrays;

import java.lang.reflect.Array;
import java.util.*;

public class topic1128 {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{1,2},{1,1},{1,2},{2,2}};//3对
//        int[][] nums = new int[][]{{1,2},{2,1},{3,4},{5,6}};//1对
        System.out.println(new Solution1128().numEquivDominoPairs(nums));
    }
}
class Solution1128 {
    public int numEquivDominoPairs(int[][] dominoes) {

        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for(int[] domino : dominoes){
            ArrayList<Integer> list = new ArrayList<>();
            for(int domi : domino){
                list.add(domi);
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
//        System.out.println(map.toString());
        int sum = 0;
        //迭代map {[1, 1]=1, [2, 2]=1, [1, 2]=3}
        //让符合的键的value集中到一个键
        for (List<Integer> keyList : map.keySet()) {
            if (map.get(keyList) == 0 || Objects.equals(keyList.get(1), keyList.get(0))) {
                continue;
            }
            List<Integer> keyListMirror = Arrays.asList(keyList.get(1), keyList.get(0));
            if (map.containsKey(keyListMirror)) {
                map.put(keyList, map.get(keyList) + map.get(keyListMirror));
                map.put(keyListMirror, 0);
            }
//            System.out.println(map);
        }
        //C(n, 2)
        for(Integer value : map.values()){
            if(value == 0 || value == 1){
                continue;
            }
            sum += value * (value - 1) / 2;
        }
        return  sum;

    }
}