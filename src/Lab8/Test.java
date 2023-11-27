package Lab8;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D", 0);
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G", -5);
		Node nodeH = new Node("H", 3);
		Node nodeI = new Node("I", 8);
		Node nodeJ = new Node("J");
		Node nodeK = new Node("K");
		Node nodeL = new Node("L", 2);
		Node nodeM = new Node("M");
		Node nodeN = new Node("N", 4);
		Node nodeO = new Node("O");
		Node nodeP = new Node("P", 9);
		Node nodeQ = new Node("Q", -6);
		Node nodeR = new Node("R", 0);
		Node nodeS = new Node("S", 3);
		Node nodeT = new Node("T", 5);
		Node nodeU = new Node("U", -7);
		Node nodeV = new Node("V", -9);
		Node nodeW = new Node("W", -3);
		Node nodeX = new Node("X", -5);
		
		nodeA.addChild(nodeB);
		nodeA.addChild(nodeC);
		nodeA.addChild(nodeD);
		nodeA.addChild(nodeE);
		
		nodeB.addChild(nodeF);
		nodeB.addChild(nodeG);
		
		nodeF.addChild(nodeN);
		nodeF.addChild(nodeO);
		
		nodeO.addChild(nodeW);
		nodeO.addChild(nodeX);
		
		nodeC.addChild(nodeJ);
		nodeC.addChild(nodeH);
		nodeC.addChild(nodeI);
		
		nodeE.addChild(nodeK);
		nodeE.addChild(nodeL);
		nodeE.addChild(nodeM);
		
		
		nodeJ.addChild(nodeP);
		nodeJ.addChild(nodeQ);
		nodeJ.addChild(nodeR);
		
		nodeK.addChild(nodeS);
		nodeK.addChild(nodeT);
		 	
		nodeM.addChild(nodeU);
		nodeM.addChild(nodeV);
		
		
		AlphaBetaSearchAlgo algo = new AlphaBetaSearchAlgo();
		algo.execute(nodeA);
		System.out.println(nodeA.getValue());
	}
}
