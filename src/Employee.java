import java.time.LocalDate;

public class Employee {
    private double wagePerHour = 0;

    private final LabourCode labourCode;
    public final EmployeesWorkCalendar workCalendar = new EmployeesWorkCalendar();

/*
    DONE?: get restrictions from restriction file (like Law object / Labour code)
    DONE: add tests
    Notes:
    checked and unchecked exceptions (read more)
        checked - expected and code should recover from it (for example 'connection timed out')
        unchecked - user input mistake
            runtime exceptions
*/

    public Employee(double wagePerHour, LabourCode labourCode) {
        this.labourCode = labourCode;
        hourlyWageCheck(wagePerHour);
    }

    private void hourlyWageCheck(double baseHourlyWage) {
        if (baseHourlyWage >= labourCode.MinWagePerHour()) {
            this.wagePerHour = baseHourlyWage;
        } else {
            // error action
            throw new IllegalArgumentException("Pay Rate Error: it is lower than minimal allowed (" + labourCode.MinWagePerHour() + ")." + " Received: " + baseHourlyWage);
        }
    }

    public void addWorkdayRecord(LocalDate day, double workHours) {
        if (isValidShiftWorkHours(workHours + getWorkdayRecord(day))) {
            workCalendar.addWorkdayRecord(day, workHours);
        } else {
            // error action
            throw new IllegalArgumentException("Shift Work Hours Error: incorrect work hours! (Received " + workHours + ")");
        }
    }

    private boolean isValidShiftWorkHours(double workHours) {
        return workHours <= labourCode.maxHoursPerDay();
    }

    public double getWorkdayRecord(LocalDate day) {
        return workCalendar.getWorkdayRecord(day);
    }

    public double getSalaryBasedOnADay(LocalDate day) {
        return calculateSalaryForParticularDay(day);
    }

    private double calculateSalaryForParticularDay(LocalDate day) {
        //TODO need to search for maximum allowed hours per shift (12h in Lithuania) and figure out when overwork starts
        return workCalendar.getWorkdayRecord(day) * wagePerHour;
    }

    public double getSalaryForMonth(int year, int month) {
        var firstMonthDay = LocalDate.of(year, month, 1);
        return wagePerHour * workCalendar.calculateWorkedHoursPerMonth(firstMonthDay);
    }

    public void fillWeek7days(LocalDate date, double hoursPerDay) {
        if (hoursPerDay > labourCode.maxHoursPerDay()) {
            throw new IllegalArgumentException("Shift Work Hours Error: incorrect work hours! (Received " + hoursPerDay + ", maximum allowed is "
                    + labourCode.maxHoursPerDay() + ")");
        }
        workCalendar.fillWeek7days(date, hoursPerDay, labourCode);
    }
}
