/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }

 */
class Solution {


    public int idx;
    public Map<Integer, Integer> map = new HashMap<>(); // inorder 기준으로 인덱스 처리 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i); // 각 값에 대해서 인덱스 처리한다.
        }
        idx = postorder.length - 1;
        return recursive(postorder, 0, postorder.length-1);
    }

    public TreeNode recursive(int[] postorder, int start, int end) {
        if(start > end) return null;
        int rootVal = postorder[idx]; // root의 값
        TreeNode tree = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal); // 루트 값의 인덱스, 이 값을 기준으로 왼 오를 나눈다.

        idx--; // 다음 값

        // 왼쪽 트리는 현재 inorder 의 왼쪽
        tree.right = recursive(postorder, rootIdx+1, end);
        tree.left = recursive(postorder, start, rootIdx-1);

        return tree;
    }
}