import java.util.ArrayList;
import java.util.HashMap;


public class Graph {
    //String burada key degerini temsil ediyor, key ise yine arraylist olarak bir string tutuyoruz.
    //Bunu bosken calistirdigimizda {   } olarak calismis olacak.
    //key->vertex , value->edge olarak adlandiriyoruz graph'larda
    private HashMap<String, ArrayList<String>> adjList = new HashMap<>();

    public void printGraph() {
        System.out.println(adjList);
    }

    // WRITE ADDVERTEX METHOD HERE //
    public boolean addVertex(String vertex){
        //Graphlarda/hashmapler'de vertex iki defa olamayacagi icin önce kontrol ediyouz.
          if (adjList.get(vertex)==null){
              //Eger null ise ekleme yapiyoruz. Yeni bir arraylist olusturuyoruz
              adjList.put(vertex,new ArrayList<String>());
              return true;
          }
          return false;
    }

}