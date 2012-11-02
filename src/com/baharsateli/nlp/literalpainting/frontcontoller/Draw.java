package com.baharsateli.nlp.literalpainting.frontcontoller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.baharsateli.nlp.literalpainting.command.Command;
import com.baharsateli.nlp.literalpainting.command.CommandFactory;
import com.baharsateli.nlp.literalpainting.command.CommandParser;
import com.baharsateli.nlp.literalpainting.graphics.DrawingCanvas;

enum Colors {green};

public class Draw {

	JFrame frame = new JFrame("Literal Painting -- Natural Language Interface to 2D Painting");
    private static DrawingCanvas canvas = new DrawingCanvas();
    JTextField commandTextField = new JTextField();
    JLabel responseValue = new JLabel();
    String output;
    
    int x = 10;
    int y = 10;
    int width = 30;
    int height = 50;

	public void disp() {
	    frame.setSize(800, 680);
	    frame.setResizable(false);
        frame.setBackground(Color.LIGHT_GRAY);
        JMenu canvasMenu = new JMenu("Canvas");
        JMenu about = new JMenu("About");
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(canvasMenu);
		menuBar.add(about);
		frame.setJMenuBar(menuBar);
		frame.setLayout(null);
		
	    MosL ml = new MosL();

	    JPanel commandPanel = new JPanel();
        commandPanel.setLayout(null);
        //commandPanel.setBackground(new Color(27, 13, 71));
        commandPanel.setBackground(new Color(22, 6, 7));
        commandPanel.setBounds(0, 0, 800, 50);
        
        ImageIcon head = new ImageIcon(System.getProperty("user.home") + "/LiteralPainting/header.png");
        JLabel lblhead = new JLabel(head);
        lblhead.setBounds(0, 0, 800, 5);
        commandPanel.add(lblhead);
   
        JLabel commandLabel = new JLabel("Command: ");
        commandLabel.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        commandLabel.setForeground(new Color(255,159,65));
        commandLabel.setBounds(10, 15, 80, 30);
        commandPanel.add(commandLabel);
        commandTextField.setBounds(90, 15, 500, 30);
        commandPanel.add(commandTextField);
        
        JButton runBtn = new JButton("run");
        runBtn.setBounds(690, 10, 90, 30);
        runBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Runnable executeCommand = new Runnable() {
					@Override
					public void run() {
						//responseValue.setText(commandTextField.getText());
						String commandString = commandTextField.getText().trim();
						if(commandString.length() == 0){
							handleOutput("Command cannot be empty");
						}else{
							output = CommandParser.execute(commandString);
							System.out.println(output);
							handleOutput(output);
						}
					}
				};
				executeCommand.run();
			}
		});
        commandPanel.add(runBtn);
        frame.add(commandPanel);
        
        JButton clearBtn = new JButton("clear");
        clearBtn.setBounds(600, 10, 90, 30);
        clearBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				commandTextField.setText("");
			}
		});
        commandPanel.add(clearBtn);
        frame.add(commandPanel);
        
        JPanel responsePanel = new JPanel();
        responsePanel.setLayout(null);
        //responsePanel.setBackground(new Color(27, 13, 71));
        responsePanel.setBackground(new Color(22, 6, 7));
        responsePanel.setBounds(0, 50, 800, 50);

        JLabel responseLabel = new JLabel("Response: ");
        responseLabel.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        responseLabel.setForeground(new Color(255,159,65));
        responseLabel.setBounds(10, 10, 80, 30);
        responsePanel.add(responseLabel);
        responseValue.setForeground(Color.WHITE);
        responseValue.setBounds(90, 10, 400, 30);
        responsePanel.add(responseValue);
        frame.add(responsePanel);
        
        JPanel drawingPanel = new JPanel();
        drawingPanel.setLayout(null);
        drawingPanel.setBounds(0, 100, 800, 700);
        ImageIcon top = new ImageIcon(System.getProperty("user.home") + "/LiteralPainting/top1.png");
        JLabel lblTop = new JLabel(top);
        lblTop.setBounds(0, 0, 800, 42);
        drawingPanel.add(lblTop);
        
        ImageIcon left = new ImageIcon(System.getProperty("user.home") + "/LiteralPainting/left1.png");
        JLabel lblleft = new JLabel(left);
        lblleft.setBounds(0, 42, 81, 452);
        drawingPanel.add(lblleft);
        
        ImageIcon right = new ImageIcon(System.getProperty("user.home") + "/LiteralPainting/right1.png");
        JLabel lblright = new JLabel(right);
        lblright.setBounds(757, 42, 43, 452);
        drawingPanel.add(lblright);
        
        ImageIcon bottom = new ImageIcon(System.getProperty("user.home") + "/LiteralPainting/bottom1.png");
        JLabel lblbottom = new JLabel(bottom);
        lblbottom.setBounds(0, 494, 800, 42);
        drawingPanel.add(lblbottom);

        canvas.setBounds(81, 42, 676, 452);
	    //canvas.setBackground(new Color(104, 109, 158));
        canvas.setBackground(new Color(242,242,242));
        drawingPanel.add(canvas);
	    //frame.add(canvas);
        frame.add(drawingPanel);
	    canvas.addMouseListener(ml);
	    canvas.addMouseMotionListener(ml);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    String color = "";
	    drawGrids(color);
	}
	
	public void drawGrids(String color){
		Graphics g = canvas.getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		//g2.setPaint(Color.LIGHT_GRAY);
		g2.setPaint(new Color(22,6,7));
		g2.drawLine(0,0,40,0);
		g2.drawLine(0,0,0,40);
		g2.drawLine((canvas.getWidth()-40),0,canvas.getWidth(),0);
		g2.drawLine(canvas.getWidth()-1,0,canvas.getWidth()-1,40);
		g2.drawLine(0,canvas.getHeight()-1,0,canvas.getHeight()-40);
		g2.drawLine(0,canvas.getHeight()-1,40,canvas.getHeight()-1);
		g2.drawLine(canvas.getWidth()-1,canvas.getHeight()-1,canvas.getWidth()-1,canvas.getHeight()-41);
		g2.drawLine(canvas.getWidth()-1,canvas.getHeight()-1,canvas.getWidth()-41,canvas.getHeight()-1);
		g2.drawString("0", 5, 15);
		g2.drawString("600", canvas.getWidth()-30, 15);
		g2.drawString("450", 4, 445);
	}
	
	public void handleOutput(String output){
		if(output.equals("ERROR")){
			responseValue.setText("Sorry, I don't understand your command.");
		}else{
			//responseValue.setText(output);
			responseValue.setText("Ok!");
			executeCommand(output);
		}
	}
	
	public void executeCommand(String output){
		try{
			String color = null;
			int colorStart = output.indexOf("ADJ[COLOR='");
			if(colorStart != -1){
				color = output.substring(colorStart + "ADJ[COLOR='".length());
				int colorEnd = color.indexOf("'");
				color = color.substring(0, colorEnd);
				System.out.println(color);
			}
			
			
			int sentStart = output.indexOf("S[");
			String sent = output.substring(sentStart);
			int sentEnd = sent.indexOf("]");
			sent = sent.substring(0, sentEnd);

			int cmdStart = sent.indexOf("COMMAND='");
			String cmd = sent.substring(cmdStart+"COMMAND='".length());
			
			int cmdEnd = cmd.indexOf("'");
			cmd = cmd.substring(0, cmdEnd);
			System.out.println(cmd);
			
			int shapeStart = sent.indexOf("SHAPE='");
			String shape = sent.substring(shapeStart+"SHAPE='".length());
			
			int shapeEnd = shape.indexOf("'");
			shape = shape.substring(0, shapeEnd);
			System.out.println(shape);
			
			int srcStart = output.indexOf("Card[]");
			String coords = output.substring(srcStart+"Card[]".length());
			System.out.println(coords);
			int tempIndex = coords.indexOf(")");
			String srcX = coords.substring(0,tempIndex).trim();
			System.out.println(srcX);
			
			srcStart = coords.indexOf("Card[]");
			coords = coords.substring(srcStart+"Card[]".length());
			tempIndex = coords.indexOf(")");
			String srcY = coords.substring(0,tempIndex).trim();
			System.out.println(srcY);
			
			srcStart = coords.indexOf("Card[]");
			coords = coords.substring(srcStart+"Card[]".length());
			tempIndex = coords.indexOf(")");
			String dstX = coords.substring(0,tempIndex).trim();
			System.out.println(dstX);
			
			srcStart = coords.indexOf("Card[]");
			coords = coords.substring(srcStart+"Card[]".length());
			tempIndex = coords.indexOf(")");
			String dstY = coords.substring(0,tempIndex).trim();
			System.out.println(dstY);

			Command command = CommandFactory.getCommand(cmd.toLowerCase(), shape.toLowerCase());
			command.execute(Integer.parseInt(srcX), Integer.parseInt(srcY), Integer.parseInt(dstX), Integer.parseInt(dstY), -1, -1, color);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public class MosL extends MouseAdapter {
	    int sx = 0;
	    int sy = 0;
	    boolean onDrag = false;

	    @Override
	    public void mouseDragged(MouseEvent e) {
	        if (onDrag) {
	            int x = e.getX();
	            int y = e.getY();

	            Canvas comp = (Canvas) e.getSource();
	            Graphics g = comp.getGraphics();
	            // comp.repaint(); << for cleaning up the intermediate lines : doesnt work :(
	            g.drawLine(sx, sy, x, y);
	            return;
	        }
	        onDrag = true;
	        sx = e.getX();
	        sy = e.getY();

	        System.out.println("Draggg");
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {
	        System.out.println("Pressed");
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
	        System.out.println("Released");
	        if (onDrag)
	            onDrag = false;
	    }
	}

	public static void main(String[] args) {
	    Draw draw = new Draw();
	    draw.disp();
	}
	
	public void drawRectangle(final int x, final int y, final int width, final int height){
		Graphics g = canvas.getGraphics();
		g.drawRect(x,y,width,height);
	}
	
	public static Canvas getCanvas(){
		return canvas;
	}
}
