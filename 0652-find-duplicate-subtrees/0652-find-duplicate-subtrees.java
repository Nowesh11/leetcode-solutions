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
    HashMap<String,Integer> map = new HashMap<>();

    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        dfs(root);

        return res;
        
    }

    public String dfs(TreeNode root){

        if(root==null){
            return "#";
        }
        String left = dfs(root.left);
        String right = dfs(root.right);

        String s = root.val + "," + left + "," + right;

        map.put(s,map.getOrDefault(s,0)+1);

        if(map.get(s) ==2){
            res.add(root);
        }
        return s;
    }
}