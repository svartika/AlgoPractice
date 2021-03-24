package February;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if(root==null) return list;
            Queue<TreeNode> nodeQ = new LinkedList<>();
            Queue<Integer> heightQ = new LinkedList<>();
            TreeNode iter = root;
            int height = 1, prevHeight = 0;
            nodeQ.add(iter);
            heightQ.add(height);
            while(iter!=null && !nodeQ.isEmpty()) {
                iter = nodeQ.remove();
                height = heightQ.remove();
                if(prevHeight!=height) {
                    prevHeight = height;
                    list.add(iter.val);
                }

                if(iter.right!=null) {
                    nodeQ.add(iter.right);
                    heightQ.add(height+1);
                }
                if(iter.left!=null) {
                    nodeQ.add(iter.left);
                    heightQ.add(height+1);
                }
                height++;
            }
            return list;
        }
    }

    public  static void main(String [] args) {
       /* TreeNode root = new BinaryTreeRightSideView().new TreeNode(1);
        root.left = new BinaryTreeRightSideView().new TreeNode(2);
        root.left.right = new BinaryTreeRightSideView().new TreeNode(5);
        root.right = new BinaryTreeRightSideView().new TreeNode(3);
        root.right.left = new BinaryTreeRightSideView().new TreeNode(6);
        root.right.right = new BinaryTreeRightSideView().new TreeNode(4);
        root.right.left.right = new BinaryTreeRightSideView().new TreeNode(7);
        root.right.right.right = new BinaryTreeRightSideView().new TreeNode(8);*/

        TreeNode root = new BinaryTreeRightSideView().new TreeNode(6);
        root.left = new BinaryTreeRightSideView().new TreeNode(1);
        root.left.right = new BinaryTreeRightSideView().new TreeNode(3);
        root.left.right.left = new BinaryTreeRightSideView().new TreeNode(2);
        root.left.right.right = new BinaryTreeRightSideView().new TreeNode(5);
        root.left.right.right.right = new BinaryTreeRightSideView().new TreeNode(4);

        List<Integer> list = new BinaryTreeRightSideView().new Solution().rightSideView(root);
        for(int num : list) {
            System.out.print(num + " ");
        }
    }
}
