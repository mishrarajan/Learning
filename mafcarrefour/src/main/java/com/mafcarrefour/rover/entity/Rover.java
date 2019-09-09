package com.mafcarrefour.rover.entity;

public class Rover {
	private String name;
	private int posX;
	private int posY;
	private char headFaced;
	private String movePlan;
	
	/**
	 * To set the initial position of Rover
	 * @param posX
	 * @param posY
	 * @param headFaced
	 */
	public Rover(String name, int posX, int posY, char headFaced, String movePlan) {
		this.name = name;
		this.posX = posX;
		this.posY = posY;
		this.headFaced = headFaced;
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
	public char getHeadFaced() {
		return headFaced;
	}
	public void setHeadFaced(char headFaced) {
		this.headFaced = headFaced;
	}
	
	public String getMovePlan() {
		return movePlan;
	}

	public void setMovePlan(String movePlan) {
		this.movePlan = movePlan;
	}

	@Override
	public String toString() {
		return "Rover [posX=" + posX + ", posY=" + posY + ", headFaced=" + headFaced + "]";
	}
	
}
