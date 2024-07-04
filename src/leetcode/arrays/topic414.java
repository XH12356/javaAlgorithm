package leetcode.arrays;

import java.util.Comparator;
import java.util.TreeSet;

public class topic414 {
    public static void main(String[] args) {

        int[] ints = {2, 2, 3, 1};

        System.out.println(new Solution414().thirdMax(ints));
    }
}

class Solution414 {
    public int thirdMax(int[] nums) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>( Comparator.reverseOrder());
//
//        for (int i : nums){
//            pq.add(i);
//        }
//        System.out.println(pq.toString());
//        Integer[] ar = new Integer[pq.size()];
//        ar = pq.toArray(ar);
//        int result = ar[0], count = 0;
////        while ( pq.peek() != null && count <= 2){
////            if(result != pq.peek()){
////                count++;
////            }
////            result = pq.poll();
////
////        }1
////        System.out.println(ar.length);
//        for (int i = 0; i < ar.length  && count <= 2; i++) {
//            result = ar[i];
//            if (i != ar.length - 1 && ar[i].equals(ar[i + 1])){
//                count++;
//            }
//            System.out.println(count);
//        }
//        if(count != 3){
//            return ar[0];
//        }
        TreeSet<Integer> tree = new TreeSet<>(Comparator.reverseOrder());
        for(int i : nums){
            tree.add(i);
        }
        System.out.println(tree.toString());
        if(tree.size() < 3 && tree.size() != 0){
            return tree.pollFirst();
        }
        tree.pollFirst();
        tree.pollFirst();
        return tree.pollFirst();


    }
}
