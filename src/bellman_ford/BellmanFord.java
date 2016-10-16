package bellman_ford;

import graph_entities.*;

public class BellmanFord {

	private static boolean relax(Edge edge, boolean flag) {
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
			System.out.print(n.toString()+" | ");
		System.out.println("\n");
	}
	
	public static void shortestPath(Node[] nodes, Edge[] edges){
		boolean changed;
		for (int i = 0; i < nodes.length; i++) {
			changed = false;
			for (int j = 0; j < edges.length; j++) {
				changed = relax(edges[j], changed);
			}
			if(!changed)break;
		}
	}
}