public class UseCase20TrainConsistMngmt {

    public static boolean searchBogie(String[] arr, String key) {
        if (arr.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] bogieIds = {"BG101","BG205","BG309"};
        boolean result = searchBogie(bogieIds, "BG205");
        System.out.println(result);
    }
}