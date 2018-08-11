
public class Main {

    public static void main(String[] args){

        // Declare and initialize a Game Logic Class object.
        GameLogic gameLogic = new GameLogic();
        final String RANDOM_MOVIE = gameLogic.getRandomMovieTitle();
        System.out.println(RANDOM_MOVIE);
        System.out.println(gameLogic.checkUserInput(RANDOM_MOVIE));

        // Display a randomly generated movie title using "_" for each letter.
        boolean hasWon = false;
    }
}