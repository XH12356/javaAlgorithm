package leetcode.arrays;

import com.sun.source.util.Trees;

import java.util.*;

public class topic914 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,2,3,3};
        System.out.println(new Solution914().hasGroupsSizeX(nums));

    }
}

//也可用求相邻两个数，例如12，23，34...的最大公约数，如有小于2，false
class Solution914 {
    public boolean hasGroupsSizeX(int[] deck) {
        //统计每个元素及其出现次数，放入map
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int dec : deck){
            map.put(dec, map.getOrDefault(dec, 0) + 1);
        }
//        System.out.println("map");
//        System.out.println(map.toString());

        //出现次数放入自然排序set
        TreeSet<Integer> set = new TreeSet<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            //某个数的次数小于2
            if(entry.getValue() < 2){
                return false;
            }
            set.add(entry.getValue());
        }
        System.out.println("set:");
        System.out.println(set.toString());

        //取出最小的
        int base = set.pollFirst();
        TreeSet<Integer> subset = new TreeSet<>();

        //最小的因数分解，放入subset
        for (int i = 2; i <= base; i++) {
            if(base % i == 0){
                subset.add(i);
            }
        }


        System.out.println("base:");
        System.out.println(base);
        System.out.println("subset:");
        System.out.println(subset);

        //要被划分的set
        for(Integer setNum : set){
            System.out.println(setNum);
            //迭代因数set
            Iterator<Integer> subsetIter = subset.iterator();
            while (subsetIter.hasNext()){
                int subsetNum = subsetIter.next();
                System.out.println("subsetNum:");
                System.out.println(subsetNum);
                if(setNum % subsetNum != 0){
                    subsetIter.remove();
                    System.out.println("remove finished");
                }
                if(subset.isEmpty()){
                    return false;
                }
            }


        }
        return  true;
//        return set.size() == 1 && set.pollFirst() >= 2;

    }
}
