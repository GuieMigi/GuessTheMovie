import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {

    private String[] randomMovieArray = null;

    public String checkUserInput(String randomMovie) {

        // Check if the Array is null and then split the randomMovie.
        if (randomMovieArray == null) {
            randomMovieArray = randomMovie.split("(?!^)");
        }
        System.out.println(randomMovieArray.length);
        System.out.println(arrayToString(randomMovieArray));

        // Split the random movie into a String array containing all the letters.
        String[] hiddenMovieTitleArray = getHiddenMovieTitleArray(randomMovieArray);
        System.out.println(arrayToString(hiddenMovieTitleArray));

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        // Check that the hiddenMovieTitleArray does not contain any "_".
        for (int i = 0; i < hiddenMovieTitleArray.length; i++) {
            // If there are no more "_" left inside the array then we break out of the loop.
            if (!hiddenMovieTitleArray[i].equals("_")) {
                // We change the hasWon boolean to "true" and break out of the loop.
                Main main = new Main();
                main.hasWon = true;
                break;
            } else {
                // If it does then we can check if the user input can be found inside the array.
                for (int j = 0; i < randomMovieArray.length; i++) {
                    if (randomMovieArray[j].equals(String.valueOf(userInput))) {
                        hiddenMovieTitleArray[j] = String.valueOf(userInput);
                    }
                }
            }
        }
        // TODO: de verificat dacă se actualizează Array-ul cu litera introdusă de user.

        // TODO: de verificat de ce nu se afișează Stringul.
        System.out.println(getHiddenMovieTitle(hiddenMovieTitleArray));
        return getHiddenMovieTitle(hiddenMovieTitleArray);
    }

    // Helper method that converts an Array into a String to help with debugging.
    private String arrayToString(String[] array) {
        String arrayContent = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                arrayContent += " " + array[i];
            }
        }
        return arrayContent;
    }

    // This method takes as an input paramether the randomly generated movie title and returns the hidden movie title inside an Array.
    private String[] getHiddenMovieTitleArray(String[] randomMovieArray) {

        String[] hiddenMovieTitleArray = new String[randomMovieArray.length];

        // Initialize the hiddenMovieTitleArray to the size of the randomMovieArray and fill it with "_".
        for (int i = 0; i < randomMovieArray.length; i++) {
            hiddenMovieTitleArray[i] = "_";
        }
        return hiddenMovieTitleArray;
    }

    // This method takes as an input paramether the hiddenMovieTitleArray and returns the hidden movie title as a String.
    private String getHiddenMovieTitle(String[] hiddenMovieTitleArray) {

        String hiddenMovieTitle = "";

        for (int i = 0; i < hiddenMovieTitleArray.length; i++) {
            // Check if the position in the Array is a space.
            if (hiddenMovieTitleArray[i].equals(" ")) {
                // Concatenate a space to separate the words.
                hiddenMovieTitle += " ";
            } else {
                // Concatenate a "_" for each letter of the movie title.
                hiddenMovieTitle += " _";
            }
        }
        return hiddenMovieTitle;
    }

    public String getRandomMovieTitle() {

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
