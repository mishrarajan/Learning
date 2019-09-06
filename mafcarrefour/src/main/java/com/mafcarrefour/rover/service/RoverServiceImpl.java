package com.mafcarrefour.rover.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mafcarrefour.rover.entity.Plateau;
import com.mafcarrefour.rover.entity.Rover;

public class RoverServiceImpl implements RoverService {
	private final List<String> DIRECTION = Arrays.asList("N","E","S","W");//Clock wise direction

	public void moveRoboOnPlateau(Plateau plateau) {
		
	}
	
	public Rover moveRobo(Rover rover, String movePlan) {
		if(movePlan.length()>0) {
			char moveTo = movePlan.charAt(0);
			char headFaced = rover.getHeadFaced();
			if('L'== moveTo) {
				rover.setHeadFaced(getNextDirection(headFaced, -1));
			}else if('R'== moveTo ) {
				rover.setHeadFaced(getNextDirection(headFaced, 1));
			} else if('M'== moveTo) {
				moveNext(rover);
			}else {
				throw new RuntimeException(moveTo +" is not defined step. Pease specify L, R or M.");
			}
			movePlan = movePlan.substring(1, movePlan.length());
			moveRobo(rover, movePlan);
		}
		return rover;
	}

	private void moveNext(Rover rover) {
		switch(rover.getHeadFaced()) {
		case 'N': rover.setPosY(rover.getPosY()+1);
		break;
		case 'S': rover.setPosY(rover.getPosY()-1);
		break;
		case 'E': rover.setPosX(rover.getPosX()+1);
		break;
		case 'W': rover.setPosX(rover.getPosX()-1);
		break;
		default: throw new RuntimeException("Invalid direction");
		}
	}

	private char getNextDirection(char headFaced, int step) {
		int directionIndex = DIRECTION.indexOf(String.valueOf(headFaced))+step;
		while(directionIndex < 0) {
			directionIndex = DIRECTION.size() + directionIndex;
		}
		while(directionIndex > DIRECTION.size()) {
			directionIndex = DIRECTION.size() - directionIndex;
		}
		return DIRECTION.get(directionIndex).toCharArray()[0];
	}

	private boolean validateStep(Plateau plateau, Rover rover) {
		return (
				(plateau.getMaxX() >= rover.getPosX()) && 
				(plateau.getMaxY() >= rover.getPosY()) && 
				(plateau.getMinX() <= rover.getPosX()) &&
				(plateau.getMinY() <= rover.getPosY())
				);
	}
	public static void main(String[] args) {
		Plateau plateau = new Plateau();
		plateau.setMinX(0);
		plateau.setMinY(0);
		plateau.setMaxX(5);
		plateau.setMaxY(5);
		plateau.getRoverList().add(new Rover(1, 2, 'N'));
		plateau.getRoverList().add(new Rover(3, 3, 'E'));
		
	}
}
