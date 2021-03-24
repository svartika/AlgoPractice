package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeKevelOrderTraversal {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> lists = new ArrayList<>();
            if (root==null) return lists;
            Stack<TreeNode> nodeStack = new Stack<>();
            Stack<Integer> heightStack = new Stack<>();
            nodeStack.push(root);
            int height = 1;
            heightStack.push(height);
            while(!nodeStack.isEmpty()) {
                TreeNode node = nodeStack.pop();
                height = heightStack.pop();
                insertInToList(node, lists, height);
                height++;

                if(node.right!=null) {
                    nodeStack.push(node.right);
                    heightStack.push(height);
                }

                if(node.left!=null) {
                    nodeStack.push(node.left);
                    heightStack.push(height);
                }
            }
            return lists;
        }

        private void insertInToList(TreeNode node, List<List<Integer>> lists, int height) {
            List<Integer> list;
            if(lists.size()<height) {
                list = new ArrayList<Integer>();
                lists.add(list);
            }
            list = lists.get(height-1);
            list.add(node.val);
        }
    }

    public static void main(String args[]) {

        TreeNode child1 = new BinaryTreeKevelOrderTraversal().new TreeNode(9, null, null);

        TreeNode child5 = new BinaryTreeKevelOrderTraversal().new TreeNode(15);
        TreeNode child6 = new BinaryTreeKevelOrderTraversal().new TreeNode(7);
        TreeNode child2 = new BinaryTreeKevelOrderTraversal().new TreeNode(20, child5, child6);

        TreeNode root = new BinaryTreeKevelOrderTraversal().new TreeNode(3, child1, child2);

        List<List<Integer>> lists = new BinaryTreeKevelOrderTraversal().new Solution().levelOrder(root);

        for(List<Integer>list: lists) {
            for(int num: list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
