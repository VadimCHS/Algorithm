package Seminar4;

public class main {
    public static void main(String[] args) {
        BinTree<Integer> tree = new BinTree<>();
        tree.add(6);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(4);
        tree.add(3);        
        tree.add(5);

        tree.print();
    }
}
