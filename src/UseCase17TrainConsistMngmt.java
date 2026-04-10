import java.util.Arrays;

public class UseCase17TrainConsistMngmt {

    public static void sortBogieNames(String[] arr) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        String[] bogies = {"Sleeper","AC Chair","First Class","General","Luxury"};
        sortBogieNames(bogies);
        System.out.println(Arrays.toString(bogies));
    }
}