package com.mafcarrefour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mafcarrefour.rover.entity.Plateau;
import com.mafcarrefour.rover.entity.Rover;
import com.mafcarrefour.rover.service.Direction;
import com.mafcarrefour.rover.service.RoverService;
import com.mafcarrefour.rover.service.RoverServiceImpl;

public class RoboticRoverTest {
	private Plateau plateau;
	private static RoverService roverService;
	@BeforeClass
	public static void beforeClass() {
		roverService = new RoverServiceImpl();
	}

	@Before
	public void beforeTest() {
		plateau = new Plateau();
		plateau.setMaxX(5);
		plateau.setMaxY(5);
		plateau.setMinX(0);
		plateau.setMinY(0);
	}

	@Test
	public void test() {
		plateau.getRoverList().add(new Rover("Rover-1", 1, 2, Direction.N ,"LMLMLMLMM"));
		
		roverService.moveRoverOnPlateau(plateau);
		
		Rover rover = plateau.getRoverList().get(0);
		Assert.assertEquals(rover.getName()+",X :",rover.getPosX(),1);
		Assert.assertEquals(rover.getName()+",Y :",rover.getPosY(),3);
		Assert.assertEquals(rover.getName()+",Direction :",rover.getDirection(),Direction.N);
	}
	@Test
	public void test1() {
		plateau.getRoverList().add(new Rover("Rover-2", 3, 3, Direction.E,"MMRMMRMRRM"));
		roverService.moveRoverOnPlateau(plateau);
		Rover rover = plateau.getRoverList().get(0);
		Assert.assertEquals(rover.getPosX(),5);
		Assert.assertEquals(rover.getPosY(),1);
		Assert.assertEquals(rover.getDirection(), Direction.E);
	}

}
