package graph_entities;

public class Edge {
	private NodePath node1, node2; //nodes that edge connect
	private int weight;
	
	public Edge(NodePath node1, NodePath node2, int weight) {
		this.node1 = node1;
		this.node2 = node2;
		this.weight = weight;
	}

	public NodePath getNode1() {
		return node1;
	}

	public NodePath getNode2() {
		return node2;
	}
	
	public int getWeight() {
		return weight;
	}
}
