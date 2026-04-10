import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UseCase13TrainConsistMngmtTest {

    private List<Bogie> createSampleData() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Luxury", 80));
        return bogies;
    }


    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = UseCase13TrainConsistMngmt.filterUsingLoop(createSampleData());

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }


    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = UseCase13TrainConsistMngmt.filterUsingStream(createSampleData());

        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 60));
    }


    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loopResult = UseCase13TrainConsistMngmt.filterUsingLoop(createSampleData());
        List<Bogie> streamResult = UseCase13TrainConsistMngmt.filterUsingStream(createSampleData());

        assertEquals(loopResult.size(), streamResult.size());
    }


    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();

        UseCase13TrainConsistMngmt.filterUsingStream(createSampleData());

        long end = System.nanoTime();

        assertTrue(end - start > 0);
    }


    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> largeList = new ArrayList<>();

        for (int i = 0; i < 50000; i++) {
            largeList.add(new Bogie("Sleeper", 72));
            largeList.add(new Bogie("AC Chair", 56));
            largeList.add(new Bogie("First Class", 24));
        }

        List<Bogie> result = UseCase13TrainConsistMngmt.filterUsingStream(largeList);

        assertEquals(50000, result.size()); // only 72 qualifies each cycle
    }
}