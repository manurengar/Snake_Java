package mrg.strada.game;

public abstract class Item implements SnakeGameItem {
	protected int[] currentPosition = { 0, 0 };
	protected boolean itemInitialized = false;

	abstract protected int[] setItemPosition(int height, int width);

	@Override
	public String[] printItem(int height, int width, String[] board, char itemSymbol) {
		int[] itemPosition = this.setItemPosition(height, width);

		StringBuilder itemReplacement = new StringBuilder(board[itemPosition[0]]);
		itemReplacement.setCharAt((itemPosition[1] - 1) < 0 ? 0 : itemPosition[1] - 1, itemSymbol);

		return board;
	}

	@Override
	public double getItemDistance(SnakeGameItem item) {
		int y = this.currentPosition[0] - item.getCurrentPosition()[0];
		int x = this.currentPosition[1] - item.getCurrentPosition()[1];
		return Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2));
	}

	@Override
	public int[] getCurrentPosition() {
		return this.currentPosition;
	}
}
