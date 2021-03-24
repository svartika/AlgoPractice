package Trees;

import java.util.Stack;

public class ConvertSortedArrayToBST {

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
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums==null || nums.length==0) return null;
            TreeNode root = setCenterNode(0, nums.length-1, nums);
            return root;
        }

        private TreeNode setNode(int val) {
            return new TreeNode(val);
        }

        private TreeNode setCenterNode(int start, int end, int[] nums) {
            if(start>end) return null;
            int mid = (start+end)/2;
            TreeNode parent = setNode(nums[mid]);
            parent.left = setCenterNode(start, mid-1, nums);
            parent.right = setCenterNode(mid+1, end, nums);
            return parent;
        }

        public void traverseInorder(TreeNode root) {
            Stack<TreeNode> stk = new Stack<>();
            //stk.push(root);
            TreeNode current = root;
            while(!stk.isEmpty() || current!=null){
                while(current!=null) {
                    stk.push(current);
                    current = current.left;
                }
                current = stk.pop();
                System.out.print(current.val + " ");
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-10, -3, 0, 5, 9};
        Solution s = new ConvertSortedArrayToBST().new Solution();
        TreeNode root = s.sortedArrayToBST(nums);
        s.traverseInorder(root);
    }
}
