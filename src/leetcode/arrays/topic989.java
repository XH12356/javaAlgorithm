package leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class topic989 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,5};
        int k = 806;
        System.out.println(new Solution989().addToArrayForm(nums, k));
    }
}

class Solution989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        ArrayList<Integer> list = new ArrayList<>(num.length);
        for(int i : num){
            list.add(i);
        }
        ArrayList<Integer> listK = new ArrayList<>();
        while (k != 0){
            listK.add(k % 10);
//            System.out.println(k);
            k = k / 10;
        }
        Collections.reverse(list);
//        System.out.println(list);
//        System.out.println(listK);
        if(list.size() >= listK.size()){
            return listAdd(list, listK);
        }else{
            return listAdd(listK, list);
        }
    }
    public List<Integer> listAdd(List<Integer> listAdded, List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            listAdded.set(i, listAdded.get(i) + list.get(i));
        }
//        System.out.println(listAdded);

        //短的list加到长的list，如果有进位，本位-10.后一位+1
        for (int i = 0; i < listAdded.size() - 1; i++) {
            if(listAdded.get(i) >= 10){
                listAdded.set(i, listAdded.get(i) - 10);
                listAdded.set(i + 1, listAdded.get(i + 1) + 1);
            }
        }

        //处理最高位>=10
        if(listAdded.get(listAdded.size() - 1) >= 10){
            listAdded.set(listAdded.size() - 1, listAdded.get(listAdded.size() - 1) - 10);
            listAdded.add(1);
        }
        Collections.reverse(listAdded);


        return listAdded;
    }
}