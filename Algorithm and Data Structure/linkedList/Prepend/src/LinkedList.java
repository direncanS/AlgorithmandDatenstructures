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

    // WRITE PREPEND METHOD HERE //
    //Listenin basina eleman ekleyecegiz bunun icin head eklenen elemani, eklenen elemanin pointerida head göstermeli
    //iki durum var. 1.si listede eleman olmama durumu, 2.si listede bir tanede ya da daha fazla eleman olma durumu
    public void prepend(int value){
        //Öncelikle eklenecek pointer olusturuyoruz.
        Node newNode= new Node(value);
        //Eger listede eleman yoksa head ve tail olusturulan pointer göstermeli
        if (length==0){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        //listeye eleman eklendigi icin bir arttirilmali
        length++;
    }

}