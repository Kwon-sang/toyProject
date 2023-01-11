package v2;

public class Application_v2 {

    public static void main(String[] args) throws IllegalArgumentException{
        Game game = new Game();
        try{
            game.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
