
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root==null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        boolean isLeftToRight=true;
        q.add(root);
        TreeNode dummy = new TreeNode(-9999999);
        q.add(dummy);
        List<Integer> curr = new ArrayList<Integer>();
        
        while(!q.isEmpty()){
             TreeNode temp= q.remove();   
            if(temp.val==-9999999){
                if(!isLeftToRight){
                Stack<Integer> s = new Stack<Integer>();
                    s.addAll(curr);
                    List<Integer> al = new ArrayList();
                    while(!s.isEmpty())
                        al.add(s.pop());
                result.add(al);
                } else {
                 result.add(curr);   
                }
                isLeftToRight=!isLeftToRight;
                curr= new ArrayList<Integer>();
                if(q.isEmpty())
                    break;
                q.add(dummy);
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
