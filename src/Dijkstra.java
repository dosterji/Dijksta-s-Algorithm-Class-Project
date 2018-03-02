/**
 Name: John Doster
 Assignment: Programming Assignment 5
 Course/Semester: CS 371 - Fall 2017
 Instructor: Dr. Wolff
 Sources consulted: Java API online
 Known Bugs: n/a
 Special instructions: Run it from the main method.  It will
 automatically use roads.in
 */
import Graph.Graph;
import Graph.Vertex;
import Graph.Edge;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The class that implements Dijkstra's algorithm.
 *
 */
public class Dijkstra {
    private FileReader fr;          //for reading the file
    private Graph graph;
    private ArrayList<Edge> edges;  //Set of edges minus the blocked one

    ////////////////
    //CONSTRUCTORS//
    ////////////////
    public Dijkstra(String fileName) throws IOException {
        fr = new FileReader(fileName);
        graph = fr.read();
    }//End Constructors

    /////////////////
    //OTHER METHODS//
    /////////////////

    /**
     * This method gets and solves a problem instance.
     *
     * @return the vertex that is the end of the path.
     *          this vertex contains pointers to its parent
     */
    public Vertex solveProblem() {
        String[] problem = fr.getProblemInstance();
        if( problem==null )
            return null;
        Vertex v = obtainVertex(problem[0]);
        Vertex v1 = obtainVertex(problem[1]);
        if( v==null )
            return new Vertex(problem[0] +" is not a recognized city.", null, -1);
        if( v1==null )
            return new Vertex(problem[1] +" is not a recognized city.", null, -1);
        removeEdge(problem[0], problem[1]);
        dijkstrasAlg(v); //Solve problem
        return obtainVertex(problem[1]);
    }

    /**
     * A method for removing the edge connecting two cities from the graph
     *
     * @param city1 The first city
     * @param city2 The second city
     */
    public void removeEdge(String city1, String city2) {
        this.edges = new ArrayList<Edge>();
        ArrayList<Edge> edges = graph.getEdges();
        for(int i=0; i<edges.size(); i++) {
            Edge current = edges.get(i);
            if( current.contains(city1) && current.contains(city2) )
                continue;
            this.edges.add(current);
        }
    }
    /**
     * The actual implementation of Dijkstra's Algorithm.
     * Solves the instances of the problem.  The vertices in the tree
     * are kept track of by the "visited" boolean field in the Graph.Vertex class.
     *
     *
     * @param source The source node ofr this instance
     */
    public void dijkstrasAlg(Vertex source) {
        PriorityQueue<Vertex> q = new PriorityQueue<Vertex>(10, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.compareTo(o2);
            }
        });
        ArrayList<Vertex> verts = graph.getVerts();
        for(int i=0; i<verts.size(); i++) {
            Vertex current = verts.get(i);
            current.distance = Integer.MAX_VALUE;
            current.parent = null;
            current.resetVisit();
            q.offer(current);
        }
        q.remove(source);
        source.distance = 0;
        q.offer(source);

        for(int i=0; i<verts.size()-1; i++) {
            Vertex min = q.poll();
            min.visit();
            updateAdjacentVerts(min, q);
        }
    }

    /**
     * private helper method for updating the distance values for adjacent vertices.
     * Contains the last part of Dijkstra's Algorithm.  Makes sure edges haven't been
     * visited using the Graph.Vertex's "visited" field.
     *
     * @param vert The given vertex to find the neighbors of
     */
    private void updateAdjacentVerts(Vertex vert, PriorityQueue<Vertex> q) {
        ArrayList<Edge> adjacent_edges = new ArrayList<Edge>();
        //ArrayList<Edge> edges = graph.getEdges();

        //Loop for finding attached Edges
        for(int i=0; i<edges.size(); i++) {
            Edge current = edges.get(i);
            if(current.contains(vert.name))
                adjacent_edges.add(current);
        }

        //Loop through adj_edges to find the adjacent vertices (cities)
        for(int i=0; i<adjacent_edges.size(); i++) {
            Edge current = adjacent_edges.get(i);
            int new_distance = vert.distance + current.length;
            String adj_vert_name = current.getOtherCity(vert.name);
            Vertex adj_vert = obtainVertex(adj_vert_name);

            //Update the adjacent Graph.Vertex
            if (!adj_vert.wasVisited()) {    //if this vertex isn't in the tree
                if (new_distance < adj_vert.distance) {  //if new_distance is less than adj_vert's current distance
                    q.remove(adj_vert);
                    adj_vert.distance = new_distance;   //update distance
                    adj_vert.parent = vert;             //change parent
                    q.offer(adj_vert);
                }
            }
        }
    }//END UPDATEADJACENTVERTS()

    /**
     * A method for getting a vertex from the list
     * of Vertices with only the string name;
     *
     * @param name The name of the desired vertex
     * @return The Graph.Vertex Object desired.
     */
    public Vertex obtainVertex(String name) {
        ArrayList<Vertex> verts = graph.getVerts();
        for(int i=0; i<verts.size(); i++) {
            if(verts.get(i).name.equals(name))
                return verts.get(i);
        }
        return null;
    }
}//End class
