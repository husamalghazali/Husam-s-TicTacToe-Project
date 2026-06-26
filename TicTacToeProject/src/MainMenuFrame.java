import java.awt.*;
import javax.swing.*;

public class MainMenuFrame extends JFrame {

    private Player player;

    public MainMenuFrame(Player player) {

        this.player = player;

        setTitle("Tic Tac Toe");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JLabel title = new JLabel("TIC TAC TOE");
        title.setFont(new Font("Arial", Font.BOLD, 28));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcome = new JLabel("Welcome, " + player.getUsername());
        welcome.setFont(new Font("Arial", Font.PLAIN, 18));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton btnStart = new JButton("Start Game");
        JButton btnStatistics = new JButton("Statistics");
        JButton btnTop5 = new JButton("Top 5 Players");
        JButton btnLogout = new JButton("Logout");

        btnStart.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnStatistics.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnTop5.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogout.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnStart.setMaximumSize(new Dimension(200, 40));
        btnStatistics.setMaximumSize(new Dimension(200, 40));
        btnTop5.setMaximumSize(new Dimension(200, 40));
        btnLogout.setMaximumSize(new Dimension(200, 40));

        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(welcome);
        panel.add(Box.createVerticalStrut(30));
        panel.add(btnStart);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnStatistics);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnTop5);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnLogout);

        add(panel);

        // START GAME
        btnStart.addActionListener(e -> {

            new GameFrame(player).setVisible(true);
            dispose();

        });

        // STATISTICS
        btnStatistics.addActionListener(e -> {

            PlayerService ps = new PlayerService();

            Player latestPlayer = ps.getPlayer(player.getId());

            new StatisticsFrame(latestPlayer).setVisible(true);

        });

        // TOP 5
        btnTop5.addActionListener(e -> {

            new TopScorersFrame().setVisible(true);

        });

        // LOGOUT
        btnLogout.addActionListener(e -> {

            new LoginFrame().setVisible(true);
            dispose();

        });

    }

}