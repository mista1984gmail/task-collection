package by.clevertec.util;

import by.clevertec.model.Animal;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.reader.JsonReader;
import by.clevertec.util.reader.Reader;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilForTest {
    private static final String ANIMALS_FILE_RESULT_TASK_1 = "src/test/resources/json/animals_for_task1.json";
    private static final String PERSONS_FILE_RESULT_TASK_12 = "src/test/resources/json/persons_for_task12.json";
    private static final String PERSONS_FILE_RESULT_TASK_13 = "src/test/resources/json/persons_for_task13.json";
    private static final String STUDENTS_FILE_RESULT_TASK_19 = "src/test/resources/json/students_for_task19.json";
    private static final Reader reader = new JsonReader();
    public static List<Animal> expectedAnimalsForTask1() {
        return reader.getModelData(ANIMALS_FILE_RESULT_TASK_1, new TypeReference<>() {
        });
    }
    public static List<String> expectedAnimalBreadsForTask2(){
        return Arrays.asList("HURON", "Lorikeet", "scaly-breasted", "BOA", "MALAGASY GROUND", "BRAZILIAN TAPIR", "JAEGER", "LONG-TAILED", "Mourning collared dove", "BLUE AND YELLOW MACAW", "GULL", "LAVA", "GOLIATH HERON", "TORTOISE", "INDIAN STAR", "SOUTH AMERICAN PUMA", "LONG-FINNED PILOT WHALE", "Penguin", "galapagos", "Woodpecker", "red-headed", "Mexican beaded lizard", "Common dolphin", "GULL", "LAVA");
    }
    public static List<String> expectedAnimalBreadsForTask3(){
        return Arrays.asList("Azeri", "Aymara", "Afrikaans", "Arabic", "Armenian", "Amharic", "Assamese", "Albanian");
    }
    public static Long expectedNumberOfAnimalsFemaleTask4(){
        return 476L;
    }
    public static Animal expectedAnimalForTask5(){
        return new Animal(19, "Mudskipper (unidentified)", 25, "Hungarian", "Female");
    }
    public static Integer expectedAgeOldestAnimalTask8(){
        return 48;
    }
    public static Integer expectedLengthShortestArrayTask9(){
        return 3;
    }
    public static Integer expectedTotalAgeAllAnimalsTask10(){
        return 25329;
    }
    public static Double expectedAverageAgeAllAnimalsFromIndonesiaTask11(){
        return 25.8;
    }

    public static List<Person> expectedPersonsForTask12() {
        return reader.getModelData(PERSONS_FILE_RESULT_TASK_12, new TypeReference<>() {
        });
    }
    public static List<Person> expectedPersonsForTask13() {
        return reader.getModelData(PERSONS_FILE_RESULT_TASK_13, new TypeReference<>() {
        });
    }
    public static Double expectedTotalRevenueLogisticsCampaignTask14(){
        return 18739.187039999997;
    }
    public static Double expectedTotalCostMaintainingAllPlantsTask15(){
        return 3811.542;
    }
    public static List<String> expectedGroupsForTask17(){
        return Arrays.asList("C-1", "C-2", "C-3", "C-4", "M-1", "M-2", "M-3", "P-1", "P-2","P-3", "P-4");
    }
    public static Map<String, Double> expectedAverageAgeOfStudentsForFacultyTask18(){
        Map<String, Double> averageAgeOfStudentsForFaculty = new HashMap<>();
        averageAgeOfStudentsForFaculty.put("Mathematics", 18.833333333333332);
        averageAgeOfStudentsForFaculty.put("Physics", 18.846153846153847);
        averageAgeOfStudentsForFaculty.put("ComputerScience", 19.153846153846153);
        averageAgeOfStudentsForFaculty.put("Chemistry", 19.416666666666668);
        return averageAgeOfStudentsForFaculty;
    }

    public static List<Student> expectedStudentsForTask19() {
        return reader.getModelData(STUDENTS_FILE_RESULT_TASK_19, new TypeReference<>() {
        });
    }
    public static String groupStudentsForTask19(){
        return "P-1";
    }
    public static Map<String, Double> expectedFacultyWithMaximumAverageGradeFirstExamTask20(){
        Map<String, Double> facultyWithMaximumAverageGradeFirstExam = new HashMap<>();
        facultyWithMaximumAverageGradeFirstExam.put("Mathematics", 8.6);
        return facultyWithMaximumAverageGradeFirstExam;
    }

    public static Map<String, Long> expectedNumberOfStudentsInGroupTask21(){
        Map<String, Long> numberOfStudentsInGroup = new HashMap<>();
        numberOfStudentsInGroup.put("M-1", 5L);
        numberOfStudentsInGroup.put("M-3", 3L);
        numberOfStudentsInGroup.put("M-2", 4L);
        numberOfStudentsInGroup.put("P-2", 2L);
        numberOfStudentsInGroup.put("P-1", 7L);
        numberOfStudentsInGroup.put("C-1", 4L);
        numberOfStudentsInGroup.put("P-4", 1L);
        numberOfStudentsInGroup.put("P-3", 3L);
        numberOfStudentsInGroup.put("C-3", 9L);
        numberOfStudentsInGroup.put("C-2", 11L);
        numberOfStudentsInGroup.put("C-4", 1L);
        return numberOfStudentsInGroup;
    }

    public static Map<String, Integer> expectedMinAgeForFacultyTask22(){
        Map<String, Integer> minAgeForFaculty = new HashMap<>();
        minAgeForFaculty.put("ComputerScience", 18);
        minAgeForFaculty.put("Chemistry", 18);
        minAgeForFaculty.put("Mathematics", 18);
        minAgeForFaculty.put("Physics", 18);
        return minAgeForFaculty;
    }

}
