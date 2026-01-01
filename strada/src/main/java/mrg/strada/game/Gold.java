package mrg.strada.game;

import java.util.Random;

public class Gold extends Item {
	private boolean isTaken = false;

	@Override
	protected int[] setItemPosition(int height, int width) {
		// Choose from these positions
		if (!this.itemInitialized) {
			Random rand = new Random();

			currentPosition[0] = rand.nextInt(height);
			currentPosition[0] = currentPosition[0] == 0 ? 1 : currentPosition[0];

			currentPosition[1] = rand.nextInt(width - 1);
			currentPosition[1] = currentPosition[1] == 0 ? 1 : currentPosition[1];
			
			this.itemInitialized = true;
			
			return currentPosition;
		} else {
			return this.getCurrentPosition();
		}

	}

	public boolean isTaken() {
		return this.isTaken;
	}

	public void checkIfTaken(Item player) {
		if (this.getItemDistance(player) == 0) {
			this.isTaken = true;
		}
	}
}