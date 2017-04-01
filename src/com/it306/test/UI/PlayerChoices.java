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
	public JButton btnPlay = new JButton("Roll the dice");
	public JButton btnEndTurn = new JButton("End turn");
	public JButton btnTrade = new JButton("Trade");
	public JButton btnPayBail = new JButton("Pay Bail");
	public JButton btnPickCard = new JButton("Pick a Card");
	public JButton btnBuyProperty = new JButton("Buy Property");
	private GameMaster gameMaster;
	public boolean turnStarted = false;
//	private boolean pickedCard = false;
	
	/**
	 * Create the application.
	 */
	public PlayerChoices(GameMaster gameMaster) {
		this.gameMaster = gameMaster;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize(Player plr) {
		frame = new JFrame();
		frame.setBounds(100, 100, 357, 341);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		// The play button
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				turnStarted = true;
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
					}
					frame.dispose();
				}
				else {
					int new_pos = pos + value.get(2);
					gameMaster.movePlayer(new_pos);
					btnPlay.setEnabled(false);
				}
				btnEnablers(plr);
			}
		});
		btnPlay.setBounds(31, 60, 106, 55);
		frame.getContentPane().add(btnPlay);
		
		// The End turn button
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnEndTurn.setBounds(201, 60, 106, 55);
		frame.getContentPane().add(btnEndTurn);
		
		// The trade button
		btnTrade.setBounds(31, 138, 106, 55);
		frame.getContentPane().add(btnTrade);
		
		// The Pay Bail button
		btnPayBail.setBounds(201, 138, 106, 55);
		frame.getContentPane().add(btnPayBail);
		
		// The Pick Card
		btnPickCard.setBounds(31, 219, 106, 55);
		frame.getContentPane().add(btnPickCard);
		
		//The Buy Property button
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
	
	public void btnEnablers(Player plr) {
		if (turnStarted == false) {
			btnPlay.setEnabled(true);
			btnEndTurn.setEnabled(false);
			btnTrade.setEnabled(false);
			if (plr.isInJail()) {
				btnPayBail.setEnabled(true);
			}
			else {
				btnPayBail.setEnabled(false);
			}
			btnPickCard.setEnabled(false);
			btnBuyProperty.setEnabled(false);
		}

		else {
			btnPlay.setEnabled(false);
			btnEndTurn.setEnabled(true);
			btnTrade.setEnabled(true);
//			Cell x = (Cell) gameMaster.cellList.get(plr.getPosition());
//			if (x.isBuyable()) {
//				btnBuyProperty.setEnabled(true);
//			}
//			else {
//				btnBuyProperty.setEnabled(false);
//			}
//			if (x.isChance() || x.isCommunity_chest()) {
//				btnPickCard.setEnabled(true);
//			}
			btnPayBail.setEnabled(false);
		}
	}
	
}
