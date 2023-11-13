package Lab6_HillClimbing_SA_8Queens;

public class Test {

	public static void main(String[] args) throws CloneNotSupportedException {
		Node node = new Node();
		node.displayBoard();
		System.out.println("\nHill climbing:");
		HillClimbing algo= new HillClimbing();
		algo.execute(node).displayBoard();
		System.out.println("\nHill climbing until Ok:");
		algo.executeHillClimbingWithRandomRestart(node).displayBoard();
	}

}
