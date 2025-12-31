package mrg.strada;

import java.util.Scanner;
import mrg.strada.game.Board;
import mrg.strada.game.Level;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Level diff;
		System.out.println("GOLD, SNAKE, DOOR Game!");
		System.out.println("Select difficulty:");
		System.out.println("NORMAL --> 1");
		System.out.println("HARD --> 2");
		Scanner scn = new Scanner(System.in);
		
		System.out.print("-->");
		int selection = scn.nextInt();
		System.out.println();
		
		switch (selection) {
		case 1:
			diff = Level.NORMAL;
			break;
		case 2:
			diff = Level.HARD;
			break;
		default:
			scn.close();
			throw new IllegalArgumentException("Incorrect difficulty selected");
		}
		scn.close();

		Board game = new Board(diff);
		game.runGame();
	}
}
