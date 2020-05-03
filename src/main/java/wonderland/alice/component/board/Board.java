package wonderland.alice.component.board;

import wonderland.alice.component.card.Card;

public class Board {
    
    private static final int ROW_COUNT = 5;
    private static final int COLUMN_COUNT = 3;

    private final int cardCount;
    private final Card[][] board;

    public static Board createEmptyBoard() {
        return new Board(new Card[ROW_COUNT][COLUMN_COUNT], 0);
    }

    public Board (Card[][] board, int cardCount) {
        this.board = board;
        this.cardCount = cardCount;
    }

    public Board place(int row, int column, Card card) {
        final Card[][] newBoard = cloneBoard();
        newBoard[row][column] = card;
        return new Board(newBoard, cardCount + 1);
    }

    public boolean isAvailable(int row, int column) {
        return board[row][column] == null;
    }

    private Card[][] cloneBoard() {
        final Card[][] newBoard = new Card[ROW_COUNT][COLUMN_COUNT];
        for (int currentRow = 0; currentRow < ROW_COUNT; currentRow++) {
            for (int currentColumn = 0; currentColumn < COLUMN_COUNT; currentColumn++) {
                newBoard[currentRow][currentColumn] = board[currentRow][currentColumn];
            }
        }
        return newBoard;
    }

    public void show() {
        for (int currentRow = 0; currentRow < ROW_COUNT; currentRow++) {
            printRowLine();
            for (int currentColumn = 0; currentColumn < COLUMN_COUNT; currentColumn++) {
                System.out.print(String.format("|%-20s", board[currentRow][currentColumn]));
            }
            System.out.println("|");
        }
    }

    private void printRowLine() {
        for (int i = 0; i < getColumnCount(); i++) {
            System.out.print("+--------------------");
        }
        System.out.println("+");
    }

    public int getRowCount() {
        return ROW_COUNT;
    }

    public int getColumnCount() {
        return COLUMN_COUNT;
    }

}
