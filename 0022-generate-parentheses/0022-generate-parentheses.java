class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        recur(ans, 0, 0, n, new StringBuilder(""));
        return ans;
    }

    public void recur(List<String> ans, int open, int close, int limit, StringBuilder sb){

        if(limit == open){

            while(close < open){
                sb.append(')');
                close++;
            }

            ans.add(sb.toString());

            return;
        }

        if(close < open) {
            recur(ans, open+1, close, limit, new StringBuilder(sb.toString()).append('('));
            recur(ans, open, close+1, limit, new StringBuilder(sb.toString()).append(')'));
        } else{
            recur(ans, open+1, close, limit, new StringBuilder(sb.toString()).append('('));
        }
    }
}