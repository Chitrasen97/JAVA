// Node class represents each element in the linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class to manage all linked list operations
public class SinglyLinkedList {
    Node head = null;

    // Insert at the beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at specific position
    void insertAtPosition(int position, int data) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete from beginning
    void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    // Delete from end
    void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete at specific position
    void deleteAtPosition(int position) {
        if (head == null || position < 1) {
            System.out.println("Invalid position or list is empty.");
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Position out of range.");
            return;
        }

        temp.next = temp.next.next;
    }

    // Display the linked list
    void display() {
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Main method to run and test all functions
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert at beginning (3 numbers)
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.display();

        // Insert at end (3 numbers)
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        list.display();

        // Insert at specific position
        list.insertAtPosition(4, 25); // Position 4 (between 20 and 30)
        list.display();

        // Delete at specific position
        list.deleteAtPosition(4); // Deletes 25
        list.display();

        // Delete from beginning
        list.deleteFromBeginning();
        list.display();

        // Delete from end
        list.deleteFromEnd();
        list.display();
    }
}
