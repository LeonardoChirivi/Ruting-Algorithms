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
		
		NodePath[] nodePaths = new NodePath[nodes.length];
		
		for (int i = 0; i < nodePaths.length; i++) 
			nodePaths[i] = new NodePath(nodes[i].getName());
		
		//set weight zero for source node A
		nodePaths[0].setWeight(0);

		Edge[] edges = {
				new Edge(nodePaths[5], nodePaths[4], 3),//F-E
				new Edge(nodePaths[4], nodePaths[3], 2),//E-D
				new Edge(nodePaths[1], nodePaths[3], 4),//B-D
				new Edge(nodePaths[2], nodePaths[1], 2),//C-B
				new Edge(nodePaths[1], nodePaths[4], 1),//B-E
				new Edge(nodePaths[4], nodePaths[2], 2),//E-C
				new Edge(nodePaths[2], nodePaths[4], 2),//C-F
				new Edge(nodePaths[0], nodePaths[2], 8),//A-C
				new Edge(nodePaths[0], nodePaths[1], 7),//A-B
				new Edge(nodePaths[1], nodePaths[5], 2) /*B-F*/};
		
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
