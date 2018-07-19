/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode marker = new TreeNode(-1);
        List<Integer> curr = new ArrayList<Integer>();
        q.add(root);
        q.add(marker);
        
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp==marker){
                result.add(curr);
                curr = new ArrayList<Integer>();
                if(q.isEmpty())
                    break;
                q.add(marker);
            } else {
                curr.add(temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                
                if(temp.right!=null)
                    q.add(temp.right);
                
            }
        }
        
        return result;
    }
}
