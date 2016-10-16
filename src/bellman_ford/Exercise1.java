package bellman_ford;

import graph_entities.*;

public class Exercise1 {
	public static void main(String[] args) {
		Node[] nodes = { 
				new Node("A"),
				new Node("B"),
				new Node("C"),
				new Node("D"),
				new Node("E"),
				new Node("F") };

		//set weight zero for source node A
		nodes[0].setWeight(0);

		Edge[] edges = {
				new Edge(nodes[5], nodes[4], 3),//F-E
				new Edge(nodes[4], nodes[3], 2),//E-D
				new Edge(nodes[1], nodes[3], 4),//B-D
				new Edge(nodes[2], nodes[1], 2),//C-B
				new Edge(nodes[1], nodes[4], 1),//B-E
				new Edge(nodes[4], nodes[2], 2),//E-C
				new Edge(nodes[2], nodes[4], 2),//C-F
				new Edge(nodes[0], nodes[2], 8),//A-C
				new Edge(nodes[0], nodes[1], 7),//A-B
				new Edge(nodes[1], nodes[5], 2) /*B-F*/};

		//print nodes state in form:
		//node name, node weight, predecessor
		System.out.println("Initial nodes states:");
		BellmanFord.printNodes(nodes);

		//bellman-ford algorithm
		BellmanFord.shortestPath(nodes, edges);
		
		//print nodes with shortest paths
		System.out.println("Shortest path table from root A:");
		BellmanFord.printNodes(nodes);
	}
}
