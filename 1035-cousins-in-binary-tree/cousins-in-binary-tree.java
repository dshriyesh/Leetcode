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
    public boolean isCousins(TreeNode root, int x, int y) {
        int xlvl=0;
        int ylvl=0;
        int cnt=1;
        Queue<TreeNode> q= new LinkedList<>();
        if(root==null) return false;
        q.offer(root);
        while(!q.isEmpty()){
            int lvlsize=q.size();
            for(int i=0;i<lvlsize;i++){
                TreeNode curr=q.poll();
                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) || 
                        (curr.left.val == y && curr.right.val == x)) {
                 return false;
    }   
}

                if(curr.val==x) xlvl=cnt;
                if(curr.val==y) ylvl=cnt;

                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);

            }
            cnt++;
        }
        return (xlvl==ylvl);

    }
}