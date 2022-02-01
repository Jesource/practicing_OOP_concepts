import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        tests();
    }

    private static void tests() {
        System.out.println("\n - - - TESTS - - -");

        var labourCode_task1 = new LabourCode(40, 4, 60, 1.5, 12);

        var testEmp = new Employee(40, 10, labourCode_task1);

        LocalDate date = LocalDate.of(2022, 12, 22);

        var emp1 = new Employee(41, 4, labourCode_task1);
        System.out.println(resultAsMessage("Emp1 salary test", 166, emp1.getSalary()));

        var emp2 = new Employee(19, 33, labourCode_task1);
        System.out.println(resultAsMessage("Emp2 salary test", 627, emp2.getSalary()));

        var emp3 = new Employee(60, 8, labourCode_task1);
        System.out.println(resultAsMessage("Emp3 salary test", 560, emp3.getSalary()));

        date = LocalDate.of(2022, Month.JANUARY, 25);
        fillWeek(date, testEmp);
        LocalDate date2 = date.plusDays(1);
        System.out.println("testEmp worked " + testEmp.getWorkdayRecord(date2) + " hours at " + date2 + " and earned " + testEmp.getSalaryBasedOnADay(date2));

        testEmp.addWorkdayRecord(date2, 5);

        System.out.println("testEmp worked " + testEmp.getWorkdayRecord(date2) + " hours at " + date2 + " and earned " + testEmp.getSalaryBasedOnADay(date2));

//        System.out.println("That week testEmp worked for: " + testEmp.workCalendar.calculateWorkedHoursPerWeek(date2) + " hours");
//        System.out.println("That month testEmp worked for: " + testEmp.workCalendar.calculateWorkedHoursPerMonth(date2) + " hours");

        System.out.println("That week testEmp worked for: " + testEmp.workCalendar.calculateWorkedHoursPerWeek(date2) + " hours");
        System.out.println("That month testEmp worked for: " + testEmp.workCalendar.calculateWorkedHoursPerMonth(date2) + " hours");

//        System.out.println("Month 4 is " + Month.of(4));

        System.out.println("In January 2022 testEmp earned " + testEmp.getSalaryForMonth(2022, 1));
    }

    private static void fillWeek(LocalDate date, Employee employee) {
        for (LocalDate start = date; start.isBefore(date.plusDays(7)); start = start.plusDays(1)) {
            employee.addWorkdayRecord(start, 5);
        }
    }

    private static String resultAsMessage(String testCaseName, double expected, double actual) {
        return expected == actual
                ? testCaseName + ": " + "\u001B[32m" + "PASS" + "\u001B[0m"
                : testCaseName + ": " + "\u001B[31m" + "FAIL" + "\u001B[0m" + " (expected " + expected + ", actual " + actual + ", ensure you have not changed related data)";
    }
}
