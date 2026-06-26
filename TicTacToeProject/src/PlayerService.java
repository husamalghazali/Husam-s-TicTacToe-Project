import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlayerService {

    public Player login(String username, String password) {

        Connection conn = DatabaseManager.getConnection();

        if (conn == null) {
            return null;
        }

        try {

            String sql = "SELECT * FROM players WHERE username=? AND password=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                );

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

    public void updateWin(Player player) {

        Connection conn = DatabaseManager.getConnection();

        try {

            String sql = "UPDATE players SET wins=wins+1, score=score+3 WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, player.getId());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void updateLoss(Player player) {

        Connection conn = DatabaseManager.getConnection();

        try {

            String sql = "UPDATE players SET losses=losses+1 WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, player.getId());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void updateDraw(Player player) {

        Connection conn = DatabaseManager.getConnection();

        try {

            String sql = "UPDATE players SET draws=draws+1, score=score+1 WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, player.getId());

            ps.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public Player getPlayer(int id) {

        Connection conn = DatabaseManager.getConnection();

        try {

            String sql = "SELECT * FROM players WHERE id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                );

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public ArrayList<Player> getTopPlayers() {

        ArrayList<Player> list = new ArrayList<>();

        Connection conn = DatabaseManager.getConnection();

        try {

            String sql = "SELECT * FROM players ORDER BY score DESC LIMIT 5";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(new Player(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("wins"),
                        rs.getInt("losses"),
                        rs.getInt("draws"),
                        rs.getInt("score")
                ));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return list;

    }

}