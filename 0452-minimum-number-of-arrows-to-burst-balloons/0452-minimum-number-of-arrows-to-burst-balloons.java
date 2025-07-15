import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        // 정렬을 한다음에, 앞에서부터 하나씩 고른다.
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }

            return Integer.compare(o1[0], o2[0]);
        });

        // for(int[] point : points) {
        //     System.out.println(point[0] + ", " + point[1]);
        // }

        int answer = 1;
        int start = points[0][0];
        int end = points[0][1];
        for(int i=1; i <points.length; i++) {
            // 현재 start 가 끝보다 작으면 지속한다.
            if(points[i][0] <= end) {
                if(points[i][1] < end) end = points[i][1];
                continue;
            }
            answer++;
            start = points[i][0];
            end = points[i][1];
        }

        return answer;
    }
}