package Lab2_GraphSearch;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> explored = new HashSet<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            explored.add(node);

            if (node.getLabel().equals(goal)) {
                return node;
            }

            List<Node> childNodes = node.getChildrenNodes();

            for (Node childNode : childNodes) {
                if (!explored.contains(childNode) && !queue.contains(childNode)) {
                    childNode.setParent(node);
                    queue.add(childNode);
                }
            }
        }

        return null;
    }
	

	@Override
	public Node execute(Node root, String start, String goal) {
		boolean starting = false;
		Queue<Node> queue = new LinkedList<Node>();
		List<Node> explored = new ArrayList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			explored.add(node);
			if (node.getLabel().equals(start)) {
				starting = true;
				explored.clear();
				node.setParent(null);
				queue.clear();
			}
			if (node.getLabel().equals(goal) && starting) return node;
			List<Node> listNode = node.getChildrenNodes();
			for (Node n: listNode) {
				if (!queue.contains(n) && !explored.contains(n)) {
					n.setParent(node);						
					queue.add(n);
				}
			}
		}
		return null;
	}

}
