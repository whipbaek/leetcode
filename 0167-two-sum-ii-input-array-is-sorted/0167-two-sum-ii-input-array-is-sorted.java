class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int back = numbers.length - 1;

        while(true){

            if(numbers[front] + numbers[back] == target){
                break;
            }

            if(numbers[front] + numbers[back] > target) {
                back--;
            } else if (numbers[front] + numbers[back] < target) {
                front++;
            }
        }

        return new int[]{front+1, back+1};
    }
}