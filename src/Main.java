import static db.DB.*;

public class Main {
    public static void main(String[] args) {

        EmployeeAnalyzer analyzer = new EmployeeAnalyzer();

        analyzer.employeesEnrolledOverNumberYears( getHrDepartment(), 4 );
        analyzer.employeeSalaryOverN( getSalesDepartment(), 1500 );
        analyzer.findOldestEmployees( getMarketingDepartment() , 5 );
        analyzer.findFirstOldest( getDevelopmentDepartment(),34 );
        analyzer.getAverageSalary( getMarketingDepartment() ) ;
        analyzer.findCommonNames( getHrDepartment(), getDevelopmentDepartment() );

    }
}
