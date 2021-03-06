package com.it306.test;

/**
 * This is the class that contains the information of the player
 * @author Amith Kini
 *
 */

//import com.it306.test.UI.*;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Player {
	
	public JLabel lbl;
	private String name;
	private int index;
	private int colour;
	private int money = 0;
	private int position = 0;
	private boolean inJail = false;
	private boolean isOut = false;
	private ArrayList<Property> properties = new ArrayList<Property>();
	public int lastRollValue = 0;
	
	public Player(JLabel x){
		this.lbl = x;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the colour
	 */
	public int getColour() {
		return colour;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * @param colour the colour to set
	 */
	public void setColour(int colour) {
		this.colour = colour;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money : the money to be added
	 * This method adds the money to the player
	 */
	public void addMoney(int add) {
		this.money = this.money + add;
	}
	
	/**
	 * @param money : the money to be subtracted
	 * This method subtracts the money from the player
	 */
	public int subMoney(int sub) {
		if (sub < this.money) {
			//TODO Add a GUI or something here.
			return 1;
		}
		this.money = this.money - sub;
		return 0;
	}
	

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * @return the inJail
	 */
	public boolean isInJail() {
		return inJail;
	}

	/**
	 * @param inJail the inJail to set
	 */
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	/**
	 * @return the isOut
	 */
	public boolean getIsOut() {
		return isOut;
	}

	/**
	 * @param isOut the isOut to set
	 */
	public void setOut(boolean isOut) {
		this.isOut = isOut;
	}
	
	public void addProperty(Property a) {
		if (properties.contains(a)) {
			//Display a message to show that he already has this property.
		}
		else if (a.getValue() > money) {
			//Display a message to show that he has insufficient funds.
		}
		else if (!a.getOwner().equals("Bank")){
			Player other = a.getPowner();
			String name = other.getName();
			System.out.println(name);
			//Display the name of the player it belongs to.
		}
	}
	
	public ArrayList<Integer> rollDice() {
		Dice die = new Dice();
		int a = die.roll();
		int b = die.roll();
		int value = a + b;
		ArrayList<Integer> dice = new ArrayList<Integer>();
		dice.add(a);
		dice.add(b);
		dice.add(value);
		lastRollValue = value;
		if (a == b) {
			dice.add(1);
		}
		else {
			dice.add(0);
		}
		return dice;
	}
	
}
