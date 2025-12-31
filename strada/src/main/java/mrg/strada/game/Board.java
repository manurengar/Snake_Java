package mrg.strada.game;

import java.util.Random;

public class Board {

	private Level diff;
	private int height;
	private int width;
	private String[] board;

	private Gold goldItem = new Gold();
	private Door doorItem = new Door();
	private Snake snakeItem;
	private Player playerItem;

	public Board(Level level) {
		this.diff = level;

		// Determine the board dimensions
		Random rnd = new Random();
		int deltaWidth = 1 + rnd.nextInt(3);
		int deltaHeight = 1 + rnd.nextInt(3);

		switch (this.diff) {
		case NORMAL:
			this.height = 12 - deltaHeight;
			this.width = 12 - deltaWidth;
			break;
		case HARD:
			this.height = 18 - deltaHeight;
			this.width = 18 - deltaWidth;
			break;
		}

		this.board = new String[height];
		playerItem = new Player(this.height, this.width);
		snakeItem = new Snake(this.height, this.width, playerItem);
	}

	public void runGame() {
		do {
			this.printBoard();
		} while (!goldItem.isTaken());
	}

	private void printBoard() {
		// Here is where the board gets build
		this.printBorders(this.height, this.width);
		this.board = doorItem.printItem(this.height, this.width, this.board, 'D');
		this.board = goldItem.printItem(this.height, this.width, this.board, 'X');
		this.board = snakeItem.printItem(this.height, this.width, this.board, '$');
		this.board = playerItem.printItem(this.height, this.width, this.board, '#');

		for (int i = 0; i < this.board.length; i++) {
			System.out.println(this.board[i]);
		}
	}

	private void printBorders(int height, int width) {
		String horizontalBorderChar = "-";
		String topBottomBorder = horizontalBorderChar.repeat(width);

		// Top and bottom borders keep first and last position
		this.board[0] = topBottomBorder;
		this.board[height - 1] = topBottomBorder;

		// Fill remaining positions with the body of the board
		for (int j = 1; j <= height - 2; j++) {
			this.board[j] = this.addPlayableField(width, "|");
		}
	}

	private String addPlayableField(int width, String verticalBorder) {
		return verticalBorder + "*".repeat(width - 2) + verticalBorder;
	}

}
