import exceptions.EmptyBoxException;
import mains.BoxPuzzle;

public class Main {
    public static void main(String[] args) throws EmptyBoxException, InterruptedException {
        BoxPuzzle boxPuzzle = new BoxPuzzle();
        boxPuzzle.generate();
    }
}
