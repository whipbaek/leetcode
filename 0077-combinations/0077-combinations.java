class Solution {

    public List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        func(list, 1, 0, n, k);
        return answer;
    }

    public void func (List<Integer> list, int val, int idx, int n, int k){

        if(list.size() == k){
            answer.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=val; i<=n; i++){
            list.add(i);
            func(list, i+1, idx+1, n, k);
            list.remove(idx);
        }
    }

}