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


    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }
    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }


    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    // WRITE THE DELETENODE METHOD HERE //
    /*
    BST'de bir eleman silmek icin dikkat edilmesi gereken 4 durum var.
    Ilk olarak eleman tree'de var mi, varsa solda mi sagda mi olduguna bakacagiz. Daha sonra silmek icin;
    1-Silecegimiz eleman leaf node mu diye kontrol etmeliyiz.
    2-Silecegimiz elemanin sadece solunda mi eleman var kontrol etmeliyiz.
    3-Silecegimiz elemanin sadece saginda mi eleman var kontrol etmeliyiz.
    4-Silecegimiz elemanin hem sag hem de solinda eleman var mi kontrol edecegiz. Eger varsa yapmamiz gereken
    subtree'deki en kücük elemani bulup silecegimiz eleman ile value'sunu yer degistirmesini saglamak.
     */
    private Node deleteNode(Node currentNode, int value){
        //Silmek istedigimiz eleman tree'de var mi yok mu varsa saga mi gidecegiz sola mi onu anlayalim
        if (currentNode==null){
            return null;
        }
        if (currentNode.value>value){
            currentNode.left= deleteNode(currentNode.left,value);
        }
        else if(currentNode.value<value) {
            currentNode.right = deleteNode(currentNode.right, value);
        //Silinecek eleman sagda mi solda mi karar verdik simdi silecegimiz elemanin yapraklari var mi yoksa kendisi bir leafnode mu durumunu kontrol etmelyiz.
        }else{
            //Silecegimiz eleman leaf Node ise
            if (currentNode.left==null && currentNode.right==null){
                return null;
            }//Silecegimiz elemanin sadece solda eleman varsa
            else if (currentNode.left==null) {
                currentNode=currentNode.right;
            }//Silecegimiz elemanin sadece saginda eleman varsa
            else if (currentNode.right==null) {
               currentNode=currentNode.left;
            }//Silecegimiz elemanin hem saginda hem solunda eleman varsa
            else{
                //Öncelikle silecegimiz elemana ait subtree'deki min degeri bulacagiz
                int subTreeMin=minValue(currentNode.right);
                //Buldugumuz min deger ile silecegimiz elemanin degerini degistirecegiz/esitleyecegiz
                currentNode.value=subTreeMin;
                currentNode.right=deleteNode(currentNode.right,subTreeMin);
            }
        }
        return currentNode;
    }
    public void deleteNode(int value) {
        deleteNode(root, value);
    }

}