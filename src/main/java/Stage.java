
import javax.swing.*;
import java.awt.*;


public class Stage extends JPanel {
    Graphics2D g2;
    Base mainBase;

    public Stage(Base base) {
        super(true);
        mainBase = base;
//        this.setBackground(Color.GRAY);

    }

    @Override
    public void paintComponent(Graphics g) {
        g2 = (Graphics2D) g;
        super.paintComponent(g2); // Window.
        drawImage(g2);
    }


    private void drawImage(Graphics g) {

        for (Player p : mainBase.players) {
            g.drawImage(p.playerImage, p.location.x, p.location.y, 100, 250, null);

        }

    }

}
