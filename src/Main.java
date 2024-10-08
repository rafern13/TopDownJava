import Objetos.Game.GameLoop;
import helpers.Vector2;
import view.GameWindow;

public class Main {

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow(new Vector2(320, 180), 1);
        GameLoop gameLoop = GameLoop.getInstance(gameWindow);
        gameLoop.start();
    }



}
