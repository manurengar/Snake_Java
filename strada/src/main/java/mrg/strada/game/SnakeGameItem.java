package mrg.strada.game;

public interface SnakeGameItem {
	
	public String[] printItem(int height, int width, String[] board, char itemSymbol);
	public int[] getCurrentPosition();
	public double getItemDistance(SnakeGameItem item);
}
