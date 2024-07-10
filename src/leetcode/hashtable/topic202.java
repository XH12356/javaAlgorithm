package leetcode.hashtable;

import java.util.HashSet;

public class topic202 {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(new Solution212().isHappy(n));
    }
}
class Solution212 {
    public boolean isHappy(int n) {
        int sum = n;
        int temp ;
        HashSet<Integer> set = new HashSet<>();
        while (true){
            set.add(sum);
            temp = sum;
            sum = 0;
            while (temp / 10 != 0){
                sum += (temp % 10) * (temp % 10);
                temp /= 10;
            }
            sum += temp * temp;
            if(sum == 1){
                return  true;
            }
            if(set.contains(sum)){
                return  false;
            }

        }




    }
}