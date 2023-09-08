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

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // WRITE REMOVEFIRST METHOD HERE //
    /*
    Dikkat edilmesi gereken 3 durum var:
    1-Listede hic eleman olmama durumu
    2-listede sadece 1 eleman olma durumu
    3-Listede bircok eleman olma durumu.
     */
    public Node removeFirst(){
        //1.durum icin bunu yazmak yeterli. Direkt null döndürmeli.
        if (length==0) return null;
        //3.durum icin asagidaki islemler.
        //temp adli pointer olusturduk ve bu pointer head isaret ediyor yani adresini tutuyor..
        Node temp=head;
        //Elemani cikarma islemi burada yapiliyor. head.next ile head artik bir sonraki kodu isaret ediyor.
        head=head.next;
        //temp.next artik null göstermeli.Böylece cikarma islemi tamamlanir
        temp.next=null;
        //listenin eleman sayisini bir azaltiyoruz.
        length--;
        //2.durum icin asagidaki islemler
        //Eger bir azaltma isleminden sonra kalan eleman baska yoksa tail null isaret etmeli.
        //head=null yapmaya gerek yok cünkü zaten listede bir eleman vara head=head.next, ile head null esitlenmis oluyor.
        if (length==0){
            tail=null;
        }
        //temp pointer döndürerek listeden cikardigimiz elemanin degerini göstermis oluyoruz.
        return temp;
    }

}