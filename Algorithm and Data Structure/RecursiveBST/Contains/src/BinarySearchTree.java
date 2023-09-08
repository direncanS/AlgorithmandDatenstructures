public class BinarySearchTree {

    private Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }

    // WRITE THE RECURSIVE CONTAINS METHOD HERE //
    /*
    Treesearch algoritmasinda 3 durumu kontrol etmek lazim
    1-Eger tree bos ise direkt false döndürmeli
    2-Root'a göre node ve value karsilastirilmali ve left mi right mi gidecegine karar vermeli
    Burada recursive bir metot olusturacagimiz icin öncelikle loop gibi düsünerek cikis sartimizi belirlemel lazim
    Cikis sartimiz eger üzerinde bulundugumuz node'un value'su aradigimiza esitse true döndürmeli, degilse devam etmeliyiz.
     */
    private boolean rContains(Node currentNode, int value){
        //Burdaki currentNode aslinda root yani ilk degeri temsil ediyor.
        if (currentNode==null) return false;
        //Simdi recursive metottan cikis sartimizi yazalim.Aradigimiz degeri bulduysak true döndür
        if (currentNode.value==value) return true;
        //Simdi root'un degeri aradigimiz value degeriyle karsilastiriliacak büyük ise left kücük ise rigt gidecek.
        if(currentNode.value>value){
           return rContains(currentNode.left,value);
        }else{
            return rContains(currentNode.right,value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

}
