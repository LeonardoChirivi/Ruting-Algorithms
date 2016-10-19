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

		NodePath[] nodePaths = new NodePath[nodes.length];

		for (int i = 0; i < nodePaths.length; i++) 
			nodePaths[i] = new NodePath(nodes[i].getName());

		//set weight zero for source node A
		nodePaths[0].setWeight(0);

		Edge[] edges = {
				new Edge(nodePaths[1], nodePaths[0], 8),//B-A
				new Edge(nodePaths[2], nodePaths[4], 2),//C-E
				new Edge(nodePaths[4], nodePaths[2], 2),//E-C
				new Edge(nodePaths[1], nodePaths[2], 14),//B-C
				new Edge(nodePaths[0], nodePaths[1], 8),//A-B
				new Edge(nodePaths[3], nodePaths[5], 4),//D-F
				new Edge(nodePaths[5], nodePaths[4], 11),//G-E
				new Edge(nodePaths[2], nodePaths[1], 14),//C-B
				new Edge(nodePaths[3], nodePaths[0], 2),//D-A
				new Edge(nodePaths[0], nodePaths[3], 2),//A-D
				new Edge(nodePaths[4], nodePaths[5], 11),//E-G
				new Edge(nodePaths[4], nodePaths[3], 9),//E-D
				new Edge(nodePaths[5], nodePaths[6], 5),//F-G
				new Edge(nodePaths[3], nodePaths[4], 9),//D-E
				new Edge(nodePaths[5], nodePaths[3], 4),//F-D
				new Edge(nodePaths[6], nodePaths[5], 5)/*G-F*/};

		Graph graph = new Graph(nodePaths, edges);

		//print nodes state in form:
		//node name, node weight, predecessor
		System.out.println("Initial nodes states:");
		System.out.println(graph.toString(nodePaths));

		//bellman-ford algorithm
		graph.bellmanFordShortestPath(nodePaths, edges);

		//print nodes with shortest paths
		System.out.println("Shortest path table from root A:");
		System.out.println(graph.toString(nodePaths));
	}
}
