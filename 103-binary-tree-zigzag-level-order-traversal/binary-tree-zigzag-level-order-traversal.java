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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null){
            return ans;
        }
        Deque<TreeNode> dq= new LinkedList<>();
        dq.offer(root);
        Boolean rev=false;
        while(!dq.isEmpty()){
            List<Integer> currLevel= new ArrayList<>();
            int levelsize=dq.size();
            for(int i=0;i<levelsize;i++){
                if(!rev){
                    TreeNode curr=dq.pollFirst();
                    currLevel.add(curr.val);
                    if(curr.left!=null) dq.addLast(curr.left);
                    if(curr.right!=null) dq.addLast(curr.right);
                }
                else{
                    TreeNode curr=dq.pollLast();
                    currLevel.add(curr.val);
                    if(curr.right!=null) dq.addFirst(curr.right);
                    if(curr.left!=null) dq.addFirst(curr.left);
                }
            }
            rev=!rev;
            ans.add(currLevel);
        }return ans;
    }
}