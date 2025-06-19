// Node class for the queue
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue class with all operations
public class CustomQueue {
    Node head = null;  
    Node tail = null;  

    // Insert at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Insert at a specific position (1-based)
    void insertAtPosition(int position, int data) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Node newNode = new Node(data);

        if (position == 1) {
            insertAtBeginning(data);
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

        if (newNode.next == null) {
            tail = newNode; // update tail if inserted at end
        }
    }

    // Delete from beginning
    void deleteFromBeginning() {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }
        head = head.next;
        if (head == null) tail = null;
    }

    // Delete from end
    void deleteFromEnd() {
        if (head == null) {
            System.out.println("Queue is empty");
            return;
        }

        if (head.next == null) {
            head = tail = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
    }

    // Delete at specific position (1-based)
    void deleteAtPosition(int position) {
        if (position < 1 || head == null) {
            System.out.println("Invalid position or queue is empty");
            return;
        }

        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Position out of range");
            return;
        }

        if (temp.next == tail) {
            tail = temp;
        }

        temp.next = temp.next.next;
    }

    // Display queue
    void displayQueue() {
        Node temp = head;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        CustomQueue queue = new CustomQueue();

        // Insert at beginning
        queue.insertAtBeginning(10);
        queue.insertAtBeginning(20);
        queue.insertAtBeginning(30);

        // Insert at end
        queue.insertAtEnd(40);
        queue.insertAtEnd(50);
        queue.insertAtEnd(60);

        queue.displayQueue();

        // Insert at position
        queue.insertAtPosition(4, 99);  
        queue.displayQueue(); 
        // Delete at position
        queue.deleteAtPosition(4); 
        queue.displayQueue(); 

        // Delete from beginning
        queue.deleteFromBeginning();
        queue.displayQueue(); 
        // Delete from end
        queue.deleteFromEnd();
        queue.displayQueue(); 
    }
}
