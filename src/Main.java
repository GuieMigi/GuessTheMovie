import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        File file = new File("movies.txt");
        ArrayList<String> movieListArray = new ArrayList<>();
        ArrayList<String> randomMovieStringArray = new ArrayList<>();
        boolean hasWon = false;

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                movieListArray.add(scanner.nextLine());
            }
            System.out.println(movieListArray.size());
        } catch (FileNotFoundException exception) {
            System.out.println("The file is not available.");
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("There is no more room available inside the array.");
        }

        // Initialize a GameLogic object.
        GameLogic gameLogic = new GameLogic();
        // Get a random movie from the movieListArray.
        String randomMovie = gameLogic.getRandomMovie(movieListArray);
        System.out.println(randomMovie);
    }
/*
    private int[] checkEnteredLetter(){
        GameLogic gameLogic = new GameLogic();
        String randomMovie = gameLogic.getRandomMovie(movieListArray);
        System.out.println(randomMovie);
        String[] randomMovieArray = randomMovie.split("(?!^)");
        System.out.println(randomMovieArray);
        Scanner userInputScanner = new Scanner(System.in);
        String userInput = userInputScanner.nextLine();
        int[] positionID = new int[10];
        if (randomMovie.contains(userInput)){
            for (int i = 0; i < randomMovieArray.length; i++){
                if (userInput.equalsIgnoreCase(randomMovieArray[i])){
                    positionID[i] = i;
                }
            }
        } return positionID;
    }
    */
}
