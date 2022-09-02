package outils;

import java.util.Scanner;

public class ActionInput extends Thread {
	private static Scanner keyboard = new Scanner(System.in);
	private String input;
	
	public void run() {
		input = null;
		input = keyboard.nextLine();
	}
	
	public String getInput() {
		return input;
	}
}
