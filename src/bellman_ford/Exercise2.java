package bellman_ford;

import graph_entities.*;

public class Exercise2 {
	public static void main(String[] args) {
		Node[] nodes = { 
				new Node("A"),//0
				new Node("B"),//1
				new Node("C"),//2
				new Node("D"),//3
				new Node("E"),//4
				new Node("F") };//5

		NodePath[] nodePaths = new NodePath[nodes.length];

		for (int i = 0; i < nodePaths.length; i++) 
			nodePaths[i] = new NodePath(nodes[i].getName());

		//set weight zero for source node A
		nodePaths[0].setWeight(0);
		Edge[] edges = {
				new Edge(nodePaths[5], nodePaths[4], 1),//F-E
				new Edge(nodePaths[4], nodePaths[3], 2),//E-D
				new Edge(nodePaths[1], nodePaths[3], 1),//B-D
				new Edge(nodePaths[2], nodePaths[1], 2),//C-B
				new Edge(nodePaths[1], nodePaths[4], 3),//B-E
				new Edge(nodePaths[2], nodePaths[3], 2),//C-D
				new Edge(nodePaths[2], nodePaths[5], 4),//C-F
				new Edge(nodePaths[0], nodePaths[2], 2),//A-C
				new Edge(nodePaths[0], nodePaths[1], 1),//A-B
				new Edge(nodePaths[5], nodePaths[3], 2) /*F-D*/};

		Graph graph = new Graph(nodes, edges);

		//print nodes state in form:
		//node name, node weight, predecessor
		System.out.println("Initial nodes states:");
		graph.printNodes(nodePaths);

		//bellman-ford algorithm
		graph.bellmanFordShortestPath(nodePaths, edges);

		//print nodes with shortest paths
		System.out.println("Shortest path table from root A:");
		graph.printNodes(nodePaths);
	}
}
