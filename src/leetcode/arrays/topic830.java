package leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class topic830 {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(new Solution830().largeGroupPositions(s));
    }
}
class Solution830 {
    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for (int i = 0; i < s.length() - 1; i++) {

            int j = i;
//            System.out.println(s.charAt(j));
//            System.out.println(s.charAt(j + 1));
//            System.out.println();
            try{
                while(s.charAt(j) == s.charAt(j + 1)){
                    j++;
                }

            }catch (StringIndexOutOfBoundsException ignored){

            }
            List<Integer> subList =  new ArrayList<Integer>(2);
            if(j - i >= 2){
                subList.add(i);
                subList.add(j);
                list.add(subList);
            }
            i = j ;
        }

        return  list;

    }
}