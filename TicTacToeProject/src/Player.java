public class Player {

    private int id;
    private String username;
    private String password;
    private int wins;
    private int losses;
    private int draws;
    private int score;

    public Player(int id, String username, String password,
                  int wins, int losses, int draws, int score) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getDraws() {
        return draws;
    }

    public int getScore() {
        return score;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public void setScore(int score) {
        this.score = score;
    }
}