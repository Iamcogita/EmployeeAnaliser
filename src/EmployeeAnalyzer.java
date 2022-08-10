import employee.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeAnalyzer {

    public void employeesEnrolledOverNumberYears(List<Employee> department , int numberYears){
        Calendar c = Calendar.getInstance();
        System.out.println(department.stream().filter(f -> (c.get(Calendar.YEAR) - f.getStartingYear()) > numberYears).count() + " employees:");
        department.stream().filter(f -> (c.get(Calendar.YEAR) - f.getStartingYear()) > numberYears)
                .forEach(e -> System.out.println(e.getFullName()));
        System.out.println("-----");
    }

    public void employeeSalaryOverN(List<Employee> department, int baseSalary){
        System.out.printf("Employees with a Salary higher than %s : \n" , baseSalary );
        department.stream().filter(f -> f.getSalary() > baseSalary )
                .forEach(e -> System.out.println(e.getFullName())) ;
        System.out.println("-----");
    }


    public void findOldestEmployees(List<Employee> department, long howMany){
        System.out.printf("Most Senior %s Employees :\n" , howMany);
        department.stream().sorted( (a,b) -> b.getAge() - a.getAge() )
                .limit(howMany).forEach( e -> System.out.println( e.getFullName()));
        System.out.println("-----");
    }

    public void findFirstOlderThan(List<Employee> department , int age){ //this one could break
        System.out.println("Result:");
        System.out.println(department.stream().filter(f -> f.getAge() > age)
                .sorted(Comparator.comparingInt(Employee::getAge))
                .findFirst().get().getFullName());
        System.out.println("-----");
    }


    public void findFirstOldest(List<Employee> department , int age){
        System.out.println("Result:");
        Optional<Employee> opt = department.stream().filter(e -> e.getAge() > age )
                .sorted(Comparator.comparingInt(Employee::getAge)).findFirst();
        if(!opt.isPresent()){
            System.out.println("No such employees.");
        }
        System.out.println(opt.get().getFullName());
        System.out.println("-----");
    }

    public void getAverageSalary( List<Employee> department ){
        System.out.println("The Average Salary for that department is:");
        System.out.println(department.stream().mapToInt(f -> f.getSalary()).average().getAsDouble());
        System.out.println("-----");
    }

    public void findCommonNames(List<Employee> department1 , List<Employee> department2){
        System.out.println("Duplicate names in both departments:");
        HashSet<String> names = new HashSet<>();
        department1.stream().forEach(e -> names.add(e.getFirstName()));
        department2.stream().forEach(e -> names.add(e.getFirstName()));
        for (String name: names){
            if(department1.stream().anyMatch(s1 -> s1.getFirstName() == name
                    && department2.stream().anyMatch(s2 -> s2.getFirstName() == name)))
            {System.out.println(name);}
        }
        System.out.println("-----");
    }

    public List<String> commonNamesSetList(List<Employee> department1, List<Employee> department2){
        String line = "-";
        System.out.println("Common first names between departments: \n" + line.repeat(30));

        Set<String> uniqueNames = department1.stream().map(Employee::getFirstName).collect(Collectors.toSet());
        return department2.stream().map(Employee::getFirstName).distinct().filter(uniqueNames::contains).toList();
    }

}