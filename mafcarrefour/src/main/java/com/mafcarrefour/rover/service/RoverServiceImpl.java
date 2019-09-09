package com.mafcarrefour.rover.service;

import java.util.Arrays;
import java.util.List;

import com.mafcarrefour.rover.entity.Plateau;
import com.mafcarrefour.rover.entity.Rover;

public class RoverServiceImpl implements RoverService {
	private final List<String> DIRECTION = Arrays.asList("N", "E", "S", "W");// Clock wise direction

	private Plateau plateau;

	public void moveRoverOnPlateau(Plateau plateau) {
		this.plateau = plateau;

		for (Rover rover : plateau.getRoverList()) {
			
			//new Thread(() -> { moveRobo(rover); }).start();
			 
			moveRobo(rover);
		}
	}

	private Rover moveRobo(Rover rover) {
		try {
			String movePlan = rover.getMovePlan();
			if (movePlan.length() > 0) {
				char moveTo = movePlan.charAt(0);
				char headFaced = rover.getHeadFaced();
				if ('L' == moveTo) {
					rover.setHeadFaced(getNextDirection(headFaced, -1));
				} else if ('R' == moveTo) {
					rover.setHeadFaced(getNextDirection(headFaced, 1));
				} else if ('M' == moveTo) {
					forwardStep(rover);
				} else {
					throw new RoverException(moveTo + " is not defined step. Pease specify L, R or M.");
				}
				rover.setMovePlan(movePlan.substring(1, movePlan.length()));
				moveRobo(rover);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rover;
	}

	private void forwardStep(Rover rover) throws RoverException {
		StringBuffer message = new StringBuffer();
		switch (rover.getHeadFaced()) {
		case 'N':
			rover.setPosY(rover.getPosY() + 1);
			if (!validateStep(rover)) {
				message.append("Can't mover at: Direction=North->").append(rover.getPosX()).append(",")
				.append(rover.getPosY());
				rover.setPosY(rover.getPosY() - 1);//
			}
			break;
		case 'S':
			rover.setPosY(rover.getPosY() - 1);
			if (!validateStep(rover)) {
				message.append("Can't mover at: Direction=South->").append(rover.getPosX()).append(",")
				.append(rover.getPosY());
				rover.setPosY(rover.getPosY() + 1);//
			}

			break;
		case 'E':
			rover.setPosX(rover.getPosX() + 1);
			if (!validateStep(rover)) {
				message.append("Can't mover at: Direction=East->").append(rover.getPosX()).append(",")
				.append(rover.getPosY());
				rover.setPosX(rover.getPosX() - 1);//
			}

			break;
		case 'W':
			rover.setPosX(rover.getPosX() - 1);
			if (!validateStep(rover)) {
				message.append("Can't mover at: Direction=West->").append(rover.getPosX()).append(",")
				.append(rover.getPosY());
				rover.setPosX(rover.getPosX() + 1);//
			}
			break;
		default:
			message.append("Invalid direction");
		}
		if (message.length() > 0) {
			throw new RoverException(message.toString());
		}

	}

	private boolean validateStep(Rover rover) {
		return ((plateau.getMaxX() >= rover.getPosX()) && (plateau.getMaxY() >= rover.getPosY())
				&& (plateau.getMinX() <= rover.getPosX()) && (plateau.getMinY() <= rover.getPosY()));
	}

	private char getNextDirection(char headFaced, int step) {
		int directionIndex = DIRECTION.indexOf(String.valueOf(headFaced)) + step;
		while (directionIndex < 0) {
			directionIndex = DIRECTION.size() + directionIndex;
		}
		while (directionIndex > DIRECTION.size()-1) {
			directionIndex = DIRECTION.size() - directionIndex;
		}
		return DIRECTION.get(directionIndex).toCharArray()[0];
	}
}
