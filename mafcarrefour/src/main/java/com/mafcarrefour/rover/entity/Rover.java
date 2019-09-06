package com.mafcarrefour.rover.entity;

public class Rover {
	private int posX;
	private int posY;
	private char headFaced;
	
	/**
	 * To set the initial position of Rover
	 * @param posX
	 * @param posY
	 * @param headFaced
	 */
	public Rover(int posX, int posY, char headFaced) {
		this.posX = posX;
		this.posY = posY;
		this.headFaced = headFaced;
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

	@Override
	public String toString() {
		return "Rover [posX=" + posX + ", posY=" + posY + ", headFaced=" + headFaced + "]";
	}
	
}
