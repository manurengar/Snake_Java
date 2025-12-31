package mrg.strada.game;

import java.util.Random;
import java.util.Scanner;

public class Player extends Item implements SnakeItemMovable {
	private int width;
	private int height;

	Player(int height, int width) {
		this.height = height;
		this.width = width;
	}

	@Override
	protected int[] setItemPosition(int height, int width) {
		// Choose from these positions
		if (!this.itemInitialized) {
			Random rand = new Random();

			currentPosition[0] = rand.nextInt(height);
			currentPosition[0] = currentPosition[0] == 0 ? 1 : currentPosition[0];

			currentPosition[1] = rand.nextInt(width);
			currentPosition[1] = currentPosition[1] == 0 ? 1 : currentPosition[1];

			return currentPosition;
		} else {
			Scanner scn = new Scanner(System.in);

			System.out.println("Use W,A,S,D to move the character.");
			System.out.print("Input?: ");
			char movement = scn.next().charAt(0);

			switch (Character.toUpperCase(movement)) {
			case 'W':
				this.moveItem(0, 1);
				break;
			case 'S':
				this.moveItem(0, -1);
				break;
			case 'A':
				this.moveItem(-1, 0);
				break;
			case 'D':
				this.moveItem(1, 0);
				break;
			default:
				scn.close();
				throw new IllegalArgumentException("Invalid movement key");
			}
			scn.close();
			return this.getCurrentPosition();
		}
	}

	@Override
	public void moveItem(int x, int y) {
		if (Math.abs(x) == Math.abs(y)) {
			throw new IllegalArgumentException("Player cannot move diagonally");
		}

		if (this.currentPosition[0] + y > 0 && this.currentPosition[0] + y < height) {
			this.currentPosition[0] += y;
		}
		if (this.currentPosition[1] + x > 0 && this.currentPosition[1] + x < width) {
			this.currentPosition[1] += x;
		}
	}
}
