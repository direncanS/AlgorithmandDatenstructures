public class BinarySearchTree {

    // ROOT MUST BE PUBLIC FOR CODE IN MAIN METHOD TO WORK
    public Node root;

    class Node {
        public int value;
        public Node left;
        public Node right;

        Node(int value) {
            this.value = value;
        }
    }

    // WRITE INSERT METHOD HERE //
    /*
    Insert icin dikkat edilmesi gereken birkac durum var:
    1-Ilk olarak eger tree'de hic eleman yoksa bizim root(head) direkt olarak yeni eklenen node isaret etmeli
    2-Tree'de gezinmek icin bir temp pointer olusturmaliyiz. Gezinmek icin döngüye ihtiyac var
    3-Eger hali hazirda tree'de olan bir eleman varsa döngüye sonlandirmaliyiz, cünkü var olan deger ekleyemeyiz.
     */
    public boolean insert(int value){
        //Ilk olarak yeni bir node olusturalim.
        Node newNode = new Node(value);
        //Eger tree'de hic eleman yoksa direkt olusturulan newNode bizim ilk eleman olmali.
        if (root==null){
            root=newNode;
            return true;
        }
        //Eger ki tree de eleman varsa eleman tek tek gezip uygun yere yerlestirmeliyiz bunun icin temp pointer yaratalim ve tree'deki root elemana estielyelim
        Node temp = root;
        //Tree'de kac elemani gezecegimiz belli olmadigi icin while elemani olusturalim.
        while(true){
            //Eger tree de zaten bu deger varsa fonksiyonu sonlandiriyoruz.
            if (temp.value==newNode.value){
                return false;
            }
            //Eger ilk elemanin degeri (bu durumda temp), olusturulan node'un degerinden büyükse sola dogru gitmeliyiz, kücükse saga dogru gitmeliyiz.
            //Ilk if durumunda temp.value büyük diyelim bu sebeple left gidecegiz.
            if (temp.value > newNode.value){
                /*
                Insert etmek icin iki duruma dikkat edecegiz.
                1-Ilk kontrolden sonra left'te eleman yoksa direkt yerlestirme durumu
                2-leftte eleman varsa iterator olan temp sola dogru ilerletip orada karsilastirma yapmaliyiz.
                 */
                //Eger solda eleman yoksa direkt yerlestirip true döndürüyoruz.
                if (temp.left==null){
                    temp.left=newNode;
                    return true;
                }
                //left eleman varsa bir sonraki node'a ilerletip kontrol etme islemini loop icinde oldugumuz icin devam edecegiz.
                temp=temp.left;
                //Ayni islemi rigt durumu icinde yapmis oluyoruz.
            }else{

                if (temp.right==null){
                    temp.right=newNode;
                    return true;
                }
                temp=temp.right;
            }
        }
    }

}