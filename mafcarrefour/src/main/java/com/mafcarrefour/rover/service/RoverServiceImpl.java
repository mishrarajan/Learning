package com.mafcarrefour.rover.service;

import java.util.Arrays;
import java.util.List;

import com.mafcarrefour.rover.entity.Plateau;
import com.mafcarrefour.rover.entity.Rover;

public class RoverServiceImpl implements RoverService {
	private Direction[] directions = Direction.values();
	private final List<Direction> directionList = Arrays.asList(directions);// Clock wise direction

	private Plateau plateau;

	public void moveRoverOnPlateau(Plateau plateau) {
		this.plateau = plateau;
		moveRobo(plateau.getRoverList().get(0));
	}

	private Rover moveRobo(Rover rover) {
		try {
			String movePlan = rover.getMovePlan();
			if (movePlan.length() > 0) {
				char moveTo = movePlan.charAt(0);
				if (moveTo==Movement.LEFT.getName()) {
					rover.setDirection(getNextDirection(rover, Movement.LEFT));
				} else if (moveTo==Movement.RIGHT.getName()) {
					rover.setDirection(getNextDirection(rover, Movement.RIGHT));
				} else if (Movement.MOVE_NEXT.getName() == moveTo) {
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
		Direction direction = Direction.valueOf(String.valueOf(rover.getDirection()));
		validateStep(rover,direction);
		if('X' == direction.getAxis()) {
			rover.setPosX(direction.getMoveNext() + rover.getPosX());
		} else if('Y' == direction.getAxis()) {
			rover.setPosY(direction.getMoveNext() + rover.getPosY());
		}

	}
	private boolean validateStep(Rover rover, Direction direction) throws RoverException {
		int x= rover.getPosX();
		int y = rover.getPosY(); 
		if('X' == direction.getAxis()) {
			x = direction.getMoveNext() + rover.getPosX();
		} else if('Y' == direction.getAxis()) {
			y = direction.getMoveNext() + rover.getPosY();
		}
		boolean result =  ((plateau.getMaxX() >= x) && (plateau.getMaxY() >=
				y) && (plateau.getMinX() <= x) &&
				(plateau.getMinY() <= y));
		if(result) {
			return true;
		}
		throw new RoverException("Rover Can't move next step!");
	}
	private Direction getNextDirection(Rover rover, Movement movement) throws RoverException {
		Direction direction =  rover.getDirection();

		int directionIndex = direction.getIndex()+movement.getMove();
		while (directionIndex < 0) {
			directionIndex = directionList.size() + directionIndex;
		}
		while (directionIndex > directionList.size()-1) {
			directionIndex = directionList.size() - directionIndex;
		}
		for(Direction dir: directionList) {
			if(dir.getIndex()==directionIndex) {
				return dir;
			}
		}
		throw new RoverException("Unable to find Direction!");
	}
}
