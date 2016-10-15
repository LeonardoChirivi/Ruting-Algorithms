package bellman_ford;

import graph_entities.*;

public class BellmanFord {

	public static boolean relax(Edge edge, boolean flag) {
		int weightNode1 = edge.getNode1().getWeight();
		int weightNode2 = edge.getNode2().getWeight();
		int edgeWeight = edge.getWeight();

		if ( weightNode2 > (weightNode1 + edgeWeight) ) {
			//set new weight
			edge.getNode2().setWeight(weightNode1 + edgeWeight);
			//set new predecessor
			edge.getNode2().setPredecessor(edge.getNode1());
			return true;
		} else {
			return (flag==true)? true : false;
		}
	}

	public static void printNodes(Node[] a) {
		for(Node n : a)
			System.out.print(n.toString()+" || ");
		System.out.println("\n");
	}
	
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
		printNodes(nodes);
		
		//bellman-ford algorithm
		for ( int i = 0; i < nodes.length-1; i++) {
			boolean changed = false;
			for ( int j = 0; j < edges.length; j++) {
				changed = relax(edges[j], changed);
			}
			if(!changed) break;
		}
		//print nodes with shortest paths
		printNodes(nodes);
	}
}