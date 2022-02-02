import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void addWorkdayRecord() {
    }

    @Test
    void getWorkdayRecord() {
        var labourCode_task1 = new LabourCode(40, 4, 60, 1.5, 12);
        var testEmp = new Employee(40, 10, labourCode_task1);
        LocalDate date = LocalDate.of(2022, 12, 22);

//        System.out.println("testEmp worked " + testEmp.getWorkdayRecord(date) + " hours at " + date + " and earned " + testEmp.getSalaryBasedOnADay(date));
        Assertions.assertEquals(0, testEmp.getWorkdayRecord(date));

        testEmp.addWorkdayRecord(date, 10);
//        System.out.println("testEmp worked " + testEmp.getWorkdayRecord(date) + " hours at " + date + " and earned " + testEmp.getSalaryBasedOnADay(date));
        Assertions.assertEquals(10, testEmp.getWorkdayRecord(date));


        testEmp.addWorkdayRecord(date, 1);
//        System.out.println("testEmp worked " + testEmp.getWorkdayRecord(date) + " hours at " + date + " and earned " + testEmp.getSalaryBasedOnADay(date));
        Assertions.assertEquals(11, testEmp.getWorkdayRecord(date));
    }

    @Test
    void getSalaryBasedOnADay() {
        var labourCode_task1 = new LabourCode(40, 4, 60, 1.5, 12);
        var testEmp = new Employee(40, 10, labourCode_task1);
        LocalDate date = LocalDate.of(2022, 12, 22);

        testEmp.fillWeek(date, 5);
        LocalDate date2 = date.plusDays(1);
//        System.out.println("testEmp worked " + testEmp.getWorkdayRecord(date2) + " hours at " + date2 + " and earned " + testEmp.getSalaryBasedOnADay(date2));
        Assertions.assertEquals(50, testEmp.getSalaryBasedOnADay(date2));

        testEmp.addWorkdayRecord(date2, 5);
        Assertions.assertEquals(100, testEmp.getSalaryBasedOnADay(date2));

//        System.out.println("testEmp worked " + testEmp.getWorkdayRecord(date2) + " hours at " + date2 + " and earned " + testEmp.getSalaryBasedOnADay(date2));
    }

    @Test
    void getSalaryForMonth() {
        var labourCode_task1 = new LabourCode(40, 4, 60, 1.5, 12);
        var testEmp = new Employee(40, 10, labourCode_task1);
        LocalDate date = LocalDate.of(2022, 1, 22);

        testEmp.fillWeek(date, 5);
//        System.out.println("In January 2022 testEmp earned " + testEmp.getSalaryForMonth(2022, 1));
    }

}