package Lab1_Task2;

import java.util.Random;

import Lab1_Task2.Environment.LocationState;

public class AgentProgram {
	public Action execute(Percept p) {// location, status
		Random random = new Random();
		if(p.getLocationState().equals(LocationState.DIRTY)) {
			return Environment.SUCK_DIRT;
		}
		switch (random.nextInt(4)) {
		case 0:
			return Environment.MOVE_LEFT;
		case 1:
			return Environment.MOVE_RIGHT;
		case 2:
			return Environment.MOVE_UP;
		case 3:
			return Environment.MOVE_DOWN;
		}
		return NoOpAction.NO_OP;
	}
}