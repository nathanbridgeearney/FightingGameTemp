
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InfoBar extends JPanel {
    JProgressBar hBar1 = new JProgressBar(0, 100);
    JProgressBar hBar2 = new JProgressBar(0, 100);


    InfoBar() {
        Border blue = BorderFactory.createLineBorder(Color.BLUE);
        Border red = BorderFactory.createLineBorder(Color.RED);
        hBar1.setStringPainted(true);
        hBar2.setStringPainted(true);
        hBar1.setBorder(blue);
        hBar2.setBorder(red);
        hBar1.setForeground(Color.BLUE);
        hBar2.setForeground(Color.RED);
        hBar1.setValue(100);
        hBar2.setValue(100);
        this.add(hBar1);
        this.add(hBar2);
    }
    public void update(Base base){
        hBar1.setValue(base.players.get(0).currentHealth);
        hBar2.setValue(base.players.get(1).currentHealth);

    }


}
