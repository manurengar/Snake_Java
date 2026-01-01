package mrg.strada.game;

import java.util.Random;

public class Snake extends Item implements SnakeItemMovable {
	private int width;
	private int height;
	private Player player;

	Snake(int height, int width, Player player) {
		this.height = height;
		this.width = width;
		this.player = player;
	}

	@Override
	protected int[] setItemPosition(int height, int width) {
		// Choose from these positions
		if (!this.itemInitialized) {
			Random rand = new Random();

			currentPosition[0] = rand.nextInt(height);
			currentPosition[0] = currentPosition[0] == 0 ? 1 : 
				                 (currentPosition[0] == (height - 1) ? (height - 2) : currentPosition[0]);

			currentPosition[1] = rand.nextInt(width);
			currentPosition[1] = currentPosition[1] == 0 ? 1 : currentPosition[1];
			
			this.itemInitialized = true;
			return currentPosition;
			
		} else {
			return this.calculateNextMove();
		}
	}

	private int[] calculateNextMove() {
		int[] playerCoordinates = player.getCurrentPosition();
		int[] snakeCoordinates = this.getCurrentPosition();

		int[] calculatedCoordinates = { playerCoordinates[0] - snakeCoordinates[0],
				playerCoordinates[1] - snakeCoordinates[1] };
		// Normalize coordinates
		calculatedCoordinates[0] = calculatedCoordinates[0] / Math.abs(calculatedCoordinates[0]);
		calculatedCoordinates[1] = calculatedCoordinates[1] / Math.abs(calculatedCoordinates[1]);

		this.moveItem(calculatedCoordinates[1], calculatedCoordinates[0]);
		return this.getCurrentPosition();
	}

	@Override
	public void moveItem(int x, int y) {
		if (x == 0 || y == 0) {
			throw new IllegalArgumentException("Snake must move diagonally");
		}

		if (this.currentPosition[0] + y > 0 && this.currentPosition[0] + y < height) {
			this.currentPosition[0] += y;
		}
		if (this.currentPosition[1] + x > 0 && this.currentPosition[1] + x < width) {
			this.currentPosition[1] += x;
		}
	}
}
