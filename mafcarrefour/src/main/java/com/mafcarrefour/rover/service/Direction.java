package com.mafcarrefour.rover.service;

public enum Direction {
	N(0,"North",'Y', 1), E(1,"East",'X',1), S(2,"South",'Y',-1), W(3,"West",'X',-1);
	private int index;
	private String value;
	private char axis;
	private int moveNext;

	Direction(int index,String value, char axis, int moveNext) {
		this.index = index;
		this.value = value;
		this.axis = axis;
		this.moveNext = moveNext;
	}
	public int getIndex() {
		return this.index;
	}
	public String getText() {
		return this.value;
	}
	public char getAxis() {
		return this.axis;
	}
	public int getMoveNext() {
		return this.moveNext;
	}
}
