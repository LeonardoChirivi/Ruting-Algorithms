package graph_entities;

public class Node {
	private String name;
	private int weight = 1000; //10000 as infinite weight
	private Node predecessor = null; 
	
	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Node getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Node predecessor) {
		this.predecessor = predecessor;
	}
	
	@Override
	public String toString() {
		String name;
		if( predecessor == null ){
			name = "0";
		} else {
			name = predecessor.getName();
		}
		String s = this.name+", "+this.weight+", "+name;
		return s;
	}
}
