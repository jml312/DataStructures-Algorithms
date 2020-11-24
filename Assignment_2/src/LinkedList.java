/** A Linked List class  */
public class LinkedList {

    /** the head node of the linked list */
    Node head;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // Adding 5 random numbers from 1 to 100 to the linked list
        for (int i = 0; i < 5; i++) {
            linkedList.add(new Node(1 + (int) Math.round(Math.random() * 99)));
        }

        // linked list before reversal
        System.out.print("Before reversal: ");
        linkedList.printList(linkedList.head);

        // linked list after reversal
        System.out.print("After reversal: ");
        linkedList.printList(linkedList.reverse());
    }

    /* A singly-linked node class */
    private static class Node {
        /** the data of the node */
        int data;

        /** the next node */
        Node next;

        /** @param data the data of the node */
        Node(int data) {
            this.data = data;
        }
    }

    /** adds a node to a linked list
     * @param node the node to be added to the linked list */
    public void add(Node node) {
        // checks if the linked list is empty
        if (head == null) {
            head = node;
        }
        // the linked list is not empty
        else {
            Node end = head;
            // loops through each node of the linked list until it reaches the last node
            while (end.next != null) {
                end = end.next;
            }
            // sets the next node of the last node in the linked list to the new node that is added
            end.next = node;
        }
    }

    /** reverses a linked list and returns the head of the reversed list
     * @return the head node of the reversed linked list */
    public Node reverse() {
        // previous node in the linked list
        Node previous = null;

        // current node in the linked list
        Node curr = head;

        // next node in the linked list
        Node next;

        // loops through the linked list until its hits a null node
        while (curr != null) {
            // saving a reference to the next node
            next = curr.next;
            // pointing the current node's next node to the previous node
            curr.next = previous;
            // moving the previous node to the current node
            previous = curr;
            // moving the current node to the next node
            curr = next;
        }
        return previous;
    }

    /** prints a linked list
     * @param head the head of the linked list */
    public void printList(Node head) {
        Node curr = head;
        // loops through each node of the linked list until it hits a null node
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println();
    }
}