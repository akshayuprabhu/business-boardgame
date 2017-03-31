package com.it306.test.UI;

/**
 * The dialog box which shows the options for the players during
 * their turn. If the player is in jail, they can pay the bail.
 * 
 * @author Amith Kini
 */


import com.it306.test.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PlayerChoices {

	private JFrame frame;
	private JButton btnPlay = new JButton();
	private JButton btnEndTurn = new JButton();
	private JButton btnTrade = new JButton();
	private JButton btnPayBail = new JButton();
	private JButton btnPickCard = new JButton();
	private JButton btnBuyProperty = new JButton();
	private GameMaster gameMaster;
	private boolean turnStarted = false;
//	private boolean pickedCard = false;
	
	/**
	 * Create the application.
	 */
	public PlayerChoices(GameMaster gameMaster) {
		this.gameMaster = gameMaster;
		Player plr = gameMaster.getCurrentPlayer();
		initialize(plr);
		btnEnablers(plr);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Player plr) {
		frame = new JFrame();
		frame.setBounds(100, 100, 357, 341);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnPlay = new JButton("Roll the dice");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Integer> value = plr.rollDice();
				String msg = "You rolled ";
				msg = msg + String.valueOf(value.get(0)) + " and " + String.valueOf(value.get(1));
				JOptionPane.showMessageDialog(null, msg,
						"Message", JOptionPane.INFORMATION_MESSAGE);				
				int pos = plr.getPosition();
				if (plr.isInJail()) {
					if (value.get(3) == 1) {
						JOptionPane.showMessageDialog(null, "You are out of Jail!",
								"Message", JOptionPane.INFORMATION_MESSAGE);
						int new_pos = pos + value.get(2);
						gameMaster.movePlayer(new_pos);
					}
					else {
						JOptionPane.showMessageDialog(null, "You are stuck in Jail!",
								"Message", JOptionPane.INFORMATION_MESSAGE);
						endTurn();
					}
				}
				else {
					int new_pos = pos + value.get(2);
					gameMaster.movePlayer(new_pos);
					btnPlay.setEnabled(false);
					
				}
			}
		});
		btnPlay.setBounds(31, 60, 106, 55);
		frame.getContentPane().add(btnPlay);
		
		JButton btnEndTurn = new JButton("End turn");
		btnEndTurn.setEnabled(false);
		btnEndTurn.setBounds(201, 60, 106, 55);
		frame.getContentPane().add(btnEndTurn);
		
		JButton btnTrade = new JButton("Trade");
		btnTrade.setEnabled(false);
		btnTrade.setBounds(31, 138, 106, 55);
		frame.getContentPane().add(btnTrade);
		
		JButton btnPayBail = new JButton("Pay Bail");
		btnPayBail.setEnabled(false);
		btnPayBail.setBounds(201, 138, 106, 55);
		frame.getContentPane().add(btnPayBail);
		
		JButton btnPickCard = new JButton("Pick a Card");
		btnPickCard.setEnabled(false);
		btnPickCard.setBounds(31, 219, 106, 55);
		frame.getContentPane().add(btnPickCard);
		
		JButton btnBuyProperty = new JButton("Buy Property");
		btnBuyProperty.setEnabled(false);
		btnBuyProperty.setBounds(201, 219, 106, 55);
		frame.getContentPane().add(btnBuyProperty);
		
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPlayer.setBounds(31, 13, 57, 26);
		frame.getContentPane().add(lblPlayer);
		
		JLabel label = new JLabel(plr.getName());
		label.setBounds(116, 13, 166, 26);
		frame.getContentPane().add(label);
	}
	
	private void endTurn() {
		btnEndTurn.setEnabled(true);
		btnTrade.setEnabled(false);
		btnBuyProperty.setEnabled(false);
		btnPickCard.setEnabled(false);
		btnPlay.setEnabled(false);
		btnPayBail.setEnabled(false);
	}
	
	private void btnEnablers(Player plr) {
		if (!turnStarted) {
			btnPlay.setEnabled(true);
			btnEndTurn.setEnabled(false);
			btnTrade.setEnabled(false);
			btnPayBail.setEnabled(false);
			btnPickCard.setEnabled(false);
			btnBuyProperty.setEnabled(false);
		}
		// A condition to check if the property is buyable
		//else if (){}
		//Add a condition to check if the player is on a chance block or 
		//community chest block. Or any other thing which is not buyable.

		else {
			btnPlay.setEnabled(false);
			btnEndTurn.setEnabled(true);
			btnTrade.setEnabled(true);
			btnPickCard.setEnabled(true);
			btnBuyProperty.setEnabled(true);
			if (plr.isInJail()) {
				btnPayBail.setEnabled(true);
				btnPickCard.setEnabled(false);
				btnBuyProperty.setEnabled(false);
			}
			else {
				btnPayBail.setEnabled(false);
			}			
		}
	}
}
