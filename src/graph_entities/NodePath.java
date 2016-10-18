package graph_entities;

public class NodePath extends Node{
	private int weight = 1000; //10000 as infinite weight
	private Node predecessor = null;

	public NodePath(String name) {
		super(name);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}

	@Override
	public String toString() {
		String pred;
		if( predecessor == null ){
			pred = "0";
		} else {
			pred = predecessor.getName();
		}
		String s = this.getName()+", "+this.weight+", "+pred;
		return s;
	}
}
