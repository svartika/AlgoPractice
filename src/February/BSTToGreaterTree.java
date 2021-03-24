package February;

import java.util.Stack;

public class BSTToGreaterTree {
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
        public TreeNode convertBST(TreeNode root) {
            TreeNode current = root;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            int sum = 0;
            while(current!=null || !stack.isEmpty()) {
                while(current!=null) {
                    stack.push(current);
                    current = current.right;
                }
                current = stack.pop();
                current.val += sum;
                sum = current.val;
                System.out.print(current.val + " ");
                current = current.left;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        TreeNode leaf1 = new BSTToGreaterTree().new TreeNode(0 );
        TreeNode leaf2 = new BSTToGreaterTree().new TreeNode(3 );
        TreeNode leaf3 = new BSTToGreaterTree().new TreeNode(5 );
        TreeNode leaf4 = new BSTToGreaterTree().new TreeNode(8 );

        TreeNode mid1 = new BSTToGreaterTree().new TreeNode(2, null, leaf2);
        TreeNode mid2= new BSTToGreaterTree().new TreeNode(7, null, leaf4);
        TreeNode mid3 = new BSTToGreaterTree().new TreeNode(1, leaf1, mid1);
        TreeNode mid4 = new BSTToGreaterTree().new TreeNode(6, leaf3, mid2);

        TreeNode root = new BSTToGreaterTree().new TreeNode(4, mid3, mid4);

        new BSTToGreaterTree().new Solution().convertBST(root);
    }
}
