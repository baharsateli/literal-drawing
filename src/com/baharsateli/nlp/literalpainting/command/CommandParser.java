package com.baharsateli.nlp.literalpainting.command;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CommandParser {
	
	private final static String scriptLocation = System.getProperty("user.home") + "/LiteralPainting/commandParser.py";
	private final static String pythonCommand = "python2.7";

	public static synchronized String execute(final String argument){
        String output = "";
		try 
		{
            Runtime rt = Runtime.getRuntime();
            //System.out.println(pythonCommand + " " + scriptLocation + " " + argument);
            Process pr = rt.exec(pythonCommand + " " + scriptLocation + " " + argument);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line=null;

            while((line=input.readLine()) != null) 
            {
                output += line;
            	//System.out.println(line);
            }

            int exitVal = pr.waitFor();
            //System.out.println("Exited with error code "+ exitVal);
            if(exitVal == 0){
            	return output;
            }else if(exitVal == 1){
        		return "ERROR";
            }
            
        } 
		catch(Exception e) 
		{
            System.out.println(e.toString());
            e.printStackTrace();
        }
		System.out.println("SYSTEM ERROR");
		return "SYSTEM ERROR";

	}
}
