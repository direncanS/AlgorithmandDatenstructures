public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        String key;
        int value;
        Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            if (temp.key == key) {
                temp.value += value;
                return;
            }
            while (temp.next != null) {
                temp = temp.next;
                if (temp.key == key) {
                    temp.value += value;
                    return;
                }
            }
            temp.next = newNode;
        }
    }

    ///  WRITE GET METHOD HERE  ///
    /*
    Seperate chaning yaptigimiz icin bir indexte birden fazla node olabilir bunlari da linkedlist seklinde ekledik
    Bu sebeple göz önüne alacagimiz iki durum var.
    1-Öncelikle hash metodu ile istenilen key'in index degerini bulacagiz.
    2-Daha sonra bu indexte böyle bir eleman var mi yok mu loop döngüsü ile arayacagiz.
    3-Eleman varsa value degerini yoksa 0 döndürecegiz.
     */
    public int get(String key){
        int index=hash(key);
        Node temp=dataMap[index];//Hash table'in ilk elemani olacak sekilde atadik.
        while (temp!=null){
            if (temp.key==key){
                return temp.value;
            }
            temp=temp.next;
        }
        //Eger döngüde value dönmemisse bulamadik demektir. Bu sebeple 0 döndürüyoruz.
        return 0;
    }

}