package Lab7;

public class Test {
	public static void main(String[] args) {
		Node node = new Node();
		node.displayBoard();
		GA_NQueenAlgo algo = new GA_NQueenAlgo();
		System.out.println(algo.execute());
		
	}
}
