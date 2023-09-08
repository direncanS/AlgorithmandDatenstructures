public class BinarySearchTree {
    //BST class'da sadece root olsa yeterli. Bu root bize linked listteki head yardimini yapiyor.
    //constructor olusturmadik cünkü insert metodu ile node eklemeye karar verdik.
    Node root;

    //Binary search tree'de bir node right ve left olarak iki yeri point ediyor bir de value degeri oluyor
    //Bu sebeple inner class NOde'da bask bir sinif variable eklemeye gerek yok.
    class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
        }
    }

}
