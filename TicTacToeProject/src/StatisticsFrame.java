import java.awt.*;
import javax.swing.*;

public class StatisticsFrame extends JFrame {

    public StatisticsFrame(Player player) {

        setTitle("Statistics");
        setSize(350,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(6,1));

        add(new JLabel("Username : " + player.getUsername(),SwingConstants.CENTER));
        add(new JLabel("Wins : " + player.getWins(),SwingConstants.CENTER));
        add(new JLabel("Losses : " + player.getLosses(),SwingConstants.CENTER));
        add(new JLabel("Draws : " + player.getDraws(),SwingConstants.CENTER));
        add(new JLabel("Score : " + player.getScore(),SwingConstants.CENTER));

        JButton back = new JButton("Back");

        back.addActionListener(e->{

            dispose();

        });

        add(back);

    }

}