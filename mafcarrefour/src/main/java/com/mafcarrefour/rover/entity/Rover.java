package com.mafcarrefour.rover.entity;

import com.mafcarrefour.rover.service.Direction;

public class Rover {
	private String name;
	private int posX;
	private int posY;
	private Direction direction;
	private String movePlan;
	
	
	public Rover(String name, int posX, int posY, Direction direction, String movePlan) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.direction = direction;
		this.movePlan = movePlan;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	public String getMovePlan() {
		return movePlan;
	}
	public void setMovePlan(String movePlan) {
		this.movePlan = movePlan;
	}
	
		
}
