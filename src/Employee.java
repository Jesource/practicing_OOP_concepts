public class Employee {
    private double workHours = 0;
    private double salary = 0;
    private double WagePerHour = 0;

    // - - - VALUES TAKEN FROM LabourCode CLASS - - -
    private double standardWorkHoursPerWeek;    // 40h
    private double minWagePerHour;              // 3.93
    private double maxHoursPerWeek;             // 60h
    private double overworkMultiplier;          // 1.5

    private LabourCode labourCode;

/*
    DONE: ask what we should do if incorrect data is given (throwing exception)
    TODO: get restrictions from restriction file (like Law object / Labour code)
    TODO: add tests
    Notes:
    checked and unchecked exceptions (read more)
        checked - expected and code should recover from it (for example 'connection timed out')
        unchecked - user input mistake
            runtime exceptions
*/


    public Employee(double workHours, double WagePerHour, LabourCode labourCode) {
        this.labourCode = labourCode;
        setConstants();
        basePayRateCheck(WagePerHour);
        setWorkHours(workHours);
    }

    private void setConstants() {
        standardWorkHoursPerWeek = labourCode.getStandardWorkHoursPerWeek();
        minWagePerHour = labourCode.getMinWagePerHour();
        maxHoursPerWeek = labourCode.getMaxHoursPerWeek();
        overworkMultiplier = labourCode.getOverworkMultiplier();
    }

    private void basePayRateCheck(double basePayRate) {
        if (basePayRate >= minWagePerHour) {
            this.WagePerHour = basePayRate;
        } else {

            // error action
            throw new IllegalArgumentException("Pay Rate Error: it is lower than minimal allowed.");
        }
    }

    private void setSalary() {
        double overworkHours = workHours - standardWorkHoursPerWeek;
        if (overworkHours < 0) overworkHours = 0;
        salary = (workHours - overworkHours) * WagePerHour + (overworkHours * overworkMultiplier) * WagePerHour;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        if (workHours > maxHoursPerWeek || workHours < 0) {

            // error action
            throw new IllegalArgumentException("Work Hours Error: incorrect work hours!");
        } else {
            this.workHours = workHours;
            setSalary();
        }
    }

    public double getSalary() {
        return salary;
    }
}
