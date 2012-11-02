package com.baharsateli.nlp.literalpainting.command;

/**
 * Command abstract class to be extended by concrete instances.
 * @author Bahar Sateli
 * */
public abstract class Command {

	public abstract void execute(int xStart, int yStart, int xEnd, int yEnd, int width, int height, String color);
}
