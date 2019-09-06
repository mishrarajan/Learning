package com.mafcarrefour.rover.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Plateau implements Serializable {
	
	private int maxY;
	private int minX;
	private int maxX;
	private int minY;
	private List<Rover> roverList;
	
	public int getMinX() {
		return minX;
	}
	public void setMinX(int minX) {
		this.minX = minX;
	}
	public int getMinY() {
		return minY;
	}
	public void setMinY(int minY) {
		this.minY = minY;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	public int getMaxX() {
		return maxX;
	}
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public List<Rover> getRoverList() {
		if(roverList==null) {
			roverList = new ArrayList<Rover>();
		}
		return roverList;
	}
	public void setRoverList(List<Rover> roverList) {
		this.roverList = roverList;
	}
	
	
}
