package Lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		int v = maxValue(node);
		node.setValue(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		int v = Integer.MIN_VALUE;
		if(node.isTerminal()) {
			return node.getValue();
		}
		else {
			List<Node> listNode = node.getChildren();
			for (Node childNode : listNode) {
				v = Math.max(v, minValue(childNode));
			}
		}
		return v;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		int v = Integer.MAX_VALUE;
		if(node.isTerminal()) {
			return node.getValue();
		}
		else {
			List<Node> listNode = node.getChildren();
			for (Node childNode : listNode) {
				v = Math.min(v, maxValue(childNode));
			}
		}
		return v;
	}
}
