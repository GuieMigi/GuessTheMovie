import java.util.ArrayList;

public class GameLogic {

    public String getRandomMovie(ArrayList<String> movieList) {
        return movieList.get((int) (Math.random() * movieList.size()));
    }
}
