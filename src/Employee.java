public class Employee {
    private double workHours = 0;
    private double salary = 0;
    private double basePayRate = 0;
    private static final int overworkBoundary = 40;
    private static final int hourLimit = 60;
    private static final double overworkMultiplier = 1.5;
    private static final int minimalHourlyWage = 4;

    //TODO: ask what we should do if incorrect data is given


    public Employee(double workHours, double basePayRate) {
        basePayRateCheck(basePayRate);
        setWorkHours(workHours);
    }

    private void basePayRateCheck(double basePayRate) {
        if (basePayRate >= minimalHourlyWage) {
            this.basePayRate = basePayRate;
//            System.out.println("Pay rate is set.");
        } else {
            System.out.println("Pay rate is not accepted: it is lower than minimal allowed.");
            // error action
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
            System.out.println("Error: incorrect work hours!");
            // error action
        } else {
            this.workHours = workHours;
//            System.out.println("Work hours accepted");
            setSalary();
        }
    }

    public double getSalary() {
        return salary;
    }
}
