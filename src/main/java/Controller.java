public class Controller extends Inputs {
    Application app;

    public Controller(Application application) {
        app = application;
        //Player 1
        setAction(87, () -> light(0));
        setAction(83, () -> heavy(0));
        setAction(65, () -> moveLeft(0));
        setAction(68, () -> moveRight(0));
        //Player 2
        setAction(38, () -> light(1));
        setAction(40, () -> heavy(1));
        setAction(37, () -> moveLeft(1));
        setAction(39, () -> moveRight(1));

    }

    public void light(int num) {
        System.out.print("light" + num);


    }

    private void heavy(int num) {
        System.out.print("heavy" + num);
    }

    private void moveRight(int num) {

        app.getBase().players.get(num).moveRight();
        System.out.println("moveRight1");

    }

    private void moveLeft(int num) {
        app.getBase().players.get(num).moveLeft();
        System.out.println("moveLeft1");

    }


}
