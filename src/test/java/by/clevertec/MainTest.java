package by.clevertec;

import by.clevertec.util.UtilForTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void task1() {
        assertArrayEquals(UtilForTest.expectedAnimalsForTask1().toArray(), Main.task1().toArray());
    }
    @Test
    void task2() {
        assertEquals(Arrays.toString(UtilForTest.expectedAnimalBreadsForTask2().toArray()), Arrays.toString(Main.task2().toArray()));
    }

    @Test
    void task3() {
        assertArrayEquals(UtilForTest.expectedAnimalBreadsForTask3().toArray(), Main.task3().toArray());
    }

    @Test
    void task4() {
        assertEquals(UtilForTest.expectedNumberOfAnimalsFemaleTask4(), Main.task4());
    }

    @Test
    void task5() {
        assertEquals(UtilForTest.expectedAnimalForTask5(), Main.task5());
    }

    @Test
    void task6() {
        assertFalse(Main.task6());
    }

    @Test
    void task7() {
        assertTrue(Main.task7());
    }

    @Test
    void task8() {
        assertEquals(UtilForTest.expectedAgeOldestAnimalTask8(), Main.task8());
    }

    @Test
    void task9() {
        assertEquals(UtilForTest.expectedLengthShortestArrayTask9(), Main.task9());
    }

    @Test
    void task10() {
        assertEquals(UtilForTest.expectedTotalAgeAllAnimalsTask10(), Main.task10());
    }

    @Test
    void task11() {
        assertEquals(UtilForTest.expectedAverageAgeAllAnimalsFromIndonesiaTask11(), Main.task11());
    }
    @Test
    void task12() {
        assertArrayEquals(UtilForTest.expectedPersonsForTask12().toArray(), Main.task12().toArray());
    }

    @Test
    void task13() {
        assertArrayEquals(UtilForTest.expectedPersonsForTask13().toArray(), Main.task13().toArray());
    }

    @Test
    void task14() {
        assertEquals(UtilForTest.expectedTotalRevenueLogisticsCampaignTask14(), Main.task14());
    }
    @Test
    void task15() {
        assertEquals(UtilForTest.expectedTotalCostMaintainingAllPlantsTask15(), Main.task15());
    }

    @Test
    void task16() {
        assertArrayEquals(List.of().toArray(), Main.task16().toArray());
    }
    @Test
    void task17() {
        assertArrayEquals(UtilForTest.expectedGroupsForTask17().toArray(), Main.task17().toArray());
    }

    @Test
    void task18() {
        assertEquals(UtilForTest.expectedAverageAgeOfStudentsForFacultyTask18(), Main.task18());
    }

    @Test
    void task19() {
        assertArrayEquals(UtilForTest.expectedStudentsForTask19().toArray(), Main.task19(UtilForTest.groupStudentsForTask19()).toArray());
    }

    @Test
    void task20() {
        assertEquals(UtilForTest.expectedFacultyWithMaximumAverageGradeFirstExamTask20(), Main.task20());
    }

    @Test
    void task21() {
        assertEquals(UtilForTest.expectedNumberOfStudentsInGroupTask21(), Main.task21());
    }

    @Test
    void task22() {
        assertEquals(UtilForTest.expectedMinAgeForFacultyTask22(), Main.task22());
    }

}