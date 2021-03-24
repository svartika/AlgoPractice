package February;

public class CopyListWithRandomPtr {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if(head==null) return null;
            Node current = head, newHead=null;
            createNewNodesAndInsertThemInCurrentList(current);
            current = head;
            setNewRandomPtrs(current);
            current = head;
            newHead = extractNewList(current);
            return newHead;
        }

        private void createNewNodesAndInsertThemInCurrentList(Node current) {
            while(current!=null) {
                Node newNode = new Node(current.val);
                newNode.next = current.next;
                current.next = newNode;
                current = newNode.next;
            }
        }

        private void setNewRandomPtrs(Node current) {
            Node oldCurr= current;
            Node newCurr = current.next;
            while(oldCurr!=null ) {
                if(oldCurr.random!=null) {
                    newCurr.random = oldCurr.random.next;
                }
                if(oldCurr.next!=null) oldCurr = oldCurr.next.next;
                else break;
                if(newCurr.next!=null) newCurr = newCurr.next.next;
                else break;
            }
        }

        private Node extractNewList(Node current) {
            Node oldCurr = current;
            Node newCurr = current.next;
            Node newHead = newCurr;
            while(oldCurr!=null && newCurr!=null ) {
                if(newCurr.next == null) break;
                oldCurr.next = oldCurr.next.next;
                newCurr.next = newCurr.next.next;
                oldCurr = oldCurr.next;
                newCurr = newCurr.next;


            }
            oldCurr.next = null;
            return newHead;
        }
    }

    public static void main(String args[]) {
        Node root = new CopyListWithRandomPtr().new Node(7);
        Node n1 = new CopyListWithRandomPtr().new Node(13);
        Node n2 = new CopyListWithRandomPtr().new Node(11);
        Node n3 = new CopyListWithRandomPtr().new Node(10);
        Node n4 = new CopyListWithRandomPtr().new Node(1);
        root.next = n1;
        n1.next = n2; n1.random = root;
        n2.next = n3; n2.random = n4;
        n3.next = n4; n3.random =n2;
        n4.random = root;

        Node newRoot = new CopyListWithRandomPtr().new Solution().copyRandomList(root);
        while(newRoot!=null) {
            int randVal = newRoot.random==null? -1 : newRoot.random.val;
            System.out.print(newRoot.val + " " + randVal + " .. ");
            newRoot = newRoot.next;
        }
    }
}
