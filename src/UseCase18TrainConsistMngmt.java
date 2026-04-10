public class UseCase18TrainConsistMngmt {

    public static boolean linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};
        String searchKey = "BG309";
        boolean found = linearSearch(bogieIds, searchKey);
        System.out.println(found);
    }
}