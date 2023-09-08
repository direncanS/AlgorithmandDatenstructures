public class BinarySearchTree {

    private Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
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

    // WRITE CONTAINS METHOD HERE //
    /*
    Tree'de arama icin dikkat etmemiz gereken durumlar:
    1-Tree'de hic eleman yoksa
    2-Aranan eleman tree'de degilse
     */
    public boolean contains(int value){
        //Eger tree'de hic eleman yoksa direkt false dönmeli.
        if (root==null) return false;
        //Loop'ta bizim icin gezinecek temp pointer elemani olusturup tree köküne esitliyoruz.
        Node temp=root;
        /*
        Elemanin tree icinde aranmasinda dikkat etmemiz gereken 3 senaryo var:
        1-elemanin left'te olmasi
        2-elemanin root'ta olmasi
        3-elemanin bulunma durumu
         */
        while (temp!=null){
            //eleman node'a göre kücükse sola dogru arama yapacagiz.
            if (temp.value>value){
                //temp elemanini sola dogru bir ilerletiyoruz
                temp=temp.left;
            // Ayni islemi rigt icin uyguluyoruz
            } else if (temp.value<value) {
                temp=temp.right;
            //Eger eleman varsa degerden ne büyük ne kücüktür bu sebeple else metoduna girer. Varsa true döndürmüs oluyoruz
            }else{
                 return true;
            }
        }
        //Eger döngüde herhangi bir eslesme olmadiysa false döndürerek elemanin treede olmadigini söylüyoruz.
        return false;
    }

}