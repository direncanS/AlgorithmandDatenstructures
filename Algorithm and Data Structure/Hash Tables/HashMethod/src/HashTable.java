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

    // HASH METHOD MUST BE PUBLIC FOR CODE IN MAIN TO WORK
    //hash metot bize dataMap(yani hashTable yani array) icinde hangi index'e yerlestirecegimizi gösterir
    public int hash(String key){
        //Basta hash degerini 0 yaptik
        int hash=0;
        //Gelen her key degerini char'a cevirip bir array icine attik. Bunu ascii degerinde int bir deger almak icin yaptik
        char [] keyArray = key.toCharArray();
        for (int i = 0; i < keyArray.length; i++) {
            int asciiValue=keyArray[i];//Char array'i tek tek olasip her harfin int asci degerini verecek
            //asil hash metodu bu kodda calisiyor.
            //datamap.length mod alarak cikan index/hash degerin hep 0-6 arasinda olmasini sagliyoruz
            //23 tmamen bizim sectigimiz bir sayi herhangi bir asal sayi secebiliriz.
            hash=(hash+asciiValue*23)% dataMap.length;
        }
        return hash;
    }

}
