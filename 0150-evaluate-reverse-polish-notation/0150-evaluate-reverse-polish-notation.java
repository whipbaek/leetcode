class Solution {
    public int evalRPN(String[] tokens) {
        // 후위표기식으로 계산하면 된다.
        // 연산자가 나올때는 항상 2개 이상의 숫자가 있을것임

        Stack<String> st = new Stack<>();
        if(tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        int answer = 0;
        for(String token : tokens) {
            // System.out.println("token : " + token);
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) {
                int n1 = Integer.parseInt(st.pop());
                int n2 = Integer.parseInt(st.pop());

                // System.out.println("n1 : " + n1 + ", n2 : " + n2);
                if(token.equals("+")) answer = n2 + n1;
                if(token.equals("-")) answer = n2 - n1;
                if(token.equals("/")) answer = n2 / n1;
                if(token.equals("*")) answer = n2 * n1;
                // System.out.println("answer : " + answer);
                st.push(Integer.toString(answer));
                continue;    
            }

            // 일반 숫자라면 push
            st.push(token);
        }

        return answer;
    }
}