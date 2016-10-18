package graph_entities;

public class Graph {
	Node[] nodes;
	Edge[] edges;

	public Graph(Node[] nodes, Edge[] edges){
		this.nodes = nodes;
		this.edges = edges;
	}

	private boolean relax( Edge e, boolean flag){
		int weightNode1 = e.getNode1().getWeight();
		int weightNode2 = e.getNode2().getWeight();
		int edgeWeight = e.getWeight();

		if ( weightNode2 > (weightNode1 + edgeWeight) ) {
			//set new weight
			e.getNode2().setWeight(weightNode1 + edgeWeight);
			//set new predecessor
			e.getNode2().setPredecessor(e.getNode1());
			return true;
		} else {
			return (flag==true)? true : false;
		}
	}
	
	public void printNodes(NodePath[] n) {
		for(Node node : n)
			System.out.print(node.toString()+" | ");
		System.out.println("\n");
	}
	
	public void bellmanFordShortestPath(NodePath[] nodes, Edge[] edges){
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
