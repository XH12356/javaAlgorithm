package leetcode.hashtable;

import java.util.ArrayList;
import java.util.Random;

public class topic380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        randomizedSet.getRandom();

    }
}
class RandomizedSet {

    ArrayList<Integer> list = null;
    Random ran = new Random();


    public RandomizedSet() {
        list = new ArrayList<Integer>();
    }

    public boolean insert(int val) {
        if(!list.contains(val)){
            list.add(val);
            return true;
        }else {
            return false;
        }

    }

    public boolean remove(int val) {
        if(list.contains(val)){
            list.remove(Integer.valueOf(val));
            return true;
        }else{
            return false;
        }

    }

    public int getRandom() {
        int ranIndex = ran.nextInt(list.size());
        return list.get(ranIndex);


    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
