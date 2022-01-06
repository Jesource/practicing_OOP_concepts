import java.time.LocalDate;

public class Employee {
    private double weeklyWorkHours = 0;
    private double salary = 0;
    private double wagePerHour = 0;

    private final LabourCode labourCode;
    private final EmployeesWorkCalendar workCalendar = new EmployeesWorkCalendar();


    public Employee(double weeklyWorkHours, double wagePerHour, LabourCode labourCode) {
        this.labourCode = labourCode;
        hourlyWageCheck(wagePerHour);
        setWeeklyWorkHours(weeklyWorkHours);
    }

    private void hourlyWageCheck(double baseHourlyWage) {
        if (baseHourlyWage >= labourCode.MinWagePerHour()) {
            this.wagePerHour = baseHourlyWage;
        } else {
            // error action
            throw new IllegalArgumentException("Pay Rate Error: it is lower than minimal allowed (" + labourCode.MinWagePerHour() + ")." + " Received: " + baseHourlyWage);
        }
    }

    private void setSalary() {
        double overworkHours = weeklyWorkHours - labourCode.StandardWorkHoursPerWeek();
        if (overworkHours < 0) overworkHours = 0;
        salary = (weeklyWorkHours - overworkHours) * wagePerHour + (overworkHours * labourCode.OverworkMultiplier()) * wagePerHour;
    }

    public void setWeeklyWorkHours(double weeklyWorkHours) {
        if (isValidWorkHours()) {
            // error action
            throw new IllegalArgumentException("Weekly Work Hours Error: incorrect work hours! (Received " + weeklyWorkHours + ")");
        } else {
            this.weeklyWorkHours = weeklyWorkHours;
            setSalary();
        }
    }

    private boolean isValidWorkHours() {
        return weeklyWorkHours > labourCode.MaxHoursPerWeek() || weeklyWorkHours < 0;
    }

    public double getSalary() {
        return salary;
    }

    public void addWorkdayRecord(LocalDate day, double workHours) {
        if (isValidShiftWorkHours(workHours)) {
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
        return salary = workCalendar.getWorkdayRecord(day) * wagePerHour;
    }
}
