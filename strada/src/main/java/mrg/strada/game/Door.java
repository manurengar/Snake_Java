package mrg.strada.game;

import java.util.Random;

public class Door extends Item {

	@Override
	protected int[] setItemPosition(int height, int width) {
		int[] alternativeDoorPositions = { 0, width };

		// Choose from these positions
		if (!this.itemInitialized) {
			Random rand = new Random();
			
			// Door can be at any border either top left right or bottom
			// if on top or bottom, door cannot be on corners
			currentPosition[0] = rand.nextInt(height + 1);
			if (currentPosition[0] == 0 || currentPosition[0] == ( height - 1)) {
				int randomWidthPos = rand.nextInt(width);
				    randomWidthPos	= (randomWidthPos == 0) ? 1 : 
					                  ((randomWidthPos == (width - 1)) ? (width - 2) : randomWidthPos);
				currentPosition[1] = randomWidthPos;
			} else {
				currentPosition[1] = alternativeDoorPositions[rand.nextInt(2)];
			}
			
			this.itemInitialized = true;
			return currentPosition;
		} else {
			return this.getCurrentPosition();
		}

	}
}
