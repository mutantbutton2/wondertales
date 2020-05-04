package wonderland.alice.scoring;

import wonderland.alice.component.card.Card;

import static wonderland.alice.component.card.Card.emptyCard;

public class BoardNodeConverter {

    private final Card[][] board;

    public BoardNodeConverter(Card[][] board) {
        this.board = board;
    }

    public Slot[][] convert() {
        final Slot[][] result = new Slot[board.length+1][board[0].length+1];

        for (int row = 0; row < result.length; row++) {
            for (int column = 0; column < result[0].length; column++) {
                result[row][column] = new Slot(new Node<>(emptyCard()));
            }
        }

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] != null) {
                    result[row][column] = new Slot(new Node<>(board[row][column]));
                }
            }
        }

        for (int row = 0; row < result.length-1; row++) {
            for (int column = 0; column < result[0].length-1; column++) {
                result[row][column].cardNode.setRight(result[row][column+1].cardNode, 1);
                result[row][column].cardNode.setBottom(result[row+1][column].cardNode, 1);
            }
        }
        return result;
    }
}
