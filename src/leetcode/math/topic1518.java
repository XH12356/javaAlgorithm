package leetcode.math;

public class topic1518 {
    public static void main(String[] args) {
        int numB = 9;
        int numEx = 3;
        System.out.println(new Solution1518().numWaterBottles(numB, numEx));
    }
}

class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = 0;
        int botSum = numBottles;
        sum += numBottles;
        do{
            int botGet = botSum / numExchange;
            sum += botGet;
            int botLeft = botSum % numExchange;
            botSum = botGet + botLeft;
        }while (botSum / numExchange != 0);

        return sum;

    }
}