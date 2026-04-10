import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseCase11TrainConsistMngmtTest {


    @Test
    void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMngmt.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMngmt.isValidTrainId("TRAIN12"));
        assertFalse(UseCase11TrainConsistMngmt.isValidTrainId("TRN12A"));
        assertFalse(UseCase11TrainConsistMngmt.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMngmt.isValidTrainId("TRN-123"));
        assertFalse(UseCase11TrainConsistMngmt.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_EmptyTrainID() {
        assertFalse(UseCase11TrainConsistMngmt.isValidTrainId(""));
    }


    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMngmt.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMngmt.isValidCargoCode("PET-ab"));
        assertFalse(UseCase11TrainConsistMngmt.isValidCargoCode("PET123"));
        assertFalse(UseCase11TrainConsistMngmt.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMngmt.isValidCargoCode("PET-aB"));
        assertFalse(UseCase11TrainConsistMngmt.isValidCargoCode("pet-AB"));
    }

    @Test
    void testRegex_EmptyCargoCode() {
        assertFalse(UseCase11TrainConsistMngmt.isValidCargoCode(""));
    }


    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(UseCase11TrainConsistMngmt.isValidTrainId("TRN-1234XYZ"));
        assertFalse(UseCase11TrainConsistMngmt.isValidCargoCode("PET-AB12"));
    }


    @Test
    void testRegex_BothValidInputs() {
        assertTrue(UseCase11TrainConsistMngmt.isValidTrainId("TRN-9999"));
        assertTrue(UseCase11TrainConsistMngmt.isValidCargoCode("PET-ZZ"));
    }
}