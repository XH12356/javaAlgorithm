package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class topic599 {
    public static void main(String[] args) {
        String[] list1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        System.out.println(Arrays.toString(new Solution599().findRestaurant(list1, list2)));


    }
}
class Solution599 {
    /**
     * arraylist放结果
     * hashmap放list1和索引
     * sum 存储最小索引
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        int indexSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if(!map1.containsKey(list2[i])){
                continue;
            }
            if(map1.get(list2[i]) + i < indexSum){
                res.clear();
                res.add(list2[i]);
                indexSum = map1.get(list2[i]) + i;
            }else if (map1.get(list2[i]) + i == indexSum){
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[]{});

    }
}