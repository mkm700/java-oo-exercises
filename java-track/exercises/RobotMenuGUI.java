import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class RobotMenuGUI {

	private JFrame frmMyRobotMenu;
	private DefaultListModel<Robot> listModel;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotMenuGUI window = new RobotMenuGUI();
					window.frmMyRobotMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotMenuGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyRobotMenu = new JFrame("Welcome to Robots R Us");
		frmMyRobotMenu.setBounds(100, 100, 450, 300);
		frmMyRobotMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyRobotMenu.getContentPane().setLayout(null);
		
		listModel = new DefaultListModel<Robot>();
		
		//create robot
		JButton btnCreateRobot = new JButton("Create Robot");
		btnCreateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = (String)JOptionPane.showInputDialog(frmMyRobotMenu, "What is the robot's name?", "Robot Name", JOptionPane.PLAIN_MESSAGE, null, null, "");
				String sx = (String)JOptionPane.showInputDialog(frmMyRobotMenu, "Enter X coordinate", "X Coordinate", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int x = Integer.parseInt(sx);
				String sy = (String)JOptionPane.showInputDialog(frmMyRobotMenu, "Enter Y coordinate", "Y Coordinate", JOptionPane.PLAIN_MESSAGE, null, null, "");	
				int y = Integer.parseInt(sy);
				int speed = (int)getPositiveValue("Enter speed", "Speed");
				String direction = getDirection("Select a direction", "Direction");
				Robot r = new Robot(name, x, y, speed, direction);
				int size = listModel.size();
				listModel.add(size, r);
				//select the newly added Robot in the list
				list.setSelectedIndex(size);
			}
		});
		btnCreateRobot.setBounds(6, 6, 134, 36);
		frmMyRobotMenu.getContentPane().add(btnCreateRobot);
		
		
		//move robot
		JButton btnMoveRobot = new JButton("Move Robot");
		btnMoveRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				//TODO: check for only 1 selection
				String sdist = (String)JOptionPane.showInputDialog(frmMyRobotMenu, "How far would you like to move the robot?", "Move", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int dist = Integer.parseInt(sdist);		
				listModel.getElementAt(selected).moveRobot(dist);
			}			
		});
		btnMoveRobot.setBounds(6, 56, 134, 36);
		frmMyRobotMenu.getContentPane().add(btnMoveRobot);
		
		
		//rotate robot
		JButton btnRotateRobot = new JButton("Rotate Robot");
		btnRotateRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				Object[] possibilities = {"Left", "Right"};
				String newDir = (String)JOptionPane.showInputDialog(frmMyRobotMenu, 
													"Move Left or Right?", 
													"Rotate", 
													JOptionPane.PLAIN_MESSAGE, 
													null, 
													possibilities,
													"Left");
				listModel.getElementAt(selected).rotateRobot(newDir);
			}
		});
		btnRotateRobot.setBounds(6, 106, 134, 36);
		frmMyRobotMenu.getContentPane().add(btnRotateRobot);
		
		
		//calculate distance
		JButton btnCalcDistance = new JButton("Calculate Distance");
		btnCalcDistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selected = list.getSelectedIndices();
				//TODO: check for exactly 2 selections
				
				//get name and coordinates for first selection
				String name1 = listModel.get(selected[0]).getName();
				int x1 = listModel.get(selected[0]).getPosX();  
				int y1 = listModel.get(selected[0]).getPosY();
				//get name and coordinates for second selection
				String name2 = listModel.get(selected[1]).getName();
				int x2 = listModel.get(selected[1]).getPosX();	
				int y2 = listModel.get(selected[1]).getPosY();

				//calc distance
				double distance = listModel.getElementAt(selected[0]).calcDistance(x1, y1, x2, y2);	
				//display a message with the distance
				String message = "The distance between " + name1 + "\nand " + name2 + " is " + distance + ".";
				JOptionPane.showMessageDialog(frmMyRobotMenu, message, "Calculate Distance", JOptionPane.INFORMATION_MESSAGE);		
			}
		});
		btnCalcDistance.setBounds(6, 156, 134, 36);
		frmMyRobotMenu.getContentPane().add(btnCalcDistance);
		
		
		//Quit
		JButton btnQuit = new JButton("Quit");	
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        System.exit(0);							
			}
		});
		btnQuit.setBounds(6, 206, 134, 36);
		frmMyRobotMenu.getContentPane().add(btnQuit);
	
		
		//list of Robots
		list = new JList(listModel);
		list.setBounds(152, 39, 292, 176);
		frmMyRobotMenu.getContentPane().add(list);


	}
	
	private double getPositiveValue(String prompt, String title) {
		String s = (String)JOptionPane.showInputDialog(
				frmMyRobotMenu, 
				prompt, 
				title, 
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"");
		
		Double sint = Double.parseDouble(s);
		while (sint < 0) {
			s = (String)JOptionPane.showInputDialog(
					frmMyRobotMenu, 
					prompt + " (Please enter a positive value)", 
					title, 
					JOptionPane.PLAIN_MESSAGE,
					null,
					null,
					"");
			sint = Double.parseDouble(s);
		}
		return sint;		
	}
	
	private String getDirection(String prompt, String title) {
		Object[] possibilities = {"North", "East", "South", "West"};
		String s = (String)JOptionPane.showInputDialog(
				frmMyRobotMenu, 
				prompt, 
				title, 
				JOptionPane.PLAIN_MESSAGE,
				null,
				possibilities,
				"North");
		return s;
		
			
	}
	
}
