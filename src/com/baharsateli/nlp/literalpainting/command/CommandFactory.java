package com.baharsateli.nlp.literalpainting.command;

enum Commands {draw};

public class CommandFactory {
	
	/** 
	 * Private constructor since it is a utility class.
	 */
	private CommandFactory(){}

	/**
	 * Returns a concrete command object based on the input.
	 * @param command command name retrieved from request
	 * @return Command command object created from the factory
	 * */
	public static Command getCommand(final String command, final String shape){
		switch(Commands.valueOf(command.toLowerCase())){
		case draw:
			return new DrawCommand(shape);
		default:
			return null;
		}
	}

}
