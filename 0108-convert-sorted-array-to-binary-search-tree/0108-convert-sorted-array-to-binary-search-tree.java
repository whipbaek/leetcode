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
    public TreeNode sortedArrayToBST(int[] nums) {
        // height-balanced 를 맞추기 위해서는, 가장 중간을 root 로 잡는게 맞음.
        // 그리고 그걸 기준으로 좌우로 나누는게 좋음.(반을 나눠서, 거기서 재귀로 다시 처리하는거)
        TreeNode root = new TreeNode();
        recursive(root, nums, 0, nums.length-1);
        return root;
    }

    public void recursive(TreeNode tree, int[] array, int start, int end) {

        int mid = (start + end) / 2;
        tree.val = array[mid];
        if(start <= mid - 1) {
            tree.left = new TreeNode();
            recursive(tree.left, array, start, mid-1);
        }

        if(mid + 1 <= end) {
            tree.right = new TreeNode();
            recursive(tree.right, array, mid+1, end);
        }

    }
}