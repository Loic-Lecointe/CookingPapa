package outils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PrintTools {
	public static void clearScreen() {
		for (int i = 0; i < 40; i++) {
			System.out.println();
		}
	}
	
	/**
	 * Method to print a file
	 * @param file
	 */
	public static void printPath(String file) {
		for(String ligne : pathToString(file)) {
			System.out.println(ligne);
		}
	}
	
	public static List<String> pathToString(String file) {
		Path path = Paths.get(System.getProperty("user.dir")+file);
		try {
			return Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
			return null;
		}
	}
}
