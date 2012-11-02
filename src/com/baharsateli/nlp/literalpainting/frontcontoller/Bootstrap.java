package com.baharsateli.nlp.literalpainting.frontcontoller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class Bootstrap extends JFrame{

	private static final long serialVersionUID = 5580007593569303969L;
	
	/** Menu for more information*/
	private JMenuBar  menuBar = new JMenuBar();
	
	public Bootstrap(){
		setTitle("Literal Painting - Natural Language Interface to 2D Painting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	private static String text = "B";
	
	public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString(text, 50, 50);
        g2d.drawLine(10, 10, 30, 30);
        g2d.drawOval(50, 50, 50, 25);
        g2d.drawArc(100, 100, 130, 30, 25, 87);
    }
	
	private void initGUI(){
		setBackground(Color.LIGHT_GRAY);
		//setDefaultLookAndFeelDecorated(true);
		
		pack();
		setSize(800, 600);
		JMenu about = new JMenu("About");
		menuBar.add(about);
		setJMenuBar(menuBar);
		setLayout(null);
		
		Container content = getContentPane();
		
        JPanel commandPanel = new JPanel();
        commandPanel.setLayout(null);
        commandPanel.setBackground(Color.PINK);
        commandPanel.setBounds(0, 0, 800, 50);

        //BorderLayout borderlayout = new BorderLayout();
        //commandPanel.setLayout(borderlayout);

        JLabel commandLabel = new JLabel("Command: ");
        commandLabel.setBounds(10, 10, 80, 30);
        commandPanel.add(commandLabel);
        JTextField commandTextField = new JTextField();
        commandTextField.setBounds(90, 10, 600, 30);
        commandPanel.add(commandTextField);
        JButton clearBtn = new JButton("clear");
        clearBtn.setBounds(690, 10, 90, 30);
        commandPanel.add(clearBtn);
        
        JPanel responsePanel = new JPanel();
        responsePanel.setLayout(null);
        responsePanel.setBackground(Color.YELLOW);
        responsePanel.setBounds(0, 50, 800, 50);

        JLabel responseLabel = new JLabel("Response: ");
        responseLabel.setBounds(10, 10, 80, 30);
        responsePanel.add(responseLabel);
        JLabel responseValue = new JLabel("OK!");
        responseValue.setBounds(90, 10, 400, 30);
        responsePanel.add(responseValue);
        content.add(commandPanel);
        content.add(responsePanel);
        
/*        JPanel drawingPanel = new JPanel();
        drawingPanel.setBounds(0, 100, 800, 500);
        drawingPanel.setBackground(Color.CYAN);
        content.add(drawingPanel);*/
		setVisible(true); 
	}
	
	/*public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bootstrap frame = new Bootstrap();
					frame.initGUI();
					frame.add(new Bootstrap());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

}
