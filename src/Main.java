import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        tests();
    }

    private static void tests() {
        System.out.println("\n - - - TESTS - - -");

        var labourCode_task1 = new LabourCode(40, 4, 60, 1.5, 12);



        var testEmp = new Employee(40, 10, labourCode_task1);

        LocalDate date = LocalDate.of(2022, 12, 22);
        testEmp.addWorkdayRecord(date, 10);

        System.out.println("testEmp worked " + testEmp.getWorkdayRecord(date) + " hours at " + date + " and earned " + testEmp.getSalaryBasedOnADay(date));



        var emp1 = new Employee(41, 4, labourCode_task1);
        System.out.println(resultAsMessage("Emp1 salary test", 166, emp1.getSalary()));

        var emp2 = new Employee(19, 33, labourCode_task1);
        System.out.println(resultAsMessage("Emp2 salary test", 627, emp2.getSalary()));

        var emp3 = new Employee(60, 8, labourCode_task1);
        System.out.println(resultAsMessage("Emp3 salary test", 560, emp3.getSalary()));
    }

    private static String resultAsMessage(String testCaseName, double expected, double actual) {
        return expected == actual
                ? testCaseName + ": " + "\u001B[32m" + "PASS" + "\u001B[0m"
                : testCaseName + ": " + "\u001B[31m" + "FAIL" + "\u001B[0m" + " (expected " + expected + ", actual " + actual + ", ensure you have not changed related data)";
    }
}
