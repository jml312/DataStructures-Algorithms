public class Test {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        // Inserting
        System.out.println("Inserting:");
        binarySearchTree.insert(binarySearchTree.getRoot(), 2);
        binarySearchTree.insert(binarySearchTree.getRoot(), 1);
        binarySearchTree.insert(binarySearchTree.getRoot(), 4);
        binarySearchTree.insert(binarySearchTree.getRoot(), 5);
        binarySearchTree.insert(binarySearchTree.getRoot(), 9);
        binarySearchTree.insert(binarySearchTree.getRoot(), 3);
        binarySearchTree.insert(binarySearchTree.getRoot(), 6);
        binarySearchTree.insert(binarySearchTree.getRoot(), 7);
        binarySearchTree.insert(binarySearchTree.getRoot(), 10);
        binarySearchTree.insert(binarySearchTree.getRoot(), 12);
        binarySearchTree.insert(binarySearchTree.getRoot(), 11);
        System.out.print("BST after inserting: 2, 1, 4, 5, 9, 3, 6, 7, 10, 12, 11 --> ");
        binarySearchTree.inorderRec(binarySearchTree.getRoot());

        System.out.println();
        System.out.println();

        // Deleting
        System.out.println("Deleting:");
        System.out.print("BST after deleting 4 --> ");
        binarySearchTree.delete(binarySearchTree.getRoot(), 4);
        binarySearchTree.inorderRec(binarySearchTree.getRoot());
        System.out.println();
        System.out.print("BST after deleting 9 --> ");
        binarySearchTree.delete(binarySearchTree.getRoot(), 9);
        binarySearchTree.inorderRec(binarySearchTree.getRoot());

        System.out.println();
        System.out.println();

        // Searching
        System.out.println("Searching:");
        System.out.println("Searching for 12 --> " + binarySearchTree.search(binarySearchTree.getRoot(), 12).getKey());
        System.out.println("Searching for 4 --> " + binarySearchTree.search(binarySearchTree.getRoot(), 4));

        System.out.println();

        // Kth smallest element
        System.out.println("Kth Smallest Element:");
        System.out.println("3rd minimum item --> " + binarySearchTree.kthSmallest(binarySearchTree.getRoot(), 3).getKey());
    }
}