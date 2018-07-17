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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || inorder.length==0)
            return null;
        
         if(preorder==null || inorder==null)
            return null;
        
        return buildTreeFromTraversal(0,inorder.length-1,inorder,0,preorder.length-1,preorder);
    }
    
    public TreeNode buildTreeFromTraversal(int inStart, int inEnd,int[] inorder,int preStart, int preEnd,int[] preorder){
        if(inStart>inEnd || preStart>preEnd)
            return null;
        TreeNode root =  new TreeNode(preorder[preStart]);
        int index=inStart;
        for(int i=inStart; i<=inEnd;i++)
            if(inorder[i]==root.val){
                index=i;
                break;
            }
        
        root.left= buildTreeFromTraversal(inStart,index-1,inorder,preStart+1,preStart+(index-inStart),preorder);
        root.right= buildTreeFromTraversal(index+1,inEnd,inorder,preStart+(index-inStart)+1,preorder.length-1,preorder);
        return root;
    }
}
