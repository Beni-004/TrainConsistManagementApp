import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UseCase19TrainConsistMngmtTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UseCase19TrainConsistMngmt.binarySearch(arr, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertFalse(UseCase19TrainConsistMngmt.binarySearch(arr, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UseCase19TrainConsistMngmt.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] arr = {"BG101","BG205","BG309","BG412","BG550"};
        assertTrue(UseCase19TrainConsistMngmt.binarySearch(arr, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(UseCase19TrainConsistMngmt.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] arr = {};
        assertFalse(UseCase19TrainConsistMngmt.binarySearch(arr, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] arr = {"BG309","BG101","BG550","BG205","BG412"};
        assertTrue(UseCase19TrainConsistMngmt.binarySearch(arr, "BG205"));
    }
}