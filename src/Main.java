import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        File file = new File("movies.txt");
        ArrayList<String> movieList = new ArrayList<>();
        boolean hasWon = false;

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                movieList.add(scanner.nextLine());
            }
            System.out.println(movieList.size());
        } catch (FileNotFoundException exception) {
            System.out.println("The file is not available.");
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("There is no more room available inside the array.");
        }
    }
}
