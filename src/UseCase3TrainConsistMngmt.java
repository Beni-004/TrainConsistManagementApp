import java.util.HashSet;

public class UseCase3TrainConsistMngmt {
    public static void main(String[] args) {
        HashSet<String> bogieIDs = new HashSet<>();

        bogieIDs.add("BG101");
        bogieIDs.add("BG102");
        bogieIDs.add("BG103");
        bogieIDs.add("BG101");
        bogieIDs.add("BG102");

        System.out.println("Unique Bogie IDs: " + bogieIDs);
    }
}