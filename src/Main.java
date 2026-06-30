public class Main {
    public static void main(String[] args) {

        Character player = new Character("Mert");

        StoryEngine engine = new StoryEngine();

        engine.startGame(player);
    }
}