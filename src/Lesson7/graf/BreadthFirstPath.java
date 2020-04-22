package Lesson7.graf;



import java.util.LinkedList;

class BreadthFirstPath {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;
    private int source;

    private final int INFINITY = Integer.MAX_VALUE;

    BreadthFirstPath(GrafVebinar g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        distTo = new int[g.getVertexCount()];

        marked = new boolean[g.getVertexCount()];

        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = INFINITY;
        }
        bfs(g, source);
    }

    private void bfs(GrafVebinar g, int source) {
        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast(source); // добавляем в конец очереди вершину source
        marked[source] = true;  // отмечаем, что посетили её, так как она начальная
        distTo[source] = 0;   //разс неё начинаем, то и путь = 0

        while (!queue.isEmpty()) {                  //пока очередь не пуста - а она точно пока не пуста
            int vertex = queue.removeFirst();  //берём первый элемент из очереди
            for (int w: g.getAdjList(vertex)) {   // для каждого элемента списка данной вершины графа
                if (!marked[w]) {   //если  не отмечено,
                    marked[w] = true;  //отмечаем
                    edgeTo[w] = vertex;  //добавляем посещённую вершину
                    distTo[w] = distTo[vertex] + 1;  //увеличиваем путь на 1
                    queue.addLast(w);   //добавляем в очередь данный элемент списка
                    // -для него потом  будем вызывать список вершин через queue.removeFirst()
                }
            }
        }
    }

    boolean hasPathTo(int v) {
        return marked[v];
    }

    LinkedList<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = v;

        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
