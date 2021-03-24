package Trees;

import java.util.Stack;

public class ValidateBST {
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
        public boolean isValidBST(TreeNode root) {
           /* boolean ret = true;
            if(root==null) return true;
            if(root.left!=null && root.left.val>=root.val) ret = false;
            if(root.right!=null && root.right.val<=root.val) ret = false;
            if(root.left!=null) ret = ret==false? false : isValidBST(root.left);
            if(root.right!=null) ret = ret==false? false: isValidBST(root.right);
            return ret;*/

            if(root==null) return true;
            Stack<TreeNode> stk = new Stack<>();
            TreeNode leftParentOfParent = null;
            TreeNode current = root;
            while(!stk.isEmpty() || current!=null) {
                while(current!=null) {
                    stk.push(current);
                    current = current.left;
                }
                current = stk.pop();
                if(leftParentOfParent!=null && current.val<=leftParentOfParent.val) return false;
                leftParentOfParent = current;
                current = current.right;
            }
            return true;
        }
    }

    public static void main(String args[]) {

       /* TreeNode child1 = new ValidateBST().new TreeNode(1, null, null);
        TreeNode child2 = new ValidateBST().new TreeNode(3, null, null);
        TreeNode root = new ValidateBST().new TreeNode(2, child1, child2);*/

        /*TreeNode child1 = new ValidateBST().new TreeNode(1, null, null);

        TreeNode child3 = new ValidateBST().new TreeNode(3);
        TreeNode child4 = new ValidateBST().new TreeNode(6);
        TreeNode child2 = new ValidateBST().new TreeNode(4, child3, child4);

        TreeNode root = new ValidateBST().new TreeNode(5, child1, child2);*/

        /*TreeNode child1 = new ValidateBST().new TreeNode(2, null, null);
        TreeNode root = new ValidateBST().new TreeNode(1, null, child1);*/

        //TreeNode root = new ValidateBST().new TreeNode(1, null, null);

        //ValidateBST.TreeNode root = null;

        /*TreeNode child1 = new ValidateBST().new TreeNode(4, null, null);

        TreeNode child3 = new ValidateBST().new TreeNode(3);
        TreeNode child4 = new ValidateBST().new TreeNode(7);
        TreeNode child2 = new ValidateBST().new TreeNode(6, child3, child4);

        TreeNode root = new ValidateBST().new TreeNode(5, child1, child2);
*/
        TreeNode child1 = new ValidateBST().new TreeNode(1, null, null);
        TreeNode root = new ValidateBST().new TreeNode(1, child1, null);



        System.out.println(new ValidateBST().new Solution().isValidBST(root));
    }
}