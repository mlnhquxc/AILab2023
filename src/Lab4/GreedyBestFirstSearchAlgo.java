package Lab4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
		ArrayList<Node> explored = new ArrayList<Node>();
		while(frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			else {
				explored.add(current);
				List<Edge> children = current.getChildren();
				for (Edge e : children) {
					Node child = e.getEnd();
					
					if(!explored.contains(child) && !frontier.contains(child)) {
						child.setParent(current);
						child.setG(current.getG()+e.getWeight());
						frontier.add(child);
					}
					else if(frontier.contains(child)) {
						double newG = current.getG() + e.getWeight();
						if(newG < child.getG()) {
							child.setParent(current);
							child.setG(newG);
						}
					}
				}
			}
			
		}
		return root;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByHn());
	    ArrayList<Node> explored = new ArrayList<Node>();

	    Node initialNode = new Node(start, 0);
	    frontier.add(initialNode);

	    while (!frontier.isEmpty()) {
	        Node current = frontier.poll();

	        if (current.getLabel().equals(goal)) {
	            return current;
	        } else {
	            explored.add(current);
	            List<Edge> children = current.getChildren();

	            for (Edge e : children) {
	                Node child = e.getEnd();

	                if (!explored.contains(child) && !frontier.contains(child)) {
	                    child.setParent(current);
	                    child.setG(current.getG() + e.getWeight());
	                    frontier.add(child);
	                } else if (frontier.contains(child)) {
	                    double newG = current.getG() + e.getWeight();
	                    if (newG < child.getG()) {
	                        child.setParent(current);
	                        child.setG(newG);
	                    }
	                }
	            }
	        }
	    }

	    return root;
	}
	
//	public boolean isAdmissibleH(Node root, String goal) {
//		return false;
//		
//	}
	
}
