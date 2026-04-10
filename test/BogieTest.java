import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UseCase10TrainConsistMngmtTest {

    private List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        return bogies;
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        int result = UseCase10TrainConsistMngmt.calculateTotalCapacity(createSampleBogies());
        assertEquals(152, result); // 72 + 56 + 24
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        int result = UseCase10TrainConsistMngmt.calculateTotalCapacity(createSampleBogies());
        assertTrue(result > 0);
        assertEquals(152, result);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        int result = UseCase10TrainConsistMngmt.calculateTotalCapacity(bogies);
        assertEquals(72, result);
    }

    @Test
    void testReduce_EmptyBogieList() {
        int result = UseCase10TrainConsistMngmt.calculateTotalCapacity(new ArrayList<>());
        assertEquals(0, result);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createSampleBogies();

        List<Integer> capacities = bogies.stream()
                .map(Bogie::getCapacity)
                .toList();

        assertEquals(List.of(72, 56, 24), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createSampleBogies();

        int manualSum = 72 + 56 + 24;
        int result = UseCase10TrainConsistMngmt.calculateTotalCapacity(bogies);

        assertEquals(manualSum, result);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = createSampleBogies();
        List<Bogie> copy = new ArrayList<>(original);

        UseCase10TrainConsistMngmt.calculateTotalCapacity(original);

        assertEquals(copy.size(), original.size());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(copy.get(i).getName(), original.get(i).getName());
            assertEquals(copy.get(i).getCapacity(), original.get(i).getCapacity());
        }
    }
}