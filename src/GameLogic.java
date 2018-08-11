import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {

    private String getRandomMovieTitle() {

        File file = new File("movies.txt");
        ArrayList<String> movieListArray = new ArrayList<>();

        try {
            // Declare and initialise a new scanner to read through the movie list.
            Scanner scanner = new Scanner(file);

            // Check if there is a next line in the file.
            while (scanner.hasNextLine()) {
                // Add the line to the Array.
                movieListArray.add(scanner.nextLine());
            }
            System.out.println(movieListArray.size());
            // Catch the FileNotFoundException.
        } catch (FileNotFoundException exception) {
            System.out.println("The file is not available.");
            // Catch the IndexOutOfBoundsException.
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("There is no more room available inside the array.");
        }
        // Return a randomly generated movie title.
        return getRandomMovie(movieListArray);
    }

    private String getRandomMovie(ArrayList<String> movieList) {
        return movieList.get((int) (Math.random() * movieList.size()));
    }
}
