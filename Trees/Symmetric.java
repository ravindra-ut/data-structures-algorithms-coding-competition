class Symmetric {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }
    
    public boolean isSameTree(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        } else if(left.val != right.val){
            return false;
        } else {
            return isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
        }
    }
    
    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSameTree(root.left, root.right);
    }
}