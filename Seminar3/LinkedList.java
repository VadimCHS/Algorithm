package Seminar3;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        size = 0;
        head = null;
    }

    public int getSize() {
        return size;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node currentNode = head;

        for (int i = 0; i < index; i++)
            currentNode = currentNode.nextNode;

        return currentNode;
    }

    public int getValue(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node currentNode = head;

        for (int i = 0; i < index; i++)
            currentNode = currentNode.nextNode;

        return currentNode.value;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            size = 1;
            return;
        }
        Node currentNode = head;
        while (currentNode.nextNode != null)
            currentNode = currentNode.nextNode;
        currentNode.nextNode = newNode;
        size++;
    }

    public void reverse() {
        if (head == null)
            return;
        Node currentNode = head;
        Node previousNode = null;
        while (currentNode != null) {
            Node temp = currentNode.nextNode;
            currentNode.nextNode = previousNode;
            previousNode = currentNode;
            currentNode = temp;
        }
        this.head = previousNode;
    }

    public void sort() {
        this.sort(0, size - 1);
    }

    private void sort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = this.getValue((leftMarker + rightMarker) / 2);
        
        do {
            while (this.getValue(leftMarker) < pivot) 
                leftMarker++;
            while (this.getValue(rightMarker) > pivot)
                rightMarker--;
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker)
                    swap(leftMarker, rightMarker);
                leftMarker++;
                rightMarker--;
            }
            
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder)
            sort(leftMarker, rightBorder);
        if (leftBorder < rightMarker)
            sort(leftBorder, rightMarker);
    }
    
    private void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size)
            return;
        if (index2 < 0 || index2 >= size)
            return;

        Node node1 = this.getNode(index1);
        Node node2 = this.getNode(index2);
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    public int find(int value) {
        if (head == null)
            return -1;

        Node currentNode = head;
        for (int i = 0; currentNode != null; i++, currentNode = currentNode.nextNode) {
            if (currentNode.value == value)
                return i;
        }
        return -1;
    }

    public boolean remove(int value) {
        if (remove(value, head) == null)
            return false;
        else
            return true;
    }

    public Node remove(int value, Node startNode) {
        if (head == null)
            return null;

        Node currentNode = head;

        if (currentNode.value == value) {
            head = head.nextNode;
            size--;
            return head;
        }

        while (currentNode.nextNode != null) {
            if (currentNode.nextNode.value == value) {
                currentNode.nextNode = currentNode.nextNode.nextNode;
                size--;
                return currentNode.nextNode;
            }
            currentNode = currentNode.nextNode;
        }

        return null;
    }

    public int removeAll(int value) {
        if (head == null)
            return 0;

        Node currentNode = remove(value, head);
        int k = 1;
        while (currentNode != null) {
            currentNode = remove(value, currentNode);
            k++;
        }
        return k;
    }

    public boolean removeAt(int index) {

        if (head == null || index >= size)
            return false;

        if (index == 0) {
            head = head.nextNode;
            size--;
            return true;
        }

        Node currentNode = this.getNode(index);
        currentNode.nextNode = currentNode.nextNode.nextNode;
        size--;
        return true;
    }

    public void print() {
        Node currentNode = head;
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.nextNode;
        }
        System.out.println("]");
    }

    private class Node {
        private int value;
        private Node nextNode;

        Node() {
            nextNode = null;
        }

        Node(int _value) {
            this.value = _value;
        }

        Node(int _value, Node _nexNode) {
            this.value = _value;
            this.nextNode = _nexNode;
        }
    }
}
