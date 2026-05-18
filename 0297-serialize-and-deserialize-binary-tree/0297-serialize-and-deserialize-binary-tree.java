
public class Codec {
    StringBuilder sb = new StringBuilder();

    
    public String serialize(TreeNode root) {
        if(root == null)return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(sb.length() > 0)sb.append(',');

            if(node == null)sb.append('#');
            else{
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();       
    }

    
    public TreeNode deserialize(String data) {
        if(data == null || data.isEmpty())return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i =1;
        while(!queue.isEmpty() && i < arr.length){
            TreeNode parent = queue.poll();

            if(!arr[i].equals("#") && i<arr.length){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                queue.offer(left);
            }
            i++;
            if(!arr[i].equals("#") && i<arr.length){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                queue.offer(right);
            }
            i++;

            
        }
        return root;
    
    }
    
}

