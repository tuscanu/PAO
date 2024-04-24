import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        List<Student> students = Arrays.asList(
                new Student(20),
                new Student(25),
                new Student(20),
                new Student(30),
                new Student(25)
        );


        Map<Integer, List<Student>> groupedByAge = students.stream()
                .collect(Collectors.groupingBy(Student::getAge));


        groupedByAge.forEach((age, studentList) -> System.out.println("Age: " + age + " => " + studentList));
    }
}
