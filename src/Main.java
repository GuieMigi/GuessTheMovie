
public class Main {

    public boolean hasWon = false;

    public static void main(String[] args){

        // Declare and initialize a Game Logic Class object.
        GameLogic gameLogic = new GameLogic();
        final String RANDOM_MOVIE = gameLogic.getRandomMovieTitle();
        System.out.println(RANDOM_MOVIE);
        System.out.println(gameLogic.checkUserInput(RANDOM_MOVIE));
    }
}