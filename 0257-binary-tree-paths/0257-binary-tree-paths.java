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
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,new StringBuilder());
        return res;
    }
    public void dfs(TreeNode root, StringBuilder s){
        
        if(root == null)return;
        StringBuilder sb = new StringBuilder(s);
        if(sb.length() > 0)sb.append("->");
        sb.append(root.val);
        
        if(root.left == null && root.right == null){
            res.add(sb.toString());
        }
        dfs(root.left,sb);
        dfs(root.right,sb);
        

        sb.deleteCharAt(sb.length()-1);

    }
}