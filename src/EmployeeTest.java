import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class EmployeeTest {

    @Test
    void getWorkdayRecord() {
        var labourCode_task1 = new LabourCode(40, 4, 60, 1.5, 12);
        var testEmp = new Employee(10, labourCode_task1);
        LocalDate date = LocalDate.of(2022, 12, 22);

        Assertions.assertEquals(0, testEmp.getWorkdayRecord(date));

        testEmp.addWorkdayRecord(date, 10);
        Assertions.assertEquals(10, testEmp.getWorkdayRecord(date));


        testEmp.addWorkdayRecord(date, 1);
        Assertions.assertEquals(11, testEmp.getWorkdayRecord(date));
    }

    @Test
    void getSalaryBasedOnADay() {
        var labourCode_task1 = new LabourCode(40, 4, 60, 1.5, 12);
        var testEmp = new Employee(10, labourCode_task1);
        LocalDate date = LocalDate.of(2022, 12, 22);

        testEmp.fillWeek7days(date, 5);
        LocalDate date2 = date.plusDays(1);
        Assertions.assertEquals(50, testEmp.getSalaryBasedOnADay(date2));

        testEmp.addWorkdayRecord(date2, 5);
        Assertions.assertEquals(100, testEmp.getSalaryBasedOnADay(date2));
    }

    @Test
    void getSalaryForMonth() {
        var labourCode_task1 = new LabourCode(40, 4, 60, 1.5, 12);
        var testEmp = new Employee(10, labourCode_task1);

        testEmp.fillWeek7days(LocalDate.of(2022, 1, 22), 5);
        testEmp.fillWeek7days(LocalDate.of(2022, 1, 2), 5);


        Assertions.assertEquals(700, testEmp.getSalaryForMonth(2022, 1));
    }

}