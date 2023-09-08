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

    //// WRITE BFS METHOD HERE ////
    /*
    Öncelikle node degerlerini Queue icinde depolayacaginiz. Sonra queue icndeki node alip onun degerini bir arraylist icine aktaracagiz
    Bu isleimi tüm nodelari queue icine alip degerini arrayliste tekrarlayincaya kadar, yani queue bos olana kadar tekrarlayacagiz
    Bunu satir satir degerlerin okunmasi olarak gözünd canlandirabilirsin.
     */
    public ArrayList<Integer> BFS(){
        Node currentNode=root;//Bizim agactaki kökümüzü tutacak bir node tanimlayalim.
        //Öncelikle tree'deki her dügümü depolayacagimiz queue olusturalim
        Queue<Node> queue = new LinkedList<>();
        //ikinci olarak node'un degerlerini tutacagimiz int bir result arraylist tanimlayalim
        ArrayList<Integer> result =new ArrayList<>();
        queue.add(currentNode);//Basta eklememizin sebebi while döngüsüne girmesini saglamak
        //While döngümüz'de yapilacak sey queue size 0 dan büyük olana kadar devam etmesi
        while (queue.size()>0){
            currentNode=queue.remove();//Bu queue den kaldirdigimiz node'u olusturdugumuz node'a atiyoruz.
            //Bu node'un degerini olusturdugumuz arrayList icine ekliyoruz.
            result.add(currentNode.value);
            //Simdi bu node'un left ve right'inda bir node var mi kontrol edecegiz.
            if (currentNode.left != null){
                //Eger bu node'un solunda eleman varsa o zaman o elemani da queue ekliyoruz.
                queue.add(currentNode.left);
            }if (currentNode.right !=null){
                //Eger bu node'un saginda eleman varsa onu da queue ekliyoruz.
                queue.add(currentNode.right);
            }
        }
        //En sonunda arraylistimizi döndürüyoruz.
        return result;
    }

}