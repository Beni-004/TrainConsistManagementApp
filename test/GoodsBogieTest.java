import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UseCase12TrainConsistMngmtTest {

    private List<GoodsBogie> createBaseList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        return bogies;
    }


    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = createBaseList();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        assertTrue(UseCase12TrainConsistMngmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        assertTrue(UseCase12TrainConsistMngmt.isTrainSafe(bogies));
    }


    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Coal")); // invalid

        assertFalse(UseCase12TrainConsistMngmt.isTrainSafe(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = createBaseList();
        bogies.add(new GoodsBogie("Cylindrical", "Coal")); // violation

        assertFalse(UseCase12TrainConsistMngmt.isTrainSafe(bogies));
    }


    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        assertTrue(UseCase12TrainConsistMngmt.isTrainSafe(bogies));
    }
}