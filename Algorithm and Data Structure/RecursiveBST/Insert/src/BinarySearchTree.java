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


    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }
    public boolean rContains(int value) { return rContains(root, value); }


    // WRITE THE RECURSIVE INSERT METHOD HERE //
    /*
    Tree'ye bir node eklemek icin öncelikle tree bossa onu kontrol etmeliyiz. Yalniz suan recursive metot
    yazdigimiz icin bunu recusrvice metot disinda yapmaliyiz cünkü böylece bir defa kontrol etmis oluruz
    Cikis sartimiz ne olmali onu düsünmeliyiz. Eger sayi left'e eklenecekse onu kontrol etmeliyiz
    right eklenecekse öyle bir kontrol saglamalyiz.
     */
    private Node rInsert(Node currentNode,int value){
        //Base case yani recursive metottan cikma sartimiz artik eklenecek bir nokta bulmayla gerceklesecek
        //Buldugumuz zaman yeni bir node olusturup onu geri döndürebiliriz
        //Bu noktadan sonra recursive metot root'a kadar kendini geri cagiracak ve en son olarak root degerini döndürecek
        //lakin public metodumuz herhangi bir deger döndürmediginden root degeri geri döndürdügümüzde aslinda bir sey yapmamis oluyor.
         if (currentNode==null){
             return new Node(value);
         }
         if (currentNode.value>value){
             //currentNode.left yazmamizin sebebi ekledigimiz noktadan root'a kadar bir yol belirlenmesi.
             currentNode.left= rInsert(currentNode.left,value);
         }else{
             //currentNode.right yazmamizin sebebi ekledigimiz noktadan root'a kadar bir yol belirlenmesi.

             currentNode.right= rInsert(currentNode.right,value);
         }
         return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

}

