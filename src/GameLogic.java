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

        //TODO: de creat o metodă ajutătoare care să folosească un loop pentru a afișa conținutul unui Array. Primește ca parametru un Array și returnează un string.

        // Split the random movie into a String array containing all the letters.
        String[] hiddenMovieTitleArray = getHiddenMovieTitleArray(randomMovieArray);

        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        for (int i = 0; i < randomMovieArray.length; i++) {
            if (randomMovieArray[i].equals(String.valueOf(userInput))) {
                randomMovieArray[i] = String.valueOf(userInput);
            }
        }
        // TODO: de verificat dacă se actualizează Array-ul cu litera introdusă de user.

        // TODO: de verificat de ce nu se afișează Stringul.
        return getHiddenMovieTitle(hiddenMovieTitleArray);
    }

    // This method takes as an input paramether the randomly generated movie title and returns the hidden movie title inside an Array.
    private String[] getHiddenMovieTitleArray(String[] randomMovieArray) {

        String[] hiddenMovieTitleArray = new String[randomMovieArray.length];

        // The string that holds the correct number of words and the correct number of letters anonymised using "_", for the randomly generated movie.
        String anonymisedMovieTitle = "";

        // Initialize the hiddenMovieTitleArray to the size of the randomMovieArray and fill it with "_".
        for (int i = 0; i < randomMovieArray.length; i++) {
            hiddenMovieTitleArray[i] = randomMovieArray[i];
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
