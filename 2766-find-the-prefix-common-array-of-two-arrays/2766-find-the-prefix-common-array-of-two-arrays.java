import java.util.*;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int len = A.length;
        int[] answer = new int[len];

        int[] aList = new int[51];
        int[] bList = new int[51];

        for(int i=0; i<len; i++){
            int valueA = A[i];
            int valueB = B[i];
            int cnt = 0;

            if(aList[valueA] < bList[valueA]){
                cnt++;
            }
            aList[valueA]++;

            if(aList[valueB] > bList[valueB]){
                cnt++;
            }
            bList[valueB]++;

            if(i==0) {
                answer[i] = cnt;
                continue;
            }
            answer[i] = answer[i-1] + cnt;
        }

        return answer;
    }
}