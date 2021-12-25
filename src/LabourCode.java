public class LabourCode {

    //    private double maxHoursPerDay;      // per workday/shift    // 12 h
    //    private double maxOverworkHoursPerWeek; //  48h

    private double standardWorkHoursPerWeek;    // 40h
    private double minWagePerHour;              // 3.93
    private double maxHoursPerWeek;             // 60h
    private double overworkMultiplier;          // 1.5


    public LabourCode(double standardWorkHoursPerWeek, double minWagePerHour, double maxHoursPerWeek, double overworkMultiplier) {
        this.standardWorkHoursPerWeek = standardWorkHoursPerWeek;
        this.minWagePerHour = minWagePerHour;
        this.maxHoursPerWeek = maxHoursPerWeek;
        this.overworkMultiplier = overworkMultiplier;
    }

    public double getStandardWorkHoursPerWeek() {
        return standardWorkHoursPerWeek;
    }

    public double getMinWagePerHour() {
        return minWagePerHour;
    }

    public double getMaxHoursPerWeek() {
        return maxHoursPerWeek;
    }

    public double getOverworkMultiplier() {
        return overworkMultiplier;
    }
}
