import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseCase14TrainConsistMngmtTest {


    @Test
    void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie b = UseCase14TrainConsistMngmt.createBogie("Sleeper", 72);

        assertEquals("Sleeper", b.getType());
        assertEquals(72, b.getCapacity());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie b = UseCase14TrainConsistMngmt.createBogie("AC Chair", 56);

        assertEquals("AC Chair", b.getType());
        assertEquals(56, b.getCapacity());
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        PassengerBogie b1 = UseCase14TrainConsistMngmt.createBogie("Sleeper", 72);
        PassengerBogie b2 = UseCase14TrainConsistMngmt.createBogie("First Class", 24);

        assertNotNull(b1);
        assertNotNull(b2);
    }


    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            UseCase14TrainConsistMngmt.createBogie("Sleeper", -10);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            UseCase14TrainConsistMngmt.createBogie("AC Chair", 0);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }


    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            UseCase14TrainConsistMngmt.createBogie("Test", -5);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }
}