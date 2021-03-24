package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        /*private boolean isMirror(TreeNode left, TreeNode right) {
            if(left==null && right==null) return true;
            if(left==null || right==null) return false;
            if(left.val!=right.val) return false;
            boolean ret = isMirror(left.left, right.right);
            ret = ret==false? false: isMirror(left.right, right.left);
            return ret;
        }

        public boolean isSymmetric(TreeNode root) {
            if(root==null) return true;
            return isMirror(root.left, root.right);
        }*/

        public boolean isSymmetric(TreeNode root) {
            if(root==null) return true;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            q.add(root);
            while(!q.isEmpty()) {
                TreeNode left = q.poll();
                TreeNode right = q.poll();
                if(left.val!=right.val) return false;
                if(left.left!=null && right.right!=null) {
                    q.add(left.left);
                    q.add(right.right);
                } else if(left.left!=null || right.right!=null) {
                    return false;
                }
                if(left.right!=null && right.left!=null) {
                    q.add(left.right);
                    q.add(right.left);
                } else if(left.right!=null || right.left!=null) {
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String args[]) {
        /*TreeNode child1 = new SymmetricTree().new TreeNode(4, null, null);

        TreeNode child3 = new SymmetricTree().new TreeNode(3);
        TreeNode child4 = new SymmetricTree().new TreeNode(7);
        TreeNode child2 = new SymmetricTree().new TreeNode(6, child3, child4);

        TreeNode root = new SymmetricTree().new TreeNode(5, child1, child2);*/

        TreeNode child3 = new SymmetricTree().new TreeNode(3);
        TreeNode child4 = new SymmetricTree().new TreeNode(7);
        TreeNode child1 = new SymmetricTree().new TreeNode(6, child3, child4);

        TreeNode child5 = new SymmetricTree().new TreeNode(7);
        TreeNode child6 = new SymmetricTree().new TreeNode(3);
        TreeNode child2 = new SymmetricTree().new TreeNode(6, child5, child6);

        TreeNode root = new SymmetricTree().new TreeNode(5, child1, child2);


        /*TreeNode child3 = new SymmetricTree().new TreeNode(4);
        TreeNode child4 = new SymmetricTree().new TreeNode(5);
        TreeNode child1 = new SymmetricTree().new TreeNode(3, child3, child4);

        TreeNode child5 = new SymmetricTree().new TreeNode(5);
        TreeNode child2 = new SymmetricTree().new TreeNode(3, child5, null);

        TreeNode root = new SymmetricTree().new TreeNode(2, child1, child2);*/

        System.out.println(new SymmetricTree().new Solution().isSymmetric(root));
    }
}
