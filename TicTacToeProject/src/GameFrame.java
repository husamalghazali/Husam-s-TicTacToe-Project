import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class GameFrame extends JFrame {

    private final Player player;
    private final JButton[][] buttons = new JButton[3][3];
    private final GameLogic game = new GameLogic();
    private final Random random = new Random();
    private final PlayerService playerService = new PlayerService();

    public GameFrame(Player player) {

        this.player = player;

        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Tic Tac Toe - " + player.getUsername(), SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        JPanel board = new JPanel(new GridLayout(3, 3));

        Font font = new Font("Arial", Font.BOLD, 40);

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(font);

                int row = i;
                int col = j;

                buttons[i][j].addActionListener(e -> playerMove(row, col));

                board.add(buttons[i][j]);

            }

        }

        add(board, BorderLayout.CENTER);

        JButton back = new JButton("Back");

        back.addActionListener(e -> {

            new MainMenuFrame(player).setVisible(true);

            dispose();

        });

        add(back, BorderLayout.SOUTH);

    }

    private void playerMove(int row, int col) {

        if (!game.makeMove(row, col, 'X')) {
            return;
        }

        buttons[row][col].setText("X");

        if (game.checkWinner('X')) {

            playerService.updateWin(player);

            JOptionPane.showMessageDialog(this, "You Win!");

            new MainMenuFrame(playerService.getPlayer(player.getId())).setVisible(true);

            dispose();

            return;

        }

        if (game.isBoardFull()) {

            playerService.updateDraw(player);

            JOptionPane.showMessageDialog(this, "Draw!");

            new MainMenuFrame(playerService.getPlayer(player.getId())).setVisible(true);

            dispose();

            return;

        }

        computerMove();

    }

    private void computerMove() {

        while (true) {

            int row = random.nextInt(3);
            int col = random.nextInt(3);

            if (game.makeMove(row, col, 'O')) {

                buttons[row][col].setText("O");

                break;

            }

        }

        if (game.checkWinner('O')) {

            playerService.updateLoss(player);

            JOptionPane.showMessageDialog(this, "Computer Wins!");

            new MainMenuFrame(playerService.getPlayer(player.getId())).setVisible(true);

            dispose();

            return;

        }

        if (game.isBoardFull()) {

            playerService.updateDraw(player);

            JOptionPane.showMessageDialog(this, "Draw!");

            new MainMenuFrame(playerService.getPlayer(player.getId())).setVisible(true);

            dispose();

        }

    }

}