package wonderland.alice.component.board;

public class SystemOut implements DisplayBoard {

    private final Board board;

    public SystemOut(Board board) {
        this.board = board;
    }

    @Override
    public void show() {
        for (int currentRow = 0; currentRow < board.getRowCount(); currentRow++) {
            printRowLine();
            for (int currentColumn = 0; currentColumn < board.getColumnCount(); currentColumn++) {
                System.out.print(String.format("|%-20s", board.inspect(currentRow, currentColumn)));
            }
            System.out.println("|");
        }
        printRowLine();
    }

    private void printRowLine() {
        for (int i = 0; i < board.getColumnCount(); i++) {
            System.out.print("+--------------------");
        }
        System.out.println("+");
    }
}
