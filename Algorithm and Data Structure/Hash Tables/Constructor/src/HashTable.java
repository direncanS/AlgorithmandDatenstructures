public class HashTable {
    //Öncelikle hashtable olusturalim.
    //size hashtable boyutu datamap ise her bir slot/depoyu temsil ediyor.
    private int size=7;
    private Node[] dataMap;
    //hashtable icinde tutabilecegimiz node(bir bakima linked list) temsil ediyor
    class Node{
        //hashtable da key-value pair vardir. Next ise seperate chaning kullanacagimiz icin ekledik
        //Yani bir slotta birden fazla node olabilir. Bunlari da linked list seklinde tutacagiz.
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value){
            this.key=key;
            this.value=value;
        }
    }
    //Burada hashtable olusturmus oluyoruz. Olusturdugumuz sey bir Node sinif türünde bir array ve size ise boyutu.
    public HashTable(){
        dataMap= new Node[size];
    }



    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if(dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

}
