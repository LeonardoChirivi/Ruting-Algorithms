package bellman_ford;

import graph_entities.*;

public class Exercise3 {
	public static void main(String[] args) {
		Node[] nodes = { 
				new Node("A"),//0
				new Node("B"),//1
				new Node("C"),//2
				new Node("D"),//3
				new Node("E"),//4
				new Node("F"),//5
				new Node("G")};//6

		//set weight zero for source node A
		nodes[0].setWeight(0);

		Edge[] edges = {
				new Edge(nodes[1], nodes[0], 8),//B-A
				new Edge(nodes[2], nodes[4], 2),//C-E
				new Edge(nodes[4], nodes[2], 2),//E-C
				new Edge(nodes[1], nodes[2], 14),//B-C
				new Edge(nodes[0], nodes[1], 8),//A-B
				new Edge(nodes[3], nodes[5], 4),//D-F
				new Edge(nodes[5], nodes[4], 11),//G-E
				new Edge(nodes[2], nodes[1], 14),//C-B
				new Edge(nodes[3], nodes[0], 2),//D-A
				new Edge(nodes[0], nodes[3], 2),//A-D
				new Edge(nodes[4], nodes[5], 11),//E-G
				new Edge(nodes[4], nodes[3], 9),//E-D
				new Edge(nodes[5], nodes[6], 5),//F-G
				new Edge(nodes[3], nodes[4], 9),//D-E
				new Edge(nodes[5], nodes[3], 4),//F-D
				new Edge(nodes[6], nodes[5], 5)/*G-F*/};

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
