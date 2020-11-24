/** A Node class */
public class Node {

    /** the Node's key */
    private int key;

    /** The Node's left and right Node */
    private Node left, right;

    /** @param key the Node's key */
    public Node(int key) {
        this.key = key;
    }

    /** @return the Node's key */
    public int getKey() {
        return key;
    }

    /** @param key the Node's key
     * Set's the Node's key */
    public void setKey(int key) {
        this.key = key;
    }

    /** Returns the Node's left child
     * @return the Node's left child */
    public Node getLeft() {
        return left;
    }

    /** Sets the Node's left child
     * @param left the Node's left child */
    public void setLeft(Node left) {
        this.left = left;
    }

    /** Returns the Node's right child
     * @return the Node's right child */
    public Node getRight() {
        return right;
    }

    /** Sets the Node's right child
     * @param right the Node's right child */
    public void setRight(Node right) {
        this.right = right;
    }
}