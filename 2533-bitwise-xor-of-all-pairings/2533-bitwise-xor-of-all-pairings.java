import java.util.*;

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();

        boolean even1 = nums1.length%2 == 0 ? true : false;
        boolean even2 = nums2.length%2 == 0 ? true : false;

        int n1 = nums1[0];
        int n2 = nums2[0];
        for(int i=1; i<nums1.length; i++) n1 ^= nums1[i];
        for(int i=1; i<nums2.length; i++) n2 ^= nums2[i];

        if(even1 && even2){
            return 0;
        }

        if(even1 && !even2){
            return n1;
        }

        if(!even1 && even2){
            return n2;
        }

        return n1^n2;
    }
}