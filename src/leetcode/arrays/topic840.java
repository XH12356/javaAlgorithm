package leetcode.arrays;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class topic840 {
    public static void main(String[] args) {
        int[][] a = {
                {2,11,5,8,9,4,9,4,5,2},
                {9,6,3,3,7,11,2,8,3,4},
                {7,1,10,9,0,4,3,8,2,9},
                {7,7,7,0,8,5,10,3,10,2},
                {1,6,6,5,4,4,6,8,5,6},
                {2,5,2,10,3,9,2,7,0,7},
                {4,4,4,3,7,2,9,4,5,3},
                {4,6,2,3,3,7,5,3,9,4},
                {3,7,1,5,8,6,1,8,6,3},
                {9,8,9,9,5,7,9,5,2,4}};
        System.out.println(new Solution840().numMagicSquaresInside(a));
    }
}
class Solution840 {
    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;

        for (int i = 0; i < grid.length - 2; i++) {
            loopj:
            for (int j = 0; j < grid[0].length - 2; j++) {

                TreeSet<Integer> treeSet = new TreeSet<>(Comparator.naturalOrder());
                for(int x = i; x <= i + 2; x++){
                    for(int y = j; y <= j + 2; y++){
                        treeSet.add(grid[x][y]);
                    }
                }
                try{
                    for (int k = 1; k <= 9; k++) {
                        if(k != treeSet.pollFirst()){
//                            if(grid[i][j] == 2){
//
//                                System.out.println("k != treeSet.pollFirst()");
//                                System.out.printf("i:%s, j:%s\n\n", i, j );
//                            }
                            continue loopj;
                        }
                    }
                }catch (Exception e){
//                    System.out.println("exception!");
//                    System.out.printf("i:%s, j:%s\n\n", i, j );
                    continue ;
                }

                HashSet<Integer> set = new HashSet<>(1);
                set.add(grid[i][j] + grid[i][j + 1] + grid[i][j + 2]);
                set.add(grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2]);
                set.add(grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2]);

                set.add(grid[i][j] + grid[i + 1][j] + grid[i + 2][j]);
                set.add(grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1]);
                set.add(grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2]);

                set.add(grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2]);
                set.add(grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2]);
//                System.out.println(set.size());
                if(set.size() == 1){
                    cnt++;
                }

            }
            
        }

        return  cnt;
    }
}