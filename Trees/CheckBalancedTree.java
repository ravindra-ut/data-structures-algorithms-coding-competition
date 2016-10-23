/**
 * Definition for a binary tree node.
 */



public class CheckBalancedTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left_height = height(root.left);
        int right_height = height(root.right);
        int diff = Math.abs(left_height - right_height);
        if(diff <= 1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }
        return false;
    }
    
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return (1 + Math.max(height(root.left), height(root.right)));
    }
}