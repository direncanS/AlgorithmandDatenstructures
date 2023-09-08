/*
Graph: Dies ist eine Klasse, die eine Struktur namens Graph (Graf) darstellt. Ein Graph besteht aus Knotenpunkten (in diesem Fall Städten), die durch Kanten (in diesem Fall Wege zwischen den Städten) verbunden sind.
vertices: Dies ist eine Map (Karte), die eine Stadt und alle anderen Städte speichert, zu denen es eine direkte Verbindung gibt, zusammen mit dem Gewicht dieser Verbindung (in diesem Fall die Entfernung oder Kosten).
addEdge: Diese Methode fügt eine Verbindung zwischen zwei Städten hinzu. Sie nimmt drei Parameter: city1 und city2, die die Städte darstellen, und weight, das das Gewicht der Verbindung darstellt.
shortestPath: Diese Methode berechnet den kürzesten Pfad von der Startstadt zur Endstadt unter Verwendung des Dijkstra-Algorithmus. Sie gibt eine Map zurück, die für jede Stadt die kürzeste Entfernung zur Startstadt darstellt.
Node: Dies ist eine innere Klasse, die einen Knotenpunkt in dem Graph darstellt. Sie hat zwei Felder: city, das die Stadt darstellt, und distance, das die Entfernung zur Startstadt darstellt.
readGraphFromFile: Diese Methode liest eine Datei und erstellt daraus einen Graph. Die Datei sollte eine Liste von Städten und ihren Verbindungen enthalten.
main: Dies ist die Hauptmethode, die ausgeführt wird, wenn das Programm gestartet wird. Sie liest den Namen der Datei, die den Graph enthält, und die Start- und Zielstädte von der Kommandozeile ein und berechnet dann den kürzesten Pfad zwischen diesen Städten.
distances: Dies ist eine lokale Variable in der shortestPath-Methode. Sie speichert die kürzeste Entfernung von der Startstadt zu jeder anderen Stadt.
queue: Dies ist eine lokale Variable in der shortestPath-Methode. Sie ist eine Prioritätswarteschlange, die verwendet wird, um die Städte in der Reihenfolge ihrer Entfernung von der Startstadt zu verarbeiten.
curr: Dies ist eine lokale Variable in der shortestPath-Methode. Sie repräsentiert die aktuell verarbeitete Stadt.
filenameGraph: Dies ist eine Variable in der main-Methode. Sie enthält den Namen der Datei, die den Graph enthält.
start und target: Diese sind Variablen in der main-Methode. Sie stellen die Start- und Zielstädte dar.
shortestPath: Dies ist eine lokale Variable in der main-Methode. Sie speichert den kürzesten Pfad von der Start- zur Zielstadt.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Graph {
    private Map<String, Map<String, Integer>> vertices;

    public Graph() {
        vertices = new HashMap<>();
    }

    public void addEdge(String city1, int weight, String city2) {
        vertices.putIfAbsent(city1, new HashMap<>());
        vertices.putIfAbsent(city2, new HashMap<>());

        vertices.get(city1).put(city2, weight);
        vertices.get(city2).put(city1, weight);
    }

     public Map<String, Integer> shortestPath(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        for (String city : vertices.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            String currCity = curr.city;

            if (curr.distance > distances.get(currCity)) {
                continue;
            }

            for (Map.Entry<String, Integer> neighbor : vertices.get(currCity).entrySet()) {
                String nextCity = neighbor.getKey();
                int weight = neighbor.getValue();
                int newDist = curr.distance + weight;

                if (newDist < distances.get(nextCity)) {
                    distances.put(nextCity, newDist);
                    queue.offer(new Node(nextCity, newDist));
                }
            }
        }

        return distances;
    }

    private static class Node {
        String city;
        int distance;

        Node(String city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }
    public static Graph readGraphFromFile(String filename) throws IOException {
        Graph graph = new Graph();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.trim().split(":");

                String lineName = lineParts[0].trim();
                String connections = lineParts[1].trim();

                List<String> cities = new ArrayList<>();
                List<Integer> weights = new ArrayList<>();

                Matcher cityMatcher = Pattern.compile("\"([^\"]+)\"").matcher(connections);
                while (cityMatcher.find()) {
                    cities.add(cityMatcher.group(1));
                }

                Matcher weightMatcher = Pattern.compile("\\b(\\d+)\\b").matcher(connections);
                while (weightMatcher.find()) {
                    weights.add(Integer.parseInt(weightMatcher.group(1)));
                }

                for (int i = 0; i < cities.size() - 1; i++) {
                    String city1 = cities.get(i);
                    String city2 = cities.get(i + 1);
                    int weight = weights.get(i);

                    graph.addEdge(city1, weight, city2);
                }
            }
        }

        return graph;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java filename_graph");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        String filenameGraph = args[0];
        System.out.println("Start: ");
        String start = scanner.nextLine();
        System.out.println("Target: ");
        String target = scanner.nextLine();

        try {
            Graph graph = readGraphFromFile(filenameGraph);
            Map<String, Integer> distances = graph.shortestPath(start, target);

            if (distances.containsKey(target)) {
                List<String> shortestPath = new ArrayList<>();
                String currCity = target;

                while (!currCity.equals(start)) {
                    shortestPath.add(currCity);
                    String nextCity = null;
                    int shortestDist = Integer.MAX_VALUE;

                    for (Map.Entry<String, Integer> neighbor : graph.vertices.get(currCity).entrySet()) {
                        String neighborCity = neighbor.getKey();
                        int neighborDist = distances.get(neighborCity) + neighbor.getValue();

                        if (neighborDist < shortestDist) {
                            nextCity = neighborCity;
                            shortestDist = neighborDist;
                        }
                    }

                    currCity = nextCity;
                }

                shortestPath.add(start);
                Collections.reverse(shortestPath);

                System.out.println("Shortest path from " + start + " to " + target + ": " + java.lang.String.join(" -> ", shortestPath));
                System.out.println("Weight of the shortest path: " + distances.get(target));
            } else {
                System.out.println("No path found from " + start + " to " + target);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
