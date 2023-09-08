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

    public boolean insert(int index, int value)  {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    // WRITE REVERSE METHOD HERE //
    public void reverse(){
        /*
        Öncelikle head ve tail'in yerlerini degistirmeliyiz.
        head ve tail yer degistirmek icin temp node olusturup head'e esitleyecegiz. Daha sonra head tail'e, tail ise temp'e esitleyecegiz
        Böylece head ve tail yer degistirmis olacak.
        */
        Node temp=head;
        head=tail;
        tail=temp;
        /*
        Simdi ikinci kisma gecebiliriz. Yapmamiz gereken her node'i loop yardimiyla ters cevirmek.
        Bunun icin bize 2 tane daha pointer lazim. Bir tanesi before, bir tanesi after olabilir.
        Bu iki+temp pointer ile her node üzerinden tek tek gecip oklari tersine cevirme islemi yapacagiz.
        Kafanda bir yuvarla node ve onun oku olarak düsün ve bunun ters cevrildigini diger yönü gösterdigini hayal et.
         */
        Node after=temp.next;
        Node before=null;

        for (int i=0; i<length;i++){
            /*Baslangicta zaten after'i temp.next'e esitlemistik.
            Yeniden yazmamizin sebebi her döngünün baslangicinda after'i bir kaydirmak.
            */
            after=temp.next;
            /*
            Before baslangicta null gösteriyordu. Temp.next ile artik ilk ok tersine döndü ve o null gösteriyor olacak
            Bu metot sayesinde her seferinde ok tersine dönecek
             */
            temp.next=before;
            //Before pointer'i artik temp'i yani bir sonraki aimi göstererek kaydirmis oluyoruz.
            before=temp;
            //temp after'a esitleyerek temp pointerida bir kaydirdik.
            temp=after;

        }
    }

}
