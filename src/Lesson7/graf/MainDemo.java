package Lesson7.graf;

public class MainDemo {

    public static void main(String[] args) {

        int vertexCount = 10;  //количество вершин
        int sourse = 2;  //начальная вершина
        int vertex = 5;   //целевая вершина

        GrafVebinar graph = new GrafVebinar(vertexCount);

        put10Edge(graph);  //задаём рёбра графа

        BreadthFirstPath bfp = new BreadthFirstPath(graph, sourse);

        if (bfp.hasPathTo(vertex)){
            System.out.println("Nearest path from " + sourse + " to "  + vertex + " is " + bfp.pathTo(vertex));
        }else {
            //2-7  5-8 и др
            System.out.println("No path from " + sourse + " to "  + vertex);
        }
    }

    private static void put10Edge(GrafVebinar graph) {
        graph.addEdge(0,1);
        graph.addEdge(1,2);

        graph.addEdge(0,3);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(6,7);
        graph.addEdge(7,8);

        graph.addEdge(0,5);
        graph.addEdge(0,9);
    }
}
