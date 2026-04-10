import java.util.regex.Pattern;

public class UseCase11TrainConsistMngmt {

    private static final Pattern TRAIN_PATTERN = Pattern.compile("TRN-\\d{4}");
    private static final Pattern CARGO_PATTERN = Pattern.compile("PET-[A-Z]{2}");

    public static boolean isValidTrainId(String trainId) {
        return TRAIN_PATTERN.matcher(trainId).matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return CARGO_PATTERN.matcher(cargoCode).matches();
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter Train ID: ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        System.out.println(isValidTrainId(trainId)
                ? "Train ID is valid"
                : "Train ID is invalid");

        System.out.println(isValidCargoCode(cargoCode)
                ? "Cargo Code is valid"
                : "Cargo Code is invalid");
    }
}