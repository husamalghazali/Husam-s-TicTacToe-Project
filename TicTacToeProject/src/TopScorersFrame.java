import java.util.ArrayList;
import javax.swing.*;

public class TopScorersFrame extends JFrame {

    public TopScorersFrame() {

        setTitle("Top 5 Players");
        setSize(350,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea area = new JTextArea();

        area.setEditable(false);

        PlayerService ps = new PlayerService();

        ArrayList<Player> list = ps.getTopPlayers();

        int rank = 1;

        for(Player p : list){

            area.append(
                    rank + ". "
                    + p.getUsername()
                    + " | Score : "
                    + p.getScore()
                    + " | W:"
                    + p.getWins()
                    + " L:"
                    + p.getLosses()
                    + " D:"
                    + p.getDraws()
                    + "\n");

            rank++;

        }

        add(new JScrollPane(area));

    }

}