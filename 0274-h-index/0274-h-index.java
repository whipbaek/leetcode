import java.util.*;

// 최소 h개 이상의 논문이 각각 h번 이상 인용된 논문의 최댓값

class Solution {
    public int hIndex(int[] citations) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(citations);
        int len = citations.length;

        int basis = citations[len-1];
        int sum = 1;

        // 누적합 더하기
        for (int i = len-2; i >= 0; i--) {
            // 만약 basis와 다르다면, 해당 값을 갱신해주고 basis를 변경해준다.
            if (basis != citations[i]) {
                map.put(basis, sum);
                basis = citations[i];
                if (i == 0) {
                    map.put(citations[i], sum + 1);
                } 
            } else {
                if (i == 0) {
                    map.put(basis, sum + 1);
                }
            }
            sum++;
        }

        //length 가 1인 경우에는 위 조건에 부합하지 못하기에 예외처리해준다.
        if(len == 1) map.put(citations[0], 1);

        for (Integer key : map.keySet()) {

            int val = map.get(key);
            System.out.println(key + ", " + val);

            if(key <= val){
                answer = key;
            } else{
                if(val > answer){
                    answer = val;
                }
            }
        }

        return answer;
    }
}