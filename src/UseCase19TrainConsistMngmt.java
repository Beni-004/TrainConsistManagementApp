import java.util.Arrays;

public class UseCase19TrainConsistMngmt {

    public static boolean binarySearch(String[] arr, String key) {
        if (arr.length == 0) {
            return false;
        }

        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = key.compareTo(arr[mid]);

            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};
        String searchKey = "BG309";
        boolean found = binarySearch(bogieIds, searchKey);
        System.out.println(found);
    }
}