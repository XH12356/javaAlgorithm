package leetcode.hashtable;

public class topic718 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4,7};
        System.out.println(new Solution718().findLength(nums1, nums2));
    }
}

class Solution718 {
    public int findLength(int[] nums1, int[] nums2) {
        int maxLength = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    int endIndex1 = i;
                    int endIndex2 = j;
                    do{
                       endIndex1++;
                       endIndex2++;
                    }while (endIndex1 < nums1.length && endIndex2 < nums2.length
                            && nums1[endIndex1] == nums2[endIndex2]);
                    maxLength = Math.max(maxLength, endIndex1 - i);
                }
            }

        }
        return maxLength;

    }
}