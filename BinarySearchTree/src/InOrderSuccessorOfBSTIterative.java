public class InOrderSuccessorOfBSTIterative {
    public static void main(String[] args) {

    }

    public int inorderSuccessor(Node root, Node x) {
        // If the right subtree exists, find the leftmost node in the right subtree
        if (x.right != null) {
            return findLeftMost(x.right);
        }

        // Otherwise, traverse from root to find the successor
        Node successor = null;
        Node temp = root;

        while (temp != null) {
            if (x.data < temp.data) {
                // If x is smaller than temp, temp could be the successor
                successor = temp;
                temp = temp.left;
            } else if (x.data > temp.data) {
                // If x is greater, go to the right subtree
                temp = temp.right;
            } else {
                // Node x is found, break the loop
                break;
            }
        }

        return successor != null ? successor.data : -1; // Return the successor or -1 if not found
    }

    public int findLeftMost(Node root) {
        Node left = root;
        while (left.left != null) {
            left = left.left;
        }
        return left.data;
    }
}
