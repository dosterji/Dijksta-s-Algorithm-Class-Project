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
package Graph;

import java.util.ArrayList;

/**
 * This class functions has a data holder.
 * It basically just holds the information of the edges
 * and the vertices of a graph.
 *
 * @author dosterji
 * @date 12/4/2017
 */
public class Graph {
    private ArrayList<Vertex> verts;
    private ArrayList<Edge> edges;

    public Graph( ArrayList<Vertex> verts, ArrayList<Edge> edges ) {
        this.verts = verts;
        this.edges = edges;
    }

    public ArrayList<Vertex> getVerts() { return verts; }
    public ArrayList<Edge> getEdges() { return edges; }

    public String toString() {
        String s = "";
        for(int i=0; i<verts.size(); i++) {
            s += verts.get(i).toString() + "; ";
        }
        s += "\n";
        for(int i=0; i<edges.size(); i++) {
            s += edges.get(i).toString() + "; ";
        }
        return s;
    }
}
