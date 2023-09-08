public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // WRITE REMOVELAST METHOD HERE //
    /*
    Sondaki elemani cikarmak icin 3 durumu göz önüne almak lazim
    1-hic eleman olmamasi durumu
    2-bir tane eleman olma durumu
    3-listede bircok eleman olmasi
    */
    public Node removeLast(){
        //1.durum icin yani hic eleman yoksa
        if (length==0) return null;
        //3.durum icin yani listede bir cok eleman varsa
        //temp ve pre pointerlari ile listede gezinecegiz.
        //pre pointeri bize sonradan tail pointerini yeniden konumlandirmamizi saglayacak
        //temp pointeri ise listeden cikardigimiz pointerin bilgilerini tutmamizi saglayacak.ayni zamanda döngü sartimiz olacak
        Node temp=head;
        Node pre=head;
        while(temp.next != null){
            //pre temp ile ayn noktayi göstersin, ondan sonra temp bir sonraki noktaya gitsin, ta ki null olana kadar.
            pre=temp;
            temp=temp.next;
        }
        tail=pre;
        //tail.next'i null olarak esitlemeliyiz ki daha fazla son node'i isaret etmesin. Cikarma islemi böylece yapilmis olunuyor.
        tail.next=null;
        //linkedlist elemanini bir azaltmayi unutmuyoruz.
        length--;
        //2.durum icin, eger bir eleman cikardiktan sonra listede eleman yoksa head ve tail null olmali.
        //2.durum icin yani tek elemanli listede cikarma islemi de böyle yapilir.
        if (length==0){
            head=null;
            tail=null;
        }
        return temp;//listeden cikan elemani döndürmüs oluyoruz.
    }
}