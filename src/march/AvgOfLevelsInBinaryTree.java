package march;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgOfLevelsInBinaryTree {

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

    class QItem {
        int height;
        TreeNode node;
        QItem(int height, TreeNode node) {
            this.height = height; this.node = node;
        }
    }

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> averages = new ArrayList<>();
            Queue<QItem> q = new LinkedList<>();
            q.add(new QItem(1, root));
            double sum = 0;
            int numItems = 0;
            int prevHeight = 1;
            while(!q.isEmpty()) {
                QItem item = q.poll();
                int height = item.height;
                if(prevHeight==item.height) {
                    numItems++;
                    sum+=item.node.val;
                } else {
                    double levelAverage = sum/numItems;
                    averages.add(levelAverage);
                    numItems=1;
                    sum=item.node.val;
                    prevHeight = height;
                }
                if(item.node.left!=null) q.add(new QItem(height+1, item.node.left));
                if(item.node.right!=null) q.add(new QItem(height+1, item.node.right));
            }
            double levelAverage = sum/numItems;
            averages.add(levelAverage);
            return averages;
        }
    }

    public static void main(String args[]) {
        AvgOfLevelsInBinaryTree.TreeNode root = new AvgOfLevelsInBinaryTree().new TreeNode(3);
        root.left = new AvgOfLevelsInBinaryTree().new TreeNode(9);
        root.right = new AvgOfLevelsInBinaryTree().new TreeNode(20);
        root.right.left =  new AvgOfLevelsInBinaryTree().new TreeNode(15);
        root.right.right =  new AvgOfLevelsInBinaryTree().new TreeNode(7);
        List<Double> averages = new AvgOfLevelsInBinaryTree().new Solution().averageOfLevels(root);
        for(Double avg: averages) {
            System.out.print(avg + " ");
        }
    }
}
