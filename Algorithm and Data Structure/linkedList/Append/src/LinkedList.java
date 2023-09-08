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

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    // WRITE APPEND METHOD HERE //
    public void append(int value){
        //Iki durum var ya linkedlist bos ve ilk eleman ekleniyor, ya da linkedlist bos degil ve sona eleman ekleniyor
        Node newNode = new Node(value);
       //Eger linkedlist eleman yoksa head ve tail appendnode'u isaret edecek.
        if (head==null){
            head=newNode;
            tail=newNode;
        }
        //Eger linkedlist zaten eleman varsa sadece tail'in nexti  yeni node'u isaret etmeli.
        //Ondan sonra tail'i bir kaydirmali, yeni node'u isaret etmesini saglamaliyiz..
        else{
            tail.next=newNode;
            tail=newNode;

        }
        //Her halükarda length bir arttirmaliyiz böylece linkedlist eleman ekleidigmizi göstermis oluruz.
        //makeEmpty metodu ile bosken de dogru calisiyormu kontrol ettigimiz icin bunu yapiyoruz.
        length++;
    }
}
