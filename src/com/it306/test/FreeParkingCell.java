package com.it306.test;

public class FreeParkingCell extends Cell {

	public FreeParkingCell(int pos) {
		setPosition(pos);
		setName("Free Parking");
		setBuyable(false);
		setColourGroup("None");
	}
	
}
