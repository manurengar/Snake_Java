package mrg.strada.game;

import java.util.Random;

public class Door extends Item {

	@Override
	protected int[] setItemPosition(int height, int width) {
		int[] alternativeDoorPositions = { 0, width };

		// Choose from these positions
		if (!this.itemInitialized) {
			Random rand = new Random();

			currentPosition[0] = rand.nextInt(height + 1);
			if (currentPosition[0] == 0 || currentPosition[0] == height) {
				currentPosition[1] = rand.nextInt(width);
			} else {
				currentPosition[1] = alternativeDoorPositions[rand.nextInt(2)];
			}

			return currentPosition;
		} else {
			return this.getCurrentPosition();
		}

	}
}
