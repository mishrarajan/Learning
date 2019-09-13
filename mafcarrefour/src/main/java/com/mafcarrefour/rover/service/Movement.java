package com.mafcarrefour.rover.service;

public enum Movement {
LEFT('L', -1), RIGHT('R', 1), MOVE_NEXT('M',0);
	private char name;
	private int move;
	private Movement(char name, int move) {
		this.name = name;
		this.move = move;
	}
	public char getName() {
		return name;
	}
	public int getMove() {
		return move;
	}
}
