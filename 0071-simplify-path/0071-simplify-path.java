import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();

        /*
        * 특정 문자를 제외하곤 슬래시 넣고 문자열 넣고를 반복한다.
        * 만약 '.' 이라면 아무 행동을 하지 않는다. (current directory)
        * 만약 '..' 이라면 슬래시와 문자열을 제거한다.
            * 만약 empty stack 이라면 아무것도 하지 않으면 된다.
        */
        String[] parts = path.split("/");
        for(String str : parts) {
            if(str.equals(".")) continue;
            if(str.length() == 0) continue;

            if(str.equals("..")) {
                if(!st.empty()) st.pop(); // 슬래시 제거
                if(!st.empty()) st.pop(); // 문자열 제거
                continue;
            }

            st.push(str);
            st.push("/");
        }
        StringBuilder sb = new StringBuilder("/");
        if(!st.empty() && st.peek().equals("/")) st.pop();
        List<String> list = new ArrayList<>();
        while(!st.empty()) {
            list.add(st.pop());
        }

        Collections.reverse(list);
        for(String str : list){
            sb.append(str);
        }

        return sb.toString();
    }
}