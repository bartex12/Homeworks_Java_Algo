package Lesson7.graf;

import java.util.LinkedList;

public class GrafVebinar {

    private int vertexCount;
    private int edgeCount = 0;
    private LinkedList<Integer>[] adjList;

    GrafVebinar(int vertexCount) {
        if (vertexCount <= 0) {
            throw new IllegalArgumentException("Vertex count " + vertexCount);
        }

        this.vertexCount = vertexCount;
        adjList = new LinkedList[vertexCount];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    int getVertexCount() {
        return vertexCount;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    LinkedList<Integer> getAdjList(int vertex) {
        return (LinkedList<Integer>)adjList[vertex].clone();
    }

    void addEdge(int v1, int v2) {
        if (v1 < 0 || v2 < 0 || v1 >= vertexCount || v2 >= vertexCount) {
            throw new IllegalArgumentException();
        }
        adjList[v1].add(v2);
        adjList[v2].add(v1);
    }
}
