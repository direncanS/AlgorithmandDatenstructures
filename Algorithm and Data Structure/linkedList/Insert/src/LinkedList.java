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

    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // WRITE INSERT METHOD HERE //
    public boolean insert(int index, int value){
        //Eger index 0'dan kücük veya liste boyutundan büyükse false döndürmeli.
        if(index<0 || index>length) return false;
        //Eger listeinin basina ekleyeceksek bunun icin zaten metot yazmistik.
        if (index==0){
            prepend(value);
            return true;
        }
        //Eger listeinin sonuna eleman ekleyeceksek bunun icin zaten metot yazmistik
        if (index==length){
            append(value);
            return true;
        }
        //Bizi ilgilendiren asil listeinin ortasine eleman ekleyeceksek ne olacagi olmali
        Node newNode = new Node(value);
        //get metodu ile eklenecek index'in 1 eksigi yere kadar ilerliyoruz. Ondan sonrasi kolay
        Node temp = get(index-1);
        //Önce temp.next ile newNode.next ayni yeri isaret etmesini sagliyoruz. Cünkü aralarina ekleyecegiz.
        newNode.next=temp.next;
        //Daha sonra yapmamiz gereken sey; temp.next'i newNode'u isaret etmesini saglamak.
        temp.next=newNode;
        //listeye yeni bir eleman geldigi icin listenin sayisini bir arttirmayi unutmuyoruz.
        length++;
        return true;

    }

}