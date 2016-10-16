package bellman_ford;

import graph_entities.Edge;
import graph_entities.Node;

public class Exercise2 {
	public static void main(String[] args) {
		Node[] nodes = { 
				new Node("A"),//0
				new Node("B"),//1
				new Node("C"),//2
				new Node("D"),//3
				new Node("E"),//4
				new Node("F") };//5

		//set weight zero for source node A
		nodes[0].setWeight(0);

		Edge[] edges = {
				new Edge(nodes[5], nodes[4], 1),//F-E
				new Edge(nodes[4], nodes[3], 2),//E-D
				new Edge(nodes[1], nodes[3], 1),//B-D
				new Edge(nodes[2], nodes[1], 2),//C-B
				new Edge(nodes[1], nodes[4], 3),//B-E
				new Edge(nodes[2], nodes[3], 2),//C-D
				new Edge(nodes[2], nodes[5], 4),//C-F
				new Edge(nodes[0], nodes[2], 2),//A-C
				new Edge(nodes[0], nodes[1], 1),//A-B
				new Edge(nodes[5], nodes[3], 2) /*F-D*/};

		//print nodes state in form:
		//node name, node weight, predecessor
		System.out.println("Initial nodes states:");
		BellmanFord.printNodes(nodes);
		
		//bellman-ford algorithm
		boolean changed;
		for ( int i = 0; i < nodes.length-1; i++) {
			changed = false;
			for ( int j = 0; j < edges.length; j++) {
				changed = BellmanFord.relax(edges[j], changed);
			}
			if(!changed) break;
		}
		//print nodes with shortest paths
		System.out.println("Shortest path table from root A:");
		BellmanFord.printNodes(nodes);
	}
}
