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

    ///  WRITE SET METHOD HERE  ///
    //Bu metotta yaptigimiz her index'e node eklemek. Node ise key,value ve next pointerindan olusuyordu
    public void set(String key,int value){
        int index=hash(key);//Ilk olarak hangi index'e yerlestirecegimizi hash metodu ile ögreniyoruz.
        Node newNode = new Node(key, value);//Ekleyecegimiz node olusturduk
        //Eger hashtable'da index bossa direkt olarak o index'e newNode ekleyebiliriz.
        if (dataMap[index]==null){
            /*
Java'da, bir nesnenin başka bir nesneye atanması demek, o nesnenin referansının (yani o nesneyi işaret eden "adresin") kopyalanması anlamına gelir.
Bu durumu, bir kişinin adresini başka birine vermek gibi düşünebiliriz.
Örneğin, `newNode=dataMap[index];` dediğimizde, `newNode` artık `dataMap[index]`in adresini (yani işaret ettiği yeri) işaret ediyor.
Bu durumda, `newNode`'un daha önce işaret ettiği adresi kaybederiz çünkü `newNode` şimdi başka bir adresi işaret ediyor.
Dolayısıyla `newNode=dataMap[index];` dediğimizde, `newNode`'un daha önce oluşturduğumuz yeni Node'un adresini unutup `dataMap[index]`in işaret ettiği yeri işaret etmesini sağlıyoruz.
Bu yüzden yeni Node kayboluyor, çünkü onu işaret eden bir referansımız (adresimiz) kalmıyor.
Ancak `dataMap[index] = newNode;` dediğimizde, `dataMap[index]`'in işaret ettiği adresi değiştirip onu `newNode`'un işaret ettiği yere yönlendiriyoruz.
Yani `dataMap[index]` şimdi yeni Node'u işaret ediyor.
Bu şekilde, `newNode`'un işaret ettiği yeni Node'u kaybetmiş olmuyoruz; sadece `dataMap[index]`'in işaret ettiği yeri değiştiriyoruz.
             */
            dataMap[index]=newNode;//datamap[index] bir Node pointeri(array) oldugu icin böyle yaptigimizda aslinda o slota yerlestirdigimiz anlamina geliyor
        }
        //Eger slot bos degil ve eleman varsa linkedlist deki gibi bir loop icinde iterator ile ilerlememiz ve bos olan yeri bulmamiz gerekiyor
        else{
            Node temp=dataMap[index];//Head'i temp'e esitledik gibi düsünebilirsin
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;//Bos olan yeri bulduk. Artik onun newNode'u isaret etmesini istiyoruz.
        }
    }
}