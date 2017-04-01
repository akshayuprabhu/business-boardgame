package com.it306.test.UI;

/**
 * The main board layout of the game. The box is not resizable to
 * avoid distortion.
 * 
 * @author Amith Kini
 */

import com.it306.test.*;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class Board {

	public JFrame frame;
	private ArrayList<JLabel> cells = new ArrayList<JLabel>();
	public ArrayList<Object> cellList = new ArrayList<Object>();
	public JLabel p0;
	public JLabel p1;
	public JLabel p2;
	public JLabel p3;

	/**
	 * Create the application.
	 */
	public Board(ArrayList<String> plrs) {
		initialize(plrs);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<String> plrs) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 910, 930);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = (JPanel)frame.getContentPane();
		frame.getContentPane().setLayout(null);
		
		// The "GO" label
		JLabel label = new JLabel("");
		label.setBounds(785, 779, 119, 116);
		frame.getContentPane().add(label);
		cells.add(label);
		label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				GOCell x = (GOCell) cellList.get(0);
				@SuppressWarnings("unused")
				PropertyInfo disp = new PropertyInfo(x);
			}
		});
		
		int arg0 = 709;
		
		for (int i = 0; i < 9; i++) {
			JLabel x = new JLabel();
			x.setBounds(arg0, 779, 74, 116);
			frame.getContentPane().add(x);
			cells.add(x);
			arg0 = arg0 - 74;
		}
		// The "Just visiting" label
		JLabel label_10 = new JLabel("");
		label_10.setBounds(0, 779, 119, 116);
		frame.getContentPane().add(label_10);
		cells.add(label_10);
		
		int arg1 = 707;
		
		for (int i = 0; i < 9; i++) {
			JLabel x = new JLabel();
			x.setBounds(0, arg1, 119, 71);
			frame.getContentPane().add(x);
			cells.add(x);
			arg1 = arg1 - 74;
		}
		
		
		// The "Free parking" label
		JLabel label_20 = new JLabel("");
		label_20.setBounds(0, 0, 119, 116);
		frame.getContentPane().add(label_20);
		cells.add(label_20);
		
		int arg2 = 118;
		
		for (int i = 0; i < 9; i++) {
			JLabel x = new JLabel();
			x.setBounds(arg2, 0, 74, 116);
			frame.getContentPane().add(x);
			cells.add(x);
			arg2 = arg2 + 74;
		}
		
		// The "Jail" label
		JLabel label_30 = new JLabel("");
		label_30.setBounds(785, 0, 119, 116);
		frame.getContentPane().add(label_30);
		cells.add(label_30);

		int arg3 = 117;
		
		for (int i = 0; i < 9; i++) {
			JLabel x = new JLabel();
			x.setBounds(785, arg3, 119, 71);
			frame.getContentPane().add(x);
			cells.add(x);
			arg3 = arg3 + 74;
		}
		
		// Player 1
		p0 = new JLabel("1");
		p0.setOpaque(true);
		p0.setBackground(Color.RED);
		p0.setBounds(817, 829, 20, 20);
		frame.getContentPane().add(p0);
		
		// Player 2
		p1 = new JLabel("2");
		p1.setBackground(Color.BLUE);
		p1.setOpaque(true);
		p1.setBounds(817, 862, 20, 20);
		frame.getContentPane().add(p1);
		
		// Player 3
		p2 = new JLabel("3");
		p2.setOpaque(true);
		p2.setBackground(Color.GREEN);
		p2.setBounds(849, 829, 20, 20);
		frame.getContentPane().add(p2);
		if (plrs.size() < 3) {
			p2.setVisible(false);
		}
		
		// Player 4
		p3 = new JLabel("4");
		p3.setBackground(Color.YELLOW);
		p3.setOpaque(true);
		p3.setBounds(849, 862, 20, 20);
		frame.getContentPane().add(p3);
		if (plrs.size() < 4) {
			p3.setVisible(false);
		}
		
		JLabel bgLbl = new JLabel();
		bgLbl.setBounds(0, 0, 904, 895);
		bgLbl.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(Board.class.getResource("/media/background.jpg"))));
		panel.add(bgLbl);
		frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	public void setPlayerPos(int pos, Player plr) {
		JLabel pLabel = plr.lbl;
		JLabel cell = cells.get(pos);
		int index = plr.getIndex();
		int mpy = cell.getHeight() / 2;
		int mpx = cell.getWidth() / 2;
		int x = cell.getX();
		int y = cell.getY();
		
		int x_new = x + mpx;
		int y_new = y + mpy;
		
		if (index == 0) {
			pLabel.setBounds(x_new-20, y_new-20, 20, 20);
		}
		else if (index == 1) {
			pLabel.setBounds(x_new-20, y_new, 20, 20);
		}
		else if (index == 2) {
			pLabel.setBounds(x_new, y_new-20, 20, 20);
		}
		else {
			pLabel.setBounds(x_new, y_new, 20, 20);
		}
	}
	
}
