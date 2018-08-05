import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {

    public String getDisplayedMovieTitle() {

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
        // If the random movie has more than one word, split the movie title into the containing words.
        if (randomMovie.contains(" ")) {
            String[] words = randomMovie.split(" ");
        }
        // Split the random movie into a String array containing all the letters.
        String[] randomMovieArray = randomMovie.split("(?!^)");
        String displayedMovieTitle = "";

        // Initialize the randomMovieStringArray to the size of the randomMovieArray and fill it with "_".
        for (int i = 0; i < randomMovieArray.length; i++) {
            randomMovieStringArray.add(i, randomMovieArray[i]);
            // Check if the position in the Array is a space.
            if (randomMovieArray[i].equals(" ")) {
                // Concatenate a space to separate the words.
                displayedMovieTitle += " ";
            } else {
                // Concatenate a "_" for each letter of the movie title.
                displayedMovieTitle += " _";
            }
        }
        System.out.println(randomMovieStringArray);
        System.out.println(displayedMovieTitle);
        return displayedMovieTitle;
    }

    public String getRandomMovie(ArrayList<String> movieList) {
        return movieList.get((int) (Math.random() * movieList.size()));
    }
}
