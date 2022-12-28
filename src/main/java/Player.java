
import java.awt.*;

public class Player {

    int max_health = 100;
    int max_moveSpeed = 100;
    int currentHealth = 100;
    Image playerImage;
    Point location;
    int move_Direction = 0;


    public void moveRight(){
        move_Direction +=10;
        location.setLocation(location.x+10,location.y);

    }
    public void moveLeft(){
        move_Direction -=10;
        location.setLocation(location.x-10,location.y);
    }

}
