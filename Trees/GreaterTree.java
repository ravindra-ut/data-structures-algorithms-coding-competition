class GreaterTree {
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    // sum is more like a global variable for us
    // tracking the right subtree sum
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        // right most subtree will be unchanged
        // as its the greatest
        convertBST(root.right);
        
        root.val += sum;
        sum = root.val;
        
        convertBST(root.left);
        return root;
    }
}