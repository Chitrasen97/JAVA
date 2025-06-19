import java.util.LinkedList;

public class SimpleStack {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<>();

        // Insert 3 numbers at beginning
        stack.addFirst(10);
        stack.addFirst(20);
        stack.addFirst(30);

        // Insert 3 numbers at end
        stack.addLast(40);
        stack.addLast(50);
        stack.addLast(60);

        // Display current stack
        System.out.println("Stack after inserting at beginning and end: " + stack);

        // Insert at specific position (index 2)
        stack.add(2, 25);
        System.out.println("After inserting 25 at position 2: " + stack);

        // Delete at specific position (index 3)
        stack.remove(3);
        System.out.println("After deleting element at position 3: " + stack);

        // Delete from end
        stack.removeLast();
        System.out.println("After deleting from end: " + stack);

        // Delete from beginning
        stack.removeFirst();
        System.out.println("After deleting from beginning: " + stack);
    }
}
