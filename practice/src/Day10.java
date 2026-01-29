import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day10 {

    public void task() {
        //Build a Set<String> of all unique skills across departments
        List<Department> departments = List.of(
                new Department(List.of(new Employee("John", List.of("Java", "Python")), new Employee("Alice", List.of("C++", "Go")))),
                new Department(List.of(new Employee("Bob", List.of("JavaScript", "Rust")), new Employee("Charlie", List.of("Kotlin", "Swift"))))
        );

       Set<String> uniqueSkills = new HashSet<>();
       List<String> employeesNames = departments.stream().flatMap(d -> d.employees.stream().map(e -> e.name)).toList();
       uniqueSkills = departments.stream().flatMap(d -> d.employees.stream().map(e -> e.skills))
               .flatMap(Collection::stream).collect(Collectors.toSet());// collect unique skills into a Set;

        System.out.println("Unique skills across departments: " + uniqueSkills);
        System.out.println("Employee names across departments: " + employeesNames);
    }
}


class Department{
    List<Employee> employees;
    Department(List<Employee> employees){
        this.employees = employees;
    }
}

class Employee{
    String name;
    List<String> skills;
    Employee(String name, List<String> skills){
        this.name = name;
        this.skills = skills;
    }
}

void main(String[] args) {
    new Day10().task();
}

