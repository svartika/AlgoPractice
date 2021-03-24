package February;


import java.util.Stack;

public class TrimBST {
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
        public TreeNode trimBST(TreeNode root, int low, int high) {
            root = removeFromLowerBound(root, low, root, null);
            root = removeFromUpperBound(root, high, root, null);
            return root;
        }

        private TreeNode removeFromLowerBound(TreeNode current, int low, TreeNode root, TreeNode prevParent) {
            if (current == null) return root;
            if (current.val >= low) {
                removeFromLowerBound(current.left, low, root, current);
            } else if (current.val < low) {
                if (current == root) {
                    root = current.right;
                } else {
                    prevParent.left = current.right;
                }
                current = current.right;
                root = removeFromLowerBound(current, low, root, prevParent);
            }
            return root;
        }

        private TreeNode removeFromUpperBound(TreeNode current, int high, TreeNode root, TreeNode prevParent) {
            if (current == null) return root;
            if (current.val <= high) {
                removeFromUpperBound(current.right, high, root, current);
            } else if (current.val > high) {
                if (current == root) {
                    root = current.left;
                } else {
                    prevParent.right = current.left;
                }
                current = current.left;
                root = removeFromUpperBound(current, high, root, prevParent);
            }
            return root;
        }

        private void traverseInOrder(TreeNode root) {
            Stack<TreeNode> stk = new Stack();
            TreeNode current = root;
            while (!stk.isEmpty() || current != null) {
                while (current != null) {
                    stk.push(current);
                    current = current.left;
                }
                current = stk.pop();
                System.out.print(current.val + " ");
                current = current.right;
            }
        }
    }

    public static void main(String args[]) {
       /* TreeNode child1 = new TrimBST().new TreeNode(0);
        TreeNode child2 = new TrimBST().new TreeNode(2);
        TreeNode root = new TrimBST().new TreeNode(1, child1, child2);

        int low=1, high=2;*/

        /*TreeNode child3 = new TrimBST().new TreeNode(1);
        TreeNode child2 = new TrimBST().new TreeNode(2, child3, null);
        TreeNode child1 = new TrimBST().new TreeNode(0, null, child2);

        TreeNode child4 = new TrimBST().new TreeNode(4);

        TreeNode root = new TrimBST().new TreeNode(3, child1, child4);

        int low=1, high=3;*/


        /*TreeNode child1 = new TrimBST().new TreeNode(2);
        TreeNode root = new TrimBST().new TreeNode(1, null, child1);

        int low=2, high=4;*/

       /* TreeNode child2 = new TrimBST().new TreeNode(4);

        TreeNode child3 = new TrimBST().new TreeNode(2);
        TreeNode child1 = new TrimBST().new TreeNode(1, null, child3);

        TreeNode root = new TrimBST().new TreeNode(3, child1, child2);

        int low = 3, high = 4;*/

        TreeNode child2 = new TrimBST().new TreeNode(4);

        TreeNode child3 = new TrimBST().new TreeNode(1);
        TreeNode child1 = new TrimBST().new TreeNode(2,  child3, null);

        TreeNode root = new TrimBST().new TreeNode(3, child1, child2);

        int low = 1, high = 1;

        Solution o = new TrimBST().new Solution();
        TreeNode newRoot = o.trimBST(root, low, high);
        o.traverseInOrder(newRoot);

    }
}
