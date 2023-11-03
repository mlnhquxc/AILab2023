package Lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;

public class AStarSearchAlgo implements IInformedSearchAlgo{

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
					
					if(!explored.contains(child)) {
						continue;
					}
					double newG = current.getG() + e.getWeight();
					boolean isNewPath = false;
					
					if (!frontier.contains(child)) {
	                    child.setH(0);
	                    frontier.add(child);
	                    isNewPath = true;
	                } else if (newG < child.getG()) {
	                    isNewPath = true;
	                }

	                if (isNewPath) {
	                    child.setParent(current);
	                    child.setG(newG);
	                }
				}
			}
			
		}
		return root;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparatorByHn());
	    Set<Node> explored = new HashSet<>();

	    Node initialNode = new Node(start, 0);
	    frontier.add(initialNode);

	    while (!frontier.isEmpty()) {
	        Node currentNode = frontier.poll();

	        if (currentNode.getLabel().equals(goal)) {
	            return currentNode;
	        }
	        explored.add(currentNode);

	        for (Edge e : currentNode.getChildren()) {
	            Node child = e.getEnd();
	            if (!explored.contains(child) && !frontier.contains(child)) {
	                child.setParent(currentNode);
	                child.setG(currentNode.getG() + e.getWeight());
	                frontier.add(child);
	            } else if (frontier.contains(child)) {
	                double newG = currentNode.getG() + e.getWeight();
	                if (newG < child.getG()) {
	                    child.setParent(currentNode);
	                    child.setG(newG);
	                }
	            }
	        }
	    }

	    return null;
	}
}
