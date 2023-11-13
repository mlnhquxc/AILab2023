package Lab6_HillClimbing_SA_8Queens;

public class HillClimbing {

	public Node execute(Node start) throws CloneNotSupportedException {
		Node current = start, neighbor = null;
		while (current.getH() > 0) {
			neighbor = current.getBestCandidate();
			if (current.getH() > neighbor.getH())
				current = neighbor;
			else {
				System.out.println("H: " + current.getH());
				return current;
			}
		}
		System.out.println("H: " + current.getH());
		return current;
	}

	public Node executeHillClimbingWithRandomRestart(Node start) throws CloneNotSupportedException {
		Node cr = start, neighbor = null;
		while (cr.getH() != 0) {
			while (cr.getH() > 0) {
				neighbor = cr.getBestCandidate();
				if (cr.getH() > neighbor.getH())
					cr = neighbor;
				else {
					break;
				}
			}
			cr = new Node();
		}
		System.out.println("H: "+cr.getH());
		return cr;
	}
	
//	public Node execute(Node initialState) throws CloneNotSupportedException {
//		Node current = initialState, neighbor = null;
//		while(true) {
//			neighbor=current.getBestCandidate();
//			if(current.getH()>neighbor.getH()) current=neighbor;
//			else return current;
//		}
//	}
}
