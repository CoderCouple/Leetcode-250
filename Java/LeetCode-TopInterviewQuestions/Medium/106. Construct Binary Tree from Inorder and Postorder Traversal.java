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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0)
            return null;
        if(inorder==null || postorder==null)
            return null;
        return buildTreeFromTraversal(0,inorder.length-1,inorder,0,postorder.length-1,postorder);
    }
    
    public TreeNode buildTreeFromTraversal(int inStart,int inEnd,int[] inorder,int postStart,int postEnd,int[] postorder){
        if(inStart>inEnd || postStart>postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]); // Changed here to make it work for the InOrder & PostOrder
        int index=inStart;
        for(int i=inStart;i<=inEnd;i++)
            if(inorder[i]==root.val){
                index=i;
                break;
            }
            
        root.left=buildTreeFromTraversal(inStart,index-1,inorder,postStart,postStart+(index-inStart)-1,postorder);
        root.right=buildTreeFromTraversal(index+1,inEnd,inorder,postStart+(index-inStart),postEnd-1,postorder);
        return root;
    }
}
