import java.util.LinkedList;
import java.util.Queue;

public class BST {

    public Node root = null;

    public class Node {
        Node left;
        Node right;
        int element;

        Node(int e) {
            element = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return " "+element;
        }
    }


    /**
     * Add element to tree in the correct position
     * @param element
     */
    public void add(int element) {
        root = add(root, element);
    }

    /**
     * Auxiliary function for add
     // NO DUPLICATES ALLOWED - skip them
     * @param root
     * @param element
     * @return
     */
    private Node add(Node root, int element) {
        if(root == null){
            root = new Node(element);
            return root;
        }
        else{
            if(element < root.element){
                root.left = add(root.left, element);
            }
            else if(element> root.element){
                root.right = add(root.right, element);
            }
            return root;
        }
    }

    /**
     * Check if an element is present or not
     * @param element
     * @return
     */
    public boolean search(int element) {
        return search(root, element);
    }

    /**
     * Auxiliary function for searching
     * @param node
     * @param element
     * @return
     */
    private boolean search (Node node, int element) {
        if (node == null) {
            return false;
        }

        if (element < node.element) {
            return search(node.left, element);
        }

        if (element > node.element) {
            return search(node.right, element);
        }

        // equal
        return true;
    }

    /**
     * Delete element
     * @param element
     */
    public void delete(int element) {
        root = delete(root, element);
    }

    /**
     * Auxiliary function for deletion of elements
     * @param root
     * @param element
     * @return
     */
    private Node delete(Node root, int element) {
        if (root == null)  return root;
        if (element < root.element)
            root.left = delete(root.left, element);
        else if (element > root.element)
            root.right = delete(root.right, element);
        else
        {

            if(root.left== null && root.right==null)
                return null;
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;


            root.element = findMin(root.right).element;

            root.right = delete(root.right, root.element);
        }

        return root;
    }

    /**
     * Auxiliary function which returns the minimum value of a subtree
     * @param node
     * @return
     */
    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }

        return findMin(node.left);
    }

    /**
     * Return a list of the tree elements in inorder
     * LEFT - NODE - RIGHT
     * @return
     */
    public LinkedList<Integer> inorder() {
        LinkedList<Integer> list = new LinkedList<>();
        inorder(list,root);
        return list;
    }

    /**
     * Auxiliary function
     * @param l
     * @param n
     */
    private void inorder(LinkedList<Integer> l, Node n) {
        if (n == null)
            return;
        inorder(l,n.left);
        l.add(n.element);
        inorder(l,n.right);
    }

    /**
     * Return a list of the tree elements in postorder
     * LEFT - RIGHT - NODE
     * @return
     */
    public LinkedList<Integer> postorder() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        postorder(list,root);
        return list;
        }

    /**
     * Auxiliary function
     * @param l
     * @param n
     */
    private void postorder(LinkedList<Integer> l, Node n) {
        if (n == null)
            return;
        postorder(l,n.left);
        postorder(l,n.right);
        l.add(n.element);
          }

    /**
     * Return a list of the tree elements in preorder
     * NODE - LEFT - RIGHT
     * @return
     */
    public LinkedList<Integer> preorder() {
        if (root == null) {
            return null;
        }

        LinkedList<Integer> l = new LinkedList<>();

        l.addLast(root.element);
        preorder(l, root.left);
        preorder(l, root.right);

        return l;
    }

    /**
     * Auxiliary function
     * @param l
     * @param n
     */
    private void preorder(LinkedList<Integer> l, Node n) {
        // node left right
        if (n == null) {
            return;
        }

        l.addLast(n.element);
        preorder(l, n.left);
        preorder(l, n.right);
    }

    /**
     * Return a list of the tree elements in Breadth First Search order
     * @return
     */
    public LinkedList<Integer> BFS() {
        LinkedList<Integer> l = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            Node element = q.remove();


                if(element.left!= null){
                    ((LinkedList<Node>) q).add(element.left);
                }if (element.right!= null) {
                    q.add(element.right);
                }

            l.add(element.element);
        }

        return l;
    }
}
