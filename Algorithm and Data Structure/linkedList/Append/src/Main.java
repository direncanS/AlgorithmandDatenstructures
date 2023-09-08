public class Main {
    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.makeEmpty();
        myLinkedList.append(1);
        myLinkedList.append(2);


        myLinkedList.printAll();


        /*
       		EXPECTED OUTPUT:
        	----------------
        	Head: 1
        	Tail: 2
        	Length: 2

        	Linked List:
        	1
        	2

     	*/

    }

}


/*
//Bu yazdigim append metodunda iki hata var. Bunu yarin bakarak cöz.
public void append(int value){
        //Iki durum var ya linkedlist bos ve ilk eleman ekleniyor, ya da linkedlist bos degil ve sona eleman ekleniyor
        Node appendNode = new Node(value);
        Node temp=head;
        if (temp==null){
            head=appendNode;
            tail=appendNode;
        }
        while (temp.next!=null){
            temp=temp.next;
        }
        appendNode=temp.next;
        tail=appendNode;
    }
 */