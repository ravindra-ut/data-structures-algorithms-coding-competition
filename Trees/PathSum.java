/**
 * Definition for a binary tree node.
 */
class PathSum {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public boolean hasPathSum(TreeNode t, int s) {
      if(t == null){
        return false;
      } else {
        s = s - t.val;
        boolean ans = false;
        if(t.left == null && t.right == null){
            return (s==0);
        }
        if(t.left!=null){
            ans = ans || hasPathSum(t.left, s);
        }
        if(t.right!=null){
            ans = ans || hasPathSum(t.right, s);
        }
        return ans;
      }
    }
}