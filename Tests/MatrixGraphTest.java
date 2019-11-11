import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixGraphTest {

    private Graph directedGraph;
    private MatrixGraph undirectedGraph;

    @BeforeEach
    void setUp()
    {
        directedGraph = new MatrixGraph(5, true);
        undirectedGraph = new MatrixGraph(5, false);
    }

    @Test
    void isEdge() {

    }

    @Test
    void insert() {
        Edge edge = new Edge(0, 1);
        directedGraph.insert(edge);

        boolean expected = true;
        boolean actual = directedGraph.isEdge(0, 1);

        assertEquals(expected, actual);
    }

    @Test
    void insertUndirected() {
        Edge edge = new Edge(0, 1);
        undirectedGraph.insert(edge);

        boolean expected = true;
        boolean actual = undirectedGraph.isEdge(0, 1) && undirectedGraph.isEdge(1, 0);

        assertEquals(expected, actual);
    }

    @Test
    void insertFail() {
        boolean expected = false;
        boolean actual = directedGraph.isEdge(0, 1);

        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        Edge edge = new Edge(0, 1);
        directedGraph.insert(edge);
        directedGraph.remove(edge);

        boolean expected = true;
        boolean actual = !directedGraph.isEdge(0, 1);

        assertEquals(expected, actual);
    }

    @Test
    void removeUndirected() {
        Edge edge = new Edge(0, 1);
        directedGraph.insert(edge);
        directedGraph.remove(edge);

        boolean expected = true;
        boolean actual = !directedGraph.isEdge(0, 1) && !undirectedGraph.isEdge(1, 0);

        assertEquals(expected, actual);
    }

    @Test
    void removeFail() {
        Edge edge = new Edge(0, 1);
        directedGraph.insert(edge);
        directedGraph.remove(edge);

        boolean expected = true;
        boolean actual = !directedGraph.isEdge(0, 1);

        assertEquals(expected, actual);
    }

    @Test
    void BFS()
    {
        Edge edge = new Edge(0, 1);
        undirectedGraph.insert(edge);

        edge = new Edge(0, 4);
        undirectedGraph.insert(edge);

        edge = new Edge(4, 1);
        undirectedGraph.insert(edge);

        edge = new Edge(3, 1);
        undirectedGraph.insert(edge);

        edge = new Edge(3, 2);
        undirectedGraph.insert(edge);

        edge = new Edge(2, 1);
        undirectedGraph.insert(edge);

        undirectedGraph.breadthFirstTraversal(0);
    }
}