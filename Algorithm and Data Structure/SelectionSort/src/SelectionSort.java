import java.util.Arrays;

public class SelectionSort {

    // WRITE SELECTIONSORT METHOD HERE //
    public static void selectionSort(int[] array){
//selection sortta indexlerdeki degerleri karsilastiriyoruz ve buldugumuz en kücük degerin index ile basladigimiz indexi yer degistiriyoruz.
        for (int i = 0; i < array.length ; i++) {
            //Baslangicta minIndex'e bir deger veriyoruz. Ilk adimda bu aslinda 0 oluyor.
            int minIndex=i;
            for (int j = i+1; j < array.length ; j++) {
                //Ilk adim icin 0.indexteki(ilk atamada i=0 ama daha 1,2.. olacak) sayi j'deki sayidan büyükse en kücük sayimizin indexi artik j olacak
                //Kodu yazarken karsilastirmay array[i] olarak yaptim ama bu hataliydi. minIndex'teki sayi ile karsilastirma yapmam gerekiyor.
                if (array[j]<array[minIndex]) {
                    minIndex=j;
                }
            }
            if (i != minIndex){
                int temp=array[i];
                array[i] = array[minIndex];
                array[minIndex]=temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] myArray = {4,2,6,5,1,3};

        selectionSort(myArray);

        System.out.println( Arrays.toString(myArray) );

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6]

         */

    }
}
