package Seminar3;
import java.util.Random;

public class Test {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // list.add(5);
        // list.add(2);
        // list.add(7);
        // list.add(2);
        // list.add(4);
        // list.add(2);
        // list.add(2);
        // list.add(4);
        // list.add(5);

        for (int i = 0; i < 10; i++) {
            list.add(new Random().nextInt(20));
        }
        list.print();
        list.reverse();
        list.print();





        // int a = list.removeAll(2);
        // list.removeAt(0);
        // list.print();
        // System.out.println(a);
        // if(list.remove(7)) {
        //     list.print();
        // }

        

    }

    

    // private Node head;
    // private Node tail;



    // public Node findNode(int value) {
    //     Node node = head;
    //     while (node.nextNode != null) {
    //         node = node.nextNode;
    //         if (node.value == value) {
    //             return node;                
    //         }            
    //     }
    //     return null;
    // }

    // class Node {
    //     private int value;
    //     private Node nextNode;
    //     private Node rpeviousNode;
    // }
}