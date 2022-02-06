import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class EmployeesWorkCalendarTest {

    @Test
    void getWorkdayRecord() {
        var labCode = new LabourCode(40, 4, 60, 1.5, 12);
        var testEmp = new Employee(10, labCode);
        LocalDate date = LocalDate.of(2022, 12, 22);
        testEmp.addWorkdayRecord(date, 6);

        Assertions.assertEquals(6, testEmp.getWorkdayRecord(date));
    }

    @Test
    void calculateWorkedHoursPerWeek() {
        var labCode = new LabourCode(40, 4, 60, 1.5, 12);
        var employee = new Employee(10, labCode);
        var date = LocalDate.of(2022, 4, 4);
        employee.fillWeek7days(date, 10);

        Assertions.assertEquals(70, employee.workCalendar.calculateWorkedHoursPerWeek(date));
    }

    @Test
    void calculateWorkedHoursPerMonth() {
        //Do I need to do tests for this if I use this method in another test(s)?
    }

    @Test
    void fillWeek() {
        //Do I need to do tests for this if I use this method in another test(s)?
    }
}