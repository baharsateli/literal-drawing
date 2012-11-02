package com.baharsateli.nlp.literalpainting.frontcontoller;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JPanel {

	private static final long serialVersionUID = 1L;
	private static String text = "B";

	public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString(text, 50, 50);
        g2d.drawLine(10, 400, 30, 30);
        g2d.drawOval(50, 400, 50, 25);
        g2d.drawArc(100, 500, 130, 30, 25, 87);
    }
	
	public static void draw(){
		//CommandParser.execute("Hello");
        JFrame frame = new JFrame("Literal Painting -- Natural Language Interface to 2D Painting");
        //frame.add(new Main());
    /*    Container content = frame.getContentPane();

        JPanel commandPanel = new JPanel(new BorderLayout());
        
        GridLayout gridLayout = new GridLayout(3,0);
        gridLayout.setVgap(30);
        
        JTextField commandTextField = new JTextField();        
        JLabel commandLabel = new JLabel("Command: ");
        commandLabel.setLabelFor(commandTextField);

        commandPanel.add(commandLabel, BorderLayout.WEST);
        commandPanel.add(commandTextField, BorderLayout.CENTER);    
        
        JLabel responseLabel = new JLabel("Response: ");
        JLabel responseValue = new JLabel();
        commandPanel.add(responseLabel, BorderLayout.WEST);
        commandPanel.add(responseValue, BorderLayout.CENTER);   
        
        content.add(commandPanel, BorderLayout.NORTH);        
        
        JPanel drawingPanel = new JPanel(new BorderLayout());
        content.add(drawingPanel, BorderLayout.SOUTH);        
        


        text = "Hasan";
        content.add(new Main());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);*/
        frame.setBackground(Color.LIGHT_GRAY);
		//setDefaultLookAndFeelDecorated(true);
		
        frame.pack();
        frame.setSize(800, 600);
		JMenu about = new JMenu("About");
		JMenuBar  menuBar = new JMenuBar();
		menuBar.add(about);
		frame.setJMenuBar(menuBar);
		frame.setLayout(null);
		
		Container content = frame.getContentPane();
		
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
        
        //content.add(new Main());
        

/*        JPanel drawingPanel = new JPanel();
        drawingPanel.setBounds(0, 100, 800, 500);
        drawingPanel.setBackground(Color.CYAN);
        content.add(drawingPanel);*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); 
	}


/*    public static void main(String[] args) {
    	draw();
    }*/
    
    public class Can extends Canvas {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
        public void paint(Graphics g) {

        }
    }
}