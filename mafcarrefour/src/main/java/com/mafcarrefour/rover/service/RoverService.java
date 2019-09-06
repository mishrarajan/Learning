package com.mafcarrefour.rover.service;

import com.mafcarrefour.rover.entity.Rover;

public interface RoverService {
	public Rover moveRobo(Rover rover, String movePlan);
}
