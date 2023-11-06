package Lab5;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<Node>();
		
		Node startNode = new Node(model.getInitialState());
		startNode.setH(model.computeH2(startNode));
		frontier.add(startNode);
		
		while(!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			explored.add(currentNode);
			if(currentNode.getH() == 0) {
				return currentNode;
			}
			else {
				for (Node childNode : model.getSuccessors(currentNode)) {
					if(!frontier.contains(childNode) && !explored.contains(childNode)){
						childNode.setG(currentNode.getG() + childNode.getH() - currentNode.getH() + 1);
						frontier.add(childNode);
					}
					else if (frontier.contains(childNode) && !explored.contains(childNode)) {
						for (Node node : frontier) {
							if(currentNode.equals(node) && currentNode.getH()<node.getH()) {
								frontier.remove(node);
								frontier.add(childNode);
								break;
							}
						}
					}
				}
			}
		}
		
		return null;
	}
}
