public class LinkedList {
    // CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    //head ve tail olusturacagimiz Node objesinin pointeri/referansi olacak.
    private Node head;
    private Node tail;
    private int length;//LinkedList kac eleman var onu bize söyleyecek


    //Node class her seferinde data yapisi olusturmamizi engelliyor. Bundan sonra bir durum oldugunda
    //Sadece node class'dan bir obje olusturmamiz yeterli.
    class Node{
        int value;
        Node next;
         public Node(int value){
             this.value=value;
         }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);//Her linkedList objesi olustugunda newNode referansi oluscak
        head=newNode;//Head ve tail pointerlari newNode ile ayni yeri referans gösterecek.
        tail=newNode;
        length=1;//Linkedlist eleman olustugundan boyunu bir arttirmis oluyoruz.
    }

    //Bu metot sadece linkedList yazdirmamizi sagliyor
    public void printList() {
        //Gecici bir pointer olusturup linkedlist ilk elemanini isaret ediyoruz.
        Node temp = head;
        while (temp != null) {
            //temp null isaret edene kadar döngüde dolaniyoruz.
            System.out.println(temp.value);
            //Temp pointer bir sonraki elemani isaret et demek.
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

}
