import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class BinarySearchTree {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
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

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    // WRITE DFS_PREORDER METHOD HERE //
    /*
    Önce soldaki degerleri yazdirmak esastir.
     */
    public ArrayList<Integer> DFSPreOrder(){
        //BFS'den farki recursive bir metot yazmamiz gerekiyor. Java da metot icinde metot yazma olmadigi icin inner class olusturacagiz.
        //Öncelikle sonuclari icine aktaracagimiz bir result adindan integer bir arraylist tanimlayalim
        ArrayList<Integer> result= new ArrayList<>();
        Node currentNode = root;
        class Traverse{
            public Traverse(Node currentNode){
                //Öncelikle bize gönderilen node degerini arraylistimize ekledikten sonra sol'unda node var mi bakiyoruz
                result.add(currentNode.value);
                if (currentNode.left != null){
                    //Eger solunda node varsa inner class'i recursive metot gibi kullandigimizdan constructor yapisini obje olusturuyormusuz gibi yeniden cagiriyoruz.
                    //Bu islem solunda herhangi bir eleman kalmayana kadar kendi kendini cagirmaya devam edecek.
                    new Traverse(currentNode.left);
                }
                //Solunki elemanlar bittikten sonra bu sefer sagindaki degerleri yazdirmaya vasliyoruz.
                if (currentNode.right != null){
                    new Traverse(currentNode.right);
                }
            }
        }//Burada new sözügü ile cagirmamizin sebebi innerclass yapisini kullandik ve constructor kullanmak icin obje olusturmamiz gerekiyor. Bu sefer new sözcügü ile obje olusturuyoruz.
        new Traverse(currentNode);
        return result;
    }

}