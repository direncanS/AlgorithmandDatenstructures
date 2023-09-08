import java.util.ArrayList;
import java.util.HashMap;


public class Graph {

    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    public boolean addVertex(String vertex) {
        if (adjList.get(vertex) == null) {
            adjList.put(vertex, new ArrayList<String>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).add(vertex2);
            adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if (adjList.get(vertex1) != null && adjList.get(vertex2) != null) {
            adjList.get(vertex1).remove(vertex2);
            adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    // WRITE REMOVEVERTEX METHOD HERE //
    /*
    Bir vertex kaldirmak icin önce bagli oldugu edgeleri kaldirmaliyiz daha sonra vertexi kaldirmaliyiz
    Olusturdugumuz graph bidirectional oldugu icin tüm arraylist'i dolasmamiza gerek yok sadece
    kaldirmak istedigimiz vertex'in oldgu arraylisti bulup icindeki edge'lere odaklanmaliyiz.

     */
    public boolean removeVertex(String vertex){
        //Ilk olarak kaldirmak istedigimiz vertex graph'da var mi yok mu ona bakacagiz.
        //Eger yoksa false olarak döndürecegiz.
        if (adjList.get(vertex) == null) return false;
        /*
        Eger vertex varsa yapmamiz gereken tuttugu arraylist icindeki edge'lere ulasmak daha sonra onlarin
        icinde edge olarak bulundurdugu kaldirmak istedigimiz vertex' arayip kaldirmaliyiz.
        */
        //Bunun icin for-each döngüsünü kullaniyoruz
        //adjList.get(vertex) bize hangi arraylistin(kaldirmak istedigimiz vertex) key degerinin icindeki arraylistte dolanmamizi saglayacak
        for (String otherVertex :  adjList.get(vertex)){
            //adjList.get(otherVertex) bize yeni bir arraylist verir.key-value pair gibi düsünürsen
            // key degerini verir ve remove(vertex) diyerek o keyin tuttugu arraylist icine girip kaldirmak
            // istedigimiz vertex degeri(bu durumda edge) kaldirmis oluruz.
            adjList.get(otherVertex).remove(vertex);
        }
        //Kaldirmak istediimiz vertex'in array listindeki her arraylisti ziyaret ettik ve icinde bulunan edge yok ettik
        //Son olarak yok etmek istedigimiz vertex'i kaldiriyouz ve true döndürüyoruz.
        //False deger döndürmemize gerek yok. Efficient olarak finding the kex O(1) ama her edge dolasmamiz gerektigi icin removeVertex O(E) olarak gecer.
        adjList.remove(vertex);
        return true;
    }

}
