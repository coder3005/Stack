//palindrome Linked list

import java.util.Stack;

public class StackB {
    public static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) { //even odd cases
            slow = slow.next;
        }
        while (slow != null) {
            if (stack.isEmpty() || stack.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node('a');
        head.next = new Node('b');
        head.next.next = new Node('c');
        head.next.next.next = new Node('b');
        head.next.next.next.next = new Node('a');

        System.out.println("Is Palindrome: " + isPalindrome(head)); // Output: true
    }
}

/* another code of this 

//palindrome Linked list

import java.util.Stack;

public class StackB {
    public static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public static boolean isPalindrome(Node head) {
        Stack<Character> stack = new Stack<>();
        Node temp=head;
        while(temp!=null) {
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(stack.size()>0) {
            if(temp.data!=stack.pop()) {
                return false;
            }
            else {
                temp=temp.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node('a');
        head.next = new Node('b');
        head.next.next = new Node('c');
        head.next.next.next = new Node('b');
        head.next.next.next.next = new Node('a');

        System.out.println("Is Palindrome: " + isPalindrome(head)); // Output: true
    }
}
*/
