public class GameLogic {

    private char[][] board;

    public GameLogic() {

        board = new char[3][3];

        resetBoard();

    }

    public void resetBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                board[i][j] = ' ';

            }
        }

    }

    public boolean makeMove(int row, int col, char symbol) {

        if (board[row][col] == ' ') {

            board[row][col] = symbol;

            return true;

        }

        return false;

    }

    public char getCell(int row, int col) {

        return board[row][col];

    }

    public boolean isBoardFull() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (board[i][j] == ' ') {

                    return false;

                }

            }
        }

        return true;

    }

    public boolean checkWinner(char symbol) {

        for (int i = 0; i < 3; i++) {

            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol)

                return true;

        }

        for (int i = 0; i < 3; i++) {

            if (board[0][i] == symbol &&
                board[1][i] == symbol &&
                board[2][i] == symbol)

                return true;

        }

        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol)

            return true;

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol)

            return true;

        return false;

    }

}