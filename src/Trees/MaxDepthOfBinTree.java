package Trees;

import java.util.Stack;

public class MaxDepthOfBinTree {

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
        public int maxDepthIterative(TreeNode root) {
            if(root==null) return 0;
            //if(root.left==null && root.right==null) return 1;
            Stack<TreeNode> nodeStack = new Stack<>();
            nodeStack.push(root);
            Stack<Integer> heightStack = new Stack<>();
            int height = 1;
            heightStack.push(height);
            while(!nodeStack.empty()) {
                TreeNode node = nodeStack.pop();
                int currentHeight = heightStack.pop();
                height = Math.max(height, currentHeight);
                if(node.left!=null) {
                    nodeStack.push(node.left);
                    heightStack.push(currentHeight+1);
                }
                if(node.right!=null) {
                    nodeStack.push(node.right);
                    heightStack.push(currentHeight+1);
                }
            }
            return height;
        }

        public int maxDepth(TreeNode root) {
            if(root==null) return 0;
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    public  static void main(String args[]) {
      /*  TreeNode child1 = new MaxDepthOfBinTree().new TreeNode(9, null, null);

        TreeNode child3 = new MaxDepthOfBinTree().new TreeNode(15);
        TreeNode child4 = new MaxDepthOfBinTree().new TreeNode(7);
        TreeNode child2 = new MaxDepthOfBinTree().new TreeNode(20, child3, child4);

        TreeNode root = new MaxDepthOfBinTree().new TreeNode(3, child1, child2);*/

        /*TreeNode child1 = new MaxDepthOfBinTree().new TreeNode(2, null, null);
        TreeNode root = new MaxDepthOfBinTree().new TreeNode(1, null, child1);*/

        //TreeNode root = new MaxDepthOfBinTree().new TreeNode(1, null, null);

        TreeNode root = null;

        System.out.println(new MaxDepthOfBinTree().new Solution().maxDepth(root));
    }
}
