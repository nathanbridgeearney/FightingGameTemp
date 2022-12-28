import java.util.ArrayList;

public class Base {
    ArrayList<Player> players = new ArrayList<>();


    private Player player1 = new Player();
    private Player player2 = new Player();

    Base(){
        players.add(player1);
        players.add(player2);
    }
}
