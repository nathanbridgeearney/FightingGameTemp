
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class Inputs implements KeyListener {
    private final Map<Integer, Runnable> pressed = new HashMap<>();
    public void setAction(int keyCode, Runnable onPressed) {
        pressed.put(keyCode, onPressed);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        assert SwingUtilities.isEventDispatchThread();
        pressed.getOrDefault(e.getKeyCode(), () -> {
        }).run();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        assert SwingUtilities.isEventDispatchThread();

    }
}
