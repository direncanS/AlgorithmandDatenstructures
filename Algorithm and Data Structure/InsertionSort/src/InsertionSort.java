import java.util.Arrays;

public class InsertionSort {

    // WRITE INSERTIONSORT METHOD HERE //
    public static void insertionSort(int[] array){
        //insertion sort her zaman 2.item ile baslar(array mantigina göre1. indexten)Sonra ondan önceki item ile karsilastirir
        //Deger kücük ise yer degistirir
        //int i=1 olmasinin sebebi de buzr. 1.indexen baslayip karsilastirma yapmaliyiz.
        for (int i = 1; i < array.length; i++) {
            int temp=array[i];
            int j=i-1;
            //Bu algoritmada dikkat edilmesi gerekekn nokta eger 1.inde ile 0.index yer degistirirsek j-1 durumundan -1 degerini olur
            //Bu sebeple while döngüsüne j>=1 sartini ekledik. Bunu da ilk olarak yazmaliyiz yoksa yine hata aliriz.
            /*
            Burada, array[i] = array[j]; ifadesi array[i]'nin değerini array[j]'nin değeriyle değiştirir.
            Ancak while döngüsünde, array[i] < array[j] karşılaştırmasını yapıyorsunuz.
            Dolayısıyla, array[i]'nin değerini değiştirdikten sonra karşılaştırmayı sürdürürseniz, aslında ilk başta array[i]'nin hangi değeri olduğunu "unutmuş" olursunuz.
            Bu yüzden array[i] ile karşılaştırma yapmak hatalı sonuçlara yol açar.
            Bunun yerine, array[i]'nin başlangıç değerini temp değişkenine kaydettiğiniz ve sonra temp'i array[j] ile karşılaştırdığınız doğru algoritmayı kullanmalısınız.
            Böylece, array[i]'nin orijinal değerini kaybetmeden karşılaştırmayı sürdürebilir ve yerleştirme işlemi tamamlandığında temp'i doğru yere yerleştirebilirsiniz.
             */
            while (j> -1 && temp<array[j]){
                array[j+1]=array[j];
                array[j]=temp;
                j--;
            }
        }
    }



    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        insertionSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }

}
