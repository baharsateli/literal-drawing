package com.baharsateli.nlp.literalpainting.command;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.baharsateli.nlp.literalpainting.frontcontoller.Draw;

enum Shapes {line, rectangle};

public class DrawCommand extends Command{
	
	private String shape = "";
	
	public DrawCommand(String iShape){
		shape = iShape;
	}

	@Override
	public void execute(int xStart, int yStart, int xEnd, int yEnd, int width,
			int height, String color) {
		switch(Shapes.valueOf(shape.toLowerCase())){
		case line:
			drawLine(xStart,yStart,xEnd,yEnd, color);
			break;
		case rectangle:
			drawRectangle(xStart,yStart,xEnd,yEnd);
			break;
		default:
		}
	}
	
	private static void drawLine(int xStart, int yStart, int xEnd, int yEnd, String color){
		Graphics g = Draw.getCanvas().getGraphics();
		Graphics2D g2 = (Graphics2D) g;
		System.out.println("*" + color + "*");
		if(color != null){
			if(color == "green"){
				g2.setPaint(Color.GREEN);
			}
		}
		//g2.setPaint(Color.GREEN);
		g2.drawLine(xStart, yStart, xEnd, yEnd);
	}
	
	private static void drawRectangle(int xStart, int yStart, int xEnd, int yEnd){
		Graphics g = Draw.getCanvas().getGraphics();
		g.drawRect(xStart, yStart, xEnd, yEnd);
	}

}
