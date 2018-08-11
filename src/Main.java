
public class Main {

    public static void main(String[] args){

        // Declare and initialize a Game Logic Class object.
        GameLogic gameLogic = new GameLogic();

        // Display a randomly generated movie title using "_" for each letter.
        boolean hasWon = false;

        Test test = new Test();
        final String RANDOM_MOVIE = test.getRandomMovieTitle();
        System.out.println(RANDOM_MOVIE);
        System.out.println(test.checkUserInput(RANDOM_MOVIE));
    }
}