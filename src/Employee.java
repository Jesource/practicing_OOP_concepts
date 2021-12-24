public class Employee {
    private double workHours = 0;
    private double salary = 0;
    private double basePayRate = 0;
    private static final int overworkBoundary = 40;
    private static final int hourLimit = 60;
    private static final double overworkMultiplier = 1.5;
    private static final int minimalHourlyWage = 4;

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


    public Employee(double workHours, double basePayRate) {
        basePayRateCheck(basePayRate);
        setWorkHours(workHours);
    }

    private void basePayRateCheck(double basePayRate) {
        if (basePayRate >= minimalHourlyWage) {
            this.basePayRate = basePayRate;
        } else {

            // error action
//            throw new Exception("Pay Rate Error: it is lower than minimal allowed.");
            throw new IllegalArgumentException("Pay Rate Error: it is lower than minimal allowed.");
        }
    }

    private void setSalary() {
        double overworkHours = workHours - overworkBoundary;
        if (overworkHours < 0) overworkHours = 0;
        salary = (workHours - overworkHours) * basePayRate + (overworkHours * overworkMultiplier) * basePayRate;
    }

    public double getWorkHours() {
        return workHours;
    }

    public void setWorkHours(double workHours) {
        if (workHours > hourLimit || workHours < 0) {
            // error action
//            throw new Exception("Work Hours Error: incorrect work hours!");
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
