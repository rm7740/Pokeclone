package my.project.pokeclone;

public class Launcher {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine("Pokeclone!", 240, 160);
        gameEngine.start();
    }
}
