class Solution {
    public long minSum(int[] nums1, int[] nums2) {

        long num1Sum = 0;
        long num2Sum = 0;
        int num1ZeroCnt = 0;
        int num2ZeroCnt = 0;

        for(int num : nums1) {
            if(num == 0) num1ZeroCnt++;
            num1Sum += num;
        }

        for(int num : nums2) {
            if(num == 0) num2ZeroCnt++;
            num2Sum += num;
        }

        System.out.println("num1Sum : " + num1Sum + " , num1ZeroCnt : " + num1ZeroCnt);
        System.out.println("num2Sum : " + num2Sum + " , num2ZeroCnt : " + num2ZeroCnt);


        if(num1Sum < num2Sum) {
            if(num1ZeroCnt == 0) return -1; // 작은값에 0이 하나도 없으면

            if(num1Sum + num1ZeroCnt > num2Sum) { //작은값의 0 합이 현재 큰값을 넘으면
                if(num2ZeroCnt == 0) return -1; // 큰 값에 0이 없으면 return -1

                return num1ZeroCnt + num1Sum > num2ZeroCnt + num2Sum ? num1ZeroCnt + num1Sum : num2ZeroCnt + num2Sum;
            }

            // 작은값의 합이 더 작다면 큰값의 0 합으로 리턴한다.
            return num2Sum + num2ZeroCnt;

        } else if (num1Sum > num2Sum) {
            if(num2ZeroCnt == 0) return -1; // 작은값에 0이 하나도 없으면

            if(num2Sum + num2ZeroCnt > num1Sum) { //작은값의 0 합이 현재 큰값을 넘으면
                if(num1ZeroCnt == 0) return -1;

                return num1ZeroCnt + num1Sum > num2ZeroCnt + num2Sum ? num1ZeroCnt + num1Sum : num2ZeroCnt + num2Sum;
            }

            return num1Sum + num1ZeroCnt;
        } else {
            if((num1ZeroCnt == 0 && num2ZeroCnt != 0) || (num2ZeroCnt == 0 && num1ZeroCnt != 0)) {
                return -1;
            }

            if(num1ZeroCnt < num2ZeroCnt) {
                return num2Sum + num2ZeroCnt;
            } else {
                return num1Sum + num1ZeroCnt;
            }
        }

        /*

        안되는경우는 뭘까?
        -> 총합이 작은 배열이 있는데, 0이 없는 경우

        조건 1 : 작은값이 0이 하나라도 없으면 -1
        조건 2 : 작은값이 모두 1했을때 큰 값을 넘으면?
        -> 큰 값에 0이 없으면 -1
        -> 가능하면 작은값을 모두 1로 했을때로 처리한다.

        [2, 0, 2, 0] 4
        [1, 4] 5
        
        [3, 2, 0]
        [3, 3, 0, 0]

        [3, 2, 0, 0, 0]
        값 : 5 / 0개수 : 3 / 토탈 8

        [3, 3, 0]
        값 : 6 / 0개수 : 1 / 토탈 ?
        */



    }
}