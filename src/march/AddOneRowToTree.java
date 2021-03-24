package march;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AddOneRowToTree {
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
        private class QObject {
            TreeNode node; int height;
            QObject(TreeNode node, int height) {
                this.height = height; this.node = node;
            }
        }
        TreeNode insertAtRootNode(TreeNode root, int v, int d) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        void insertInToDepth(TreeNode root, int v, int d) {
            /*Queue<QObject> q = new LinkedList<QObject>();
            q.add(new QObject(root, 1)) ;
            int prevHeight = 0;
            while(!q.isEmpty() && q.peek().height<=d) {
                if(prevHeight!=q.peek().height) {
                    QObject o = q.remove();
                    TreeNode current = o.node;
                    prevHeight = o.height;
                    if (current.left != null) q.add(new QObject(current.left, prevHeight + 1));
                    if (current.right != null) q.add(new QObject(current.right, prevHeight + 1));
                } else {
                    prevHeight = q.peek().height;
                    if (current.left != null) q.add(new QObject(current.left, prevHeight + 1));
                    if (current.right != null) q.add(new QObject(current.right, prevHeight + 1));
                }
            }*/
            Queue<QObject> q = new LinkedList<QObject>();
            q.add(new QObject(root, 1)) ;
            while(!q.isEmpty()) {
                QObject o = q.remove();
                TreeNode current = o.node;
                int height = o.height;
                if(height==d-1) {
                    TreeNode left = new TreeNode(v);
                    TreeNode right = new TreeNode(v);

                    TreeNode temp = current.left;
                    current.left = left;
                    left.left = temp;

                    temp = current.right;
                    current.right = right;
                    right.right = temp;
                } else {
                    if (current.left != null) q.add(new QObject(current.left, height + 1));
                    if (current.right != null) q.add(new QObject(current.right, height + 1));
                }
            }
        }

        public TreeNode addOneRow(TreeNode root, int v, int d) {
            if(d==1) {
                TreeNode newRoot = insertAtRootNode(root, v, d);
                return newRoot;
            } else {
                insertInToDepth(root, v, d);
                return root;
            }
        }

        public void printTree(TreeNode root) {
            TreeNode current = root;
            Stack<TreeNode> stk = new Stack<>();
            while(current!=null || !stk.isEmpty()) {
                while(current!=null) {
                    stk.push(current);
                    current = current.left;
                }
                current  = stk.pop();
                System.out.print(current.val+ " ");
                current = current.right;
            }
        }
    }

    public static void main( String args[]) {
        AddOneRowToTree o = new AddOneRowToTree();
        TreeNode n3 = o.new TreeNode(3, null, null);
        TreeNode n4 = o.new TreeNode(1, null, null);

        TreeNode n5 = o.new TreeNode(5, null, null);

        TreeNode n1 = o.new TreeNode(2, n3, n4);
        TreeNode n2 = o.new TreeNode(6, n5, null);

        TreeNode root = o.new TreeNode(4, n1, n2);

        Solution s = o.new Solution();
        //TreeNode newRoot = s.addOneRow(root, 1, 2);
        TreeNode newRoot = s.addOneRow(root, 1, 1);
        s.printTree(newRoot);
    }
}
