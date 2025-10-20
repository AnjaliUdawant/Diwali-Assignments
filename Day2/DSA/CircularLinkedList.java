class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    Node head = null;

    // a) Insert node at nth position
    void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        if (pos == 1) {
            Node temp = head;
            while (temp.next != head)
                temp = temp.next;
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // b) Delete node by value
    void deleteByValue(int key) {
        if (head == null) return;

        Node temp = head, prev = null;

        // if head node holds key
        if (temp.data == key) {
            Node last = head;
            while (last.next != head)
                last = last.next;

            if (head.next == head) {
                head = null;
                return;
            }
            last.next = head.next;
            head = head.next;
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.data != key);

        if (temp.data == key)
            prev.next = temp.next;
    }

    // c) Modify node
    void modifyNode(int oldData, int newData) {
        if (head == null) return;

        Node temp = head;
        do {
            if (temp.data == oldData) {
                temp.data = newData;
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }

    // d) Display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtPosition(10, 1);
        cll.insertAtPosition(20, 2);
        cll.insertAtPosition(30, 3);
        cll.display();

        cll.modifyNode(20, 25);
        cll.display();

        cll.deleteByValue(25);
        cll.display();
    }
}
