import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.management.Query;

public class MyGraph {
	Map<Vertex, Set<Vertex>> graph;
	MyGraph(){
		graph = new HashMap<Vertex, Set<Vertex>>();
	}
	
	public void addVertex(String label) {
		Vertex toAdd = new Vertex(label);
		Set<Vertex> vSet = new HashSet<Vertex>();
		graph.put(toAdd, vSet);
	}
	
	public void addVertex(Vertex v) {
		//v'nin komsu seti
		Set<Vertex> vSet = new HashSet<Vertex>();
		//graph'a v ve v komsu setini ekledik
		graph.put(v, vSet);
	}
	
	public Set<Vertex> getNeighbors(Vertex v){
		Set<Vertex> neighbors = graph.get(v);
		return neighbors;
	}
	
	public Set<Vertex> getNeighbors(String label){
		Vertex v = new Vertex(label);
		Set<Vertex> neighbors = graph.get(v);
		return neighbors;
	}
	
	public void addEdge(Vertex u, Vertex v) {
		Set<Vertex> uset = getNeighbors(u);
		uset.add(v);
		graph.put(u, uset);
	}
	
	public void addEdge(String u, String v) {
		Set<Vertex> uset = getNeighbors(u);
		uset.add(new Vertex(v));
		graph.put(new Vertex(u), uset);
	}
	
	public void printGraph() {
		for(Vertex v : graph.keySet()) {
			System.out.printf("Vertex: %s ",v.label);
			Set<Vertex> uset = getNeighbors(v);
			System.out.printf("connected to: ");
			for(Vertex u : uset) {
				System.out.printf("%s-",u.label);
			}
			System.out.println();
		}
	}
	
	public void printVertex(Vertex v) {
		System.out.printf("%s",v.label);
		Set<Vertex> uset = getNeighbors(v);
		for(Vertex u : uset) {
			System.out.printf("%s-",u.label);
		}
		System.out.println();
	}
	
	public void DFS(Vertex v) {
		visitVertex(v);
		Set<Vertex> vset = getNeighbors(v);
		for(Vertex u :vset) {
			if(!u.isVisited) {
				DFS(u);
			}
		}
	}
	
	public void visitVertex(Vertex v) {
		v.isVisited = true;
		System.out.printf("%s ",v.label);
	}
	
	public void BFS(Vertex v) {
		Queue<Vertex> Q = new LinkedList<Vertex>();
		Q.add(v);
		while(!Q.isEmpty()) {
			Vertex current = Q.poll();
			visitVertex(current);
			Set<Vertex> vset = getNeighbors(current);
			for(Vertex u : vset) {
				if(!u.isVisited) {
					Q.add(u);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MyGraph graph = new MyGraph();
		graph.addVertex("1");
		graph.addVertex("2");
		graph.addVertex("3");
		graph.addVertex("4");
		graph.addVertex("5");
		graph.addVertex("6");
		graph.addVertex("7");
		
		
		graph.addEdge("1", "2");
		graph.addEdge("1", "3");
		graph.addEdge("2", "4");
		graph.addEdge("2", "5");
		graph.addEdge("3", "6");
		graph.addEdge("3", "7");
		
		//graph.BFS(new Vertex("1"));
		graph.DFS(new Vertex("1"));
		//graph.printGraph();
	}
}
