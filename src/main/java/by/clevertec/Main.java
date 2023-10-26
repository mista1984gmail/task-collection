package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;
import java.util.LinkedHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.Map.Entry.comparingByValue;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.minBy;

public class Main {
    public static final List<Animal> ANIMALS = Util.getAnimals();
    public static final List<Person> PERSONS = Util.getPersons();
    public static final List<House> HOUSES = Util.getHouses();
    public static final List<Student> STUDENTS = Util.getStudents();
    public static final List<Examination> EXAMINATIONS = Util.getExaminations();
    public static final List<Car> CARS = Util.getCars();
    public static final List<Flower> FLOWERS = Util.getFlowers();

    public static void main(String[] args) {
        System.out.println(task1());
        System.out.println(task2());
        System.out.println(task3());
        System.out.println(task4());
        try{
            System.out.println(task5());
        }catch (RuntimeException e){
            e.printStackTrace();
        }

        System.out.println(task6());
        System.out.println(task7());
        try{
            System.out.println(task8());
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        System.out.println(task9());
        System.out.println(task10());
        System.out.println(task11());
        System.out.println(task12());
        System.out.println(task13());
        System.out.println("Total revenue: " + task14());
        System.out.println(task15());
        task16();
        System.out.println(task17());
        System.out.println(task18());
        System.out.println(task19("P-1"));
        System.out.println(task20());
        System.out.println(task21());
        System.out.println(task22());
    }

    public static List<Animal> task1() {
        return ANIMALS.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() < 20)
                .sorted(comparing(Animal::getAge))
                .skip(14)
                .limit(7)
                .collect(Collectors.toList());
    }

    public static List<String> task2() {
        return ANIMALS.stream()
                .filter(animal -> animal.getOrigin().equals("Japanese"))
                .map(animal -> animal.getGender().equals("Female")? animal.getBread().toUpperCase() : animal.getBread())
                .collect(Collectors.toList());
    }

    public static List<String> task3() {
        return ANIMALS.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(origin -> origin.startsWith("A"))
                .distinct()
                .collect(Collectors.toList());
    }

    public static Long task4() {
        return ANIMALS.stream()
                .filter(animal -> animal.getGender().equals("Female"))
                .count();
    }

    public static Animal task5 () throws RuntimeException{
        return ANIMALS.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .filter(animal -> animal.getOrigin().equals("Hungarian"))
                .findAny()
                .orElseThrow(() -> new RuntimeException("There is no such animal"));
    }

    public static boolean task6() {
        return ANIMALS.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals("Female"));
    }

    public static boolean task7() {
        return ANIMALS.stream()
                .noneMatch(animal -> animal.getOrigin().equals("Oceania"));
    }

    public static Integer task8() throws RuntimeException{
        return ANIMALS.stream()
                .sorted(comparing(Animal::getBread))
                .limit(100)
                .mapToInt(Animal::getAge)
                .max()
                .orElseThrow(() -> new RuntimeException("There is no such animal"));
    }

    public static Integer task9() {
        return ANIMALS.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .mapToInt((value) -> value.length)
                .summaryStatistics()
                .getMin();
    }

    public static Integer task10() {
        return ANIMALS.stream()
                .mapToInt(Animal::getAge)
                .sum();
    }

    public static Double task11() {
        return ANIMALS.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .mapToDouble(Animal::getAge)
                .summaryStatistics()
                .getAverage();
    }

    public static List<Person> task12() {
        LocalDate currentDate = LocalDate.now();
        return PERSONS.stream()
                .filter(person -> person.getGender().equals("Male") &&
                        Period.between(person.getDateOfBirth(), currentDate).getYears() >= 18 &&
                        Period.between(person.getDateOfBirth(), currentDate).getYears() < 27)
                .sorted(comparing(Person::getRecruitmentGroup))
                .limit(200)
                .collect(Collectors.toList());
    }


    public static List<Person> task13() {
        LocalDate currentDate = LocalDate.now();
        return HOUSES.stream()
                .sorted(comparing((e) ->{
                    if(e.getBuildingType().equals("Hospital")) return -1;
                    else return 1;
                }))
                .collect(Collectors.toMap(House::getBuildingType, House::getPersonList, (o1, o2) -> o1, TreeMap::new))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream()
                                .sorted(Comparator.comparing(person -> {
                                    int age = Period.between(person.getDateOfBirth(), currentDate).getYears();
                                    if(person.getGender().equals("Male")){
                                        if(age < 18 || age >= 63){
                                            return -1;
                                        }else return 1;
                                    } else {
                                        if(age < 18 || age >= 58){
                                            return -1;
                                        }else return 1;
                                    }
                                }))
                                .collect(toList())
                )).values().stream()
                .flatMap(Collection::stream)
                .limit(500)
                .collect(Collectors.toList());
    }

    public static Double task14() {
        Predicate<Car>predicateTurkmenistan = (car) -> car.getCarModel().equals("Jaguar") ||
                car.getColor().equals("White");
        Predicate<Car>predicateUzbekistan = (car) -> car.getMass() < 1500 ||
                (car.getCarModel().equals("BMW") ||
                        car.getCarModel().equals("Lexus") ||
                        car.getCarModel().equals("Chrysler") ||
                        car.getCarModel().equals("Toyota"));
        Predicate<Car>predicateKazakhstan = (car) -> car.getColor().equals("Black") ||
                car.getMass() > 4000 ||
                (car.getCarModel().equals("GMC") ||
                        car.getCarModel().equals("Dodge"));
        Predicate<Car>predicateKyrgyzstan = (car) -> car.getReleaseYear() < 1982 ||
                (car.getCarModel().equals("Civic") ||
                        car.getCarModel().equals("Cherokee"));
        Predicate<Car>predicateRussia = (car) -> !car.getColor().equals("Yellow") &&
                !car.getColor().equals("Red") &&
                !car.getColor().equals("Green") &&
                !car.getColor().equals("Blue")
                || car.getPrice() > 40000;
        Predicate<Car> predicateMongolia = (car) -> car.getVin().matches("(.)*[5]{1}[9]{1}(.)*");
        Predicate<Car> predicateTheyAreNotGoingAnywhere = (car) ->  !predicateTurkmenistan.test(car) &&
                !predicateUzbekistan.test(car) &&
                !predicateKazakhstan.test(car) &&
                !predicateKyrgyzstan.test(car) &&
                !predicateRussia.test(car) &&
                !predicateMongolia.test(car);

        Map<String, Predicate<Car>> predicateByCountry = new HashMap<>();
        predicateByCountry.put("Turkmenistan", predicateTurkmenistan);
        predicateByCountry.put("Uzbekistan", predicateUzbekistan);
        predicateByCountry.put("Kazakhstan", predicateKazakhstan);
        predicateByCountry.put("Kyrgyzstan", predicateKyrgyzstan);
        predicateByCountry.put("Russia", predicateRussia);
        predicateByCountry.put("Mongolia", predicateMongolia);
        predicateByCountry.put("TheyAreNotGoingAnywhere", predicateTheyAreNotGoingAnywhere);

        return CARS.stream()
                .map(car -> {
                    Optional<String> country = predicateByCountry.entrySet().stream()
                            .filter(entry -> entry.getValue().test(car))
                            .map(Map.Entry::getKey)
                            .findFirst();
                    return Map.entry(country.get(), car);
                })
                .filter(entry -> !entry.getKey().equals("TheyAreNotGoingAnywhere"))
                .collect(groupingBy(Map.Entry::getKey, mapping(Map.Entry::getValue, toList())))
                .entrySet().stream()
                .collect(toMap(Map.Entry::getKey,
                        entry -> entry.getValue()
                                .stream()
                                .mapToDouble(Car::getMass)
                                .sum() / 1000 * 7.14
                ))
                .entrySet().stream()
                .peek(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue());
                }).collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (o1, o2) -> o1, LinkedHashMap::new))
                .values().stream()
                .mapToDouble(v -> v)
                .reduce(0, Double::sum);
    }


    public static Double task15() {
        return FLOWERS.stream()
                .sorted(Comparator.comparing(Flower::getOrigin).reversed()
                        .thenComparing(Flower::getPrice)
                        .thenComparing(Flower::getWaterConsumptionPerDay).reversed()
                )
                .filter(flower -> flower.getCommonName().matches("^[SRQPONMLKJIHGFEDCsrqponmlkjihgfedc]+"))
                .filter(Flower::isShadePreferred)
                .filter(flower -> flower.getFlowerVaseMaterial().contains("Glass") ||
                        flower.getFlowerVaseMaterial().contains("Aluminum") ||
                        flower.getFlowerVaseMaterial().contains("Steel"))
                .map(flower -> flower.getPrice() + (flower.getWaterConsumptionPerDay()*365/1000*5))
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public static List<Student> task16() {
        return STUDENTS.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(comparing(Student::getSurname))
                .peek(e -> System.out.println("surname: " + e.getSurname() + ", age: " + e.getAge() ))
                .collect(Collectors.toList());
    }

    public static List<String> task17() {
        return STUDENTS.stream()
                .map(Student::getGroup)
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }

    public static Map<String, Double> task18() {
        return STUDENTS.stream()
                .collect(groupingBy(Student::getFaculty, averagingInt(Student::getAge)))
                .entrySet().stream()
                .sorted(comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (o1, o2) -> o1, LinkedHashMap::new));
    }

    public static List<Student> task19(String group) {
        return STUDENTS.stream()
                .filter(student -> student.getGroup().equals(group))
                .filter((student) -> EXAMINATIONS.stream()
                        .filter(examination -> examination.getStudentId()==student.getId())
                        .findFirst()
                        .filter(examination -> examination.getExam3() > 4).isPresent())
                .collect(Collectors.toList());
    }

    public static Map<String, Double> task20() {
        return STUDENTS.stream()
                .filter(student -> EXAMINATIONS.stream()
                        .anyMatch(examination -> examination.getStudentId()==student.getId()))
                .collect(groupingBy(Student::getFaculty, averagingInt(student -> EXAMINATIONS.stream()
                        .filter(examination -> examination.getStudentId()==student.getId())
                        .findFirst()
                        .map(Examination::getExam1).get())))
                .entrySet().stream()
                .max(comparingByValue())
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (o1, o2) -> o1, LinkedHashMap::new));
    }

    public static Map<String, Long> task21() {
        return STUDENTS.stream()
                .collect(groupingBy(Student::getGroup, counting()));

    }

    public static Map<String, Integer> task22() {
        Map<String, Integer> result = new LinkedHashMap<>();
        STUDENTS.stream()
                .collect(groupingBy(Student::getFaculty, minBy(Comparator.comparingInt(Student::getAge))))
                .forEach((key, value) -> result.put(key, value.get().getAge()));
        return result;
    }
}
