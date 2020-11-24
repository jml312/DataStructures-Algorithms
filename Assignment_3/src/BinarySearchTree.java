/** A Binary Search Tree class */
public class BinarySearchTree {

    /** The Binary Search Tree's root node */
    private Node root;

    /** Keeps track of the kth element */
    private int count;

    /** Inserts a Node with the given key into the Binary Search Tree
     * @param root The root of the tree
     * @param key The key of a node to be inserted */
    public void insert(Node root, int key) {
        // inserts a new node with the key at the root if null
        if (root == null) {
            this.root = new Node(key);
            return;
        }
        // checks if the key is smaller than the root's key
        if (key < root.getKey()) {
            // if there exists a node to the left, the function is recursively called with the left node
            if (root.getLeft() != null) {
                insert(root.getLeft(), key);
            }
            // sets left node to the new node if it is null
            else {
                root.setLeft(new Node(key));
            }
        }
        // checks if the key is greater than the root's key
        else if (key > root.getKey()) {
            // if there exists a node to the right, the function is recursively called with the right node
            if (root.getRight() != null) {
                insert(root.getRight(), key);
            }
            // sets the right node the new node if it is null
            else {
                root.setRight(new Node(key));
            }
        }
    }

    /** Searches for a Node with the given key in the Binary Search Tree
     * @param root the root of the tree
     * @param key the key of a node to search for */
    public Node search(Node root, int key) {
        // returns the root if the root is null or the key is equal to the root's key
        if (root == null || root.getKey() == key) {
            return root;
        }
        // if the key is less than the root's key, the function is recursively called with the left node
        if (key < root.getKey()) {
            return search(root.getLeft(), key);
        }
        // if the key is greater than the root's key, the function is recursively called with the right node
        return search(root.getRight(), key);
    }

    /** Deletes a Node with the given key from in the Binary Search Tree
     * @param root the root of the tree
     * @param key the keu of a node to delete */
    public Node delete(Node root, int key) {
        // returns null if the root is null
        if (root == null) {
            return null;
        }
        // if the key is less than the root's key, the root's left child is set to a recursive function call with the left node
        if (key < root.getKey()) {
            root.setLeft(delete(root.getLeft(), key));
        }
        // if the key is greater than the root's key, the root's right child is set to a recursive function call with the right node
        else if (key > root.getKey()) {
            root.setRight(delete(root.getRight(), key));
        }
        // if the key is equal to the root's key
        else {
            // the root node has two children
            if (root.getLeft() != null && root.getRight() != null) {
                root.setKey(min(root.getRight()).getKey());
                root.setRight(delete(root.getRight(), min(root.getRight()).getKey()));
            }
            // the root node has a left child
            else if(root.getLeft() != null) {
                root = root.getLeft();
            }
            // the root node has a right child
            else if(root.getRight() != null) {
                root = root.getRight();
            }
            // the root node has no children
            else {
                root = null;
            }

        }
        return root;
    }

    /** Returns the smallest node in the Binary Search Tree
     * @return Node the smallest node in the Binary Search Tree
     * @param root the root of the tree */
    public Node min(Node root) {
        // returns the root if the current node's left child is null
        if (root.getLeft() == null) {
            return root;
        }
        // recursively calls the function with the left node of the current node
        return min(root.getLeft());
    }

    /** Traverses the Binary Search Tree Inorder (left, node, right)
     * @param root the root of the tree */
    public void inorderRec(Node root) {
        // checks if the current root is not null
        if (root != null) {
            // recursive call with the left node of the the current root
            inorderRec(root.getLeft());
            System.out.print(root.getKey() + ", ");
            // recursive call with the right node of the current root
            inorderRec(root.getRight());
        }
    }

    /** The kth smallest Node in the Binary Search Tree
     * @return Node the kth smallest Node in the Binary Search Tree
     * @param root the root of the tree
     * @param k the kth smallest element to search for */
    public Node kthSmallest(Node root, int k) {
        // returns null if the root is null
        if (root == null) {
            return null;
        }
        // recursive function call with the current root's left node
        Node left = kthSmallest(root.getLeft(), k);

        // returns the left node variable if it is not equal to null
        if (left != null) {
            return left;
        }

        count++;
        // returns the root if the count is equal to k and resets the count
        if (count == k) {
            count = 0;
            return root;
        }
        // recursively calls the function with the root's right node
        return kthSmallest(root.getRight(), k);
    }

    /** Returns the root Node in the Binary Search Tree
     * @return Node the root Node of the Binary Search Tree */
    public Node getRoot() {
        return root;
    }
}