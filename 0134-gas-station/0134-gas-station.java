import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // n은 최대 10000
        int len = gas.length;
        int[] diffs = new int[len];
        for(int i=0; i<len; i++){
            diffs[i] = gas[i] - cost[i];
        }
        
        for(int i=0; i<len; i++){
            System.out.print(diffs[i] + " ");
        } 
        System.out.println();

        int total = 0;
        int startPoint = -1;
        for(int i=0; i<len; i++){
            if(diffs[i] < 0 && startPoint == -1) {
                startPoint = i;
            }
            total += diffs[i];
        }

        if(total < 0) {
            return -1;
        }

        boolean[] visited = new boolean[len];
        int idx = startPoint + 1;
        if(idx == len) idx = 0;

        System.out.println("startPoint : " + startPoint);
        System.out.println("idx : " + idx);

        boolean seq = diffs[idx] >= 0 ? true : false;
        int sum = 0;
        int point = seq ? idx : 0;
        int maxVal = -1;
        int ansIdx = -1;
        List<Integer> points = new ArrayList<>();

        // 방문한곳을 만날때까지 돈다.
        while(true){
            
            if(visited[idx]){
                if(seq){
                    points.add(point);
                }
                break;
            }

            visited[idx] = true;

            if(seq){
                if(diffs[idx] >= 0){
                    sum += diffs[idx];
                } else{
                    if(sum > maxVal){
                        maxVal = sum;
                        ansIdx = point;
                    }
                    points.add(point);
                    sum = 0;
                    seq = false;
                }
            } else{ 
                if(diffs[idx] >= 0){
                    point = idx;
                    sum = diffs[idx];
                    seq = true;
                } 
            }     
            idx++;
            if(idx == len) {
                idx = 0;
            }        
        }
        int answer = -1;
        for(int p : points){
            System.out.print(p);
        } System.out.println();
        for(int p : points){
            sum = diffs[p];
            idx = p+1;
            if(idx == len) idx = 0;
            while(true){
                sum += diffs[idx++];
                if(idx == len) idx = 0;

                // 한바퀴 다 돌면
                if(idx == p) {
                    answer = idx;
                    break;
                }

                if(sum < 0){
                    break;
                }
            }
        }  

        return answer;
    }
}