import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UseCase7TrainConsistMngmtTest {

    private List<Bogie> createSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 40));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Luxury", 80));
        return bogies;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = UseCase7TrainConsistMngmt.filterByCapacity(createSampleBogies(), 70);
        assertTrue(result.stream().allMatch(b -> b.capacity > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Test", 70));

        List<Bogie> result = UseCase7TrainConsistMngmt.filterByCapacity(bogies, 70);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = UseCase7TrainConsistMngmt.filterByCapacity(createSampleBogies(), 70);
        assertFalse(result.stream().anyMatch(b -> b.capacity < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = UseCase7TrainConsistMngmt.filterByCapacity(createSampleBogies(), 50);
        assertEquals(2, result.size()); // 72 and 80
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = UseCase7TrainConsistMngmt.filterByCapacity(createSampleBogies(), 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = UseCase7TrainConsistMngmt.filterByCapacity(createSampleBogies(), 10);
        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = UseCase7TrainConsistMngmt.filterByCapacity(new ArrayList<>(), 50);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = createSampleBogies();
        List<Bogie> copy = new ArrayList<>(original);

        UseCase7TrainConsistMngmt.filterByCapacity(original, 50);

        assertEquals(copy.size(), original.size());
        for (int i = 0; i < original.size(); i++) {
            assertEquals(copy.get(i).capacity, original.get(i).capacity);
            assertEquals(copy.get(i).name, original.get(i).name);
        }
    }
}