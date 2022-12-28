import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Application {
    long startTime = System.currentTimeMillis();
    private final int fps =1;
    int skipTicks = 1000 / fps;
    int nextGameTick = getTickCount();
    long sleepTime = 0;
    boolean gameRunning = false;

    private final JFrame frame = new JFrame();
    public Base base = new Base();
    Controller controller = new Controller(this);
    private Stage stage;
    InfoBar infoBar = new InfoBar();
    Timer frameTimer = new Timer();

    Application() {
        stageSetup();
        stageGame();
        stage.repaint();
        startGameTimer();

    }

    private void startGameTimer() {
        while (!gameRunning){
            sleepTime = nextGameTick - getTickCount();

            if (sleepTime < 0) {
                gameRunning =true;
                TimerTask frameTimerTask = frameTimerTask();
                frameTimer.scheduleAtFixedRate(frameTimerTask, 0, 30);
            }
        }


    }

    private void stageGame() {

        stage = new Stage(base);
        frame.add(stage);

    }

    private void stageSetup() {
        playerSetup();
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(controller);
        frame.setSize(new Dimension(600, 600));
        frame.add(BorderLayout.NORTH, infoBar);
    }


    private void playerSetup() {

        Player player1 = base.players.get(0);
        Player player2 = base.players.get(1);
        ImageIcon ii = new ImageIcon("Character_Base_Large.png");
        player1.playerImage = ii.getImage();
        player1.location = new Point(200, 450);
        ImageIcon ii2 = new ImageIcon("Character_Base2_Large.png");
        player2.playerImage = ii2.getImage();
        player2.location = new Point(400, 450);

    }

    public int getTickCount() {
        return (int) (System.currentTimeMillis() - startTime);
    }


    public TimerTask frameTimerTask() {
        return new TimerTask() {
            @Override
            public void run() {

                {
                    infoBar.update(base);
                    stage.repaint();
                    for (Player player : base.players) {
                        if (player.currentHealth == 0) {
                            frameTimer.cancel();
                        }
                    }
                }
                {
                    nextGameTick += skipTicks;
                    sleepTime = nextGameTick - getTickCount();
                }
                if (sleepTime >= 0) {
                    gameRunning = false;
                    startGameTimer();
                }
            }
        };
    }

    public Base getBase() {
        return this.base;
    }
}
