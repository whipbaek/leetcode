import java.util.*;

class Solution {
    public int minimizeXor(int num1, int num2) {

        List<String> binaryNum1 = makeBinaryString(num1);
        List<String> binaryNum2 = makeBinaryString(num2);
        int[] num1Cnt = new int[2];
        int[] num2Cnt = new int[2];

        if (binaryNum2.size() > binaryNum1.size()) {
            for (int i = binaryNum1.size(); i < binaryNum2.size(); i++) {
                binaryNum1.add("0");
            }
        }

        if (binaryNum1.size() > binaryNum2.size()) {
            for (int i = binaryNum2.size(); i < binaryNum1.size(); i++) {
                binaryNum2.add("0");
            }
        }

        // Collections.reverse(binaryNum1);
        // Collections.reverse(binaryNum2);

        print(binaryNum1, num1);
        print(binaryNum2, num2); // num2 의 숫자에 맞춰야한다.
        System.out.println();

        for(int i=0; i<binaryNum1.size(); i++){
            if(binaryNum1.get(i).equals("0")) num1Cnt[0]++;
            else num1Cnt[1]++;

            if(binaryNum2.get(i).equals("0")) num2Cnt[0]++;
            else num2Cnt[1]++;
        }

        if(num1Cnt[0] < num2Cnt[0]){
            for(int i=0; i<binaryNum1.size(); i++){

                if(num1Cnt[0] == num2Cnt[0] && num1Cnt[1] == num2Cnt[1]) break;

                if(binaryNum1.get(i).equals("1")){
                    binaryNum1.set(i, "0");
                    num1Cnt[1]--;
                    num1Cnt[0]++;
                }
            }
        } else if (num1Cnt[1] < num2Cnt[1]){
            for(int i=0; i<binaryNum1.size(); i++){

                if(num1Cnt[0] == num2Cnt[0] && num1Cnt[1] == num2Cnt[1]) break;

                if(binaryNum1.get(i).equals("0")){
                    binaryNum1.set(i, "1");
                    num1Cnt[0]--;
                    num1Cnt[1]++;
                }
            }
        }

        int answer = 0;
        int weight = 1;
        for(int i=0; i<binaryNum1.size(); i++){
            answer += Integer.parseInt(binaryNum1.get(i)) * weight;
            weight *= 2;
        }

        return answer;
    }

    public List<String> makeBinaryString(int num) {

        List<String> res = new ArrayList<>();

        while (num != 0) {
            res.add(Integer.toString(num % 2));
            num /= 2;
        }

        return res;
    }

    public void print(List<String> num, int type) {
        System.out.print(type + ": ");
        for (String str : num) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}