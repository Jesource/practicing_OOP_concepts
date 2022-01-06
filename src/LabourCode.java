public class LabourCode {

    //    private double maxOverworkHoursPerWeek; //  48h

    private double minWagePerHour;              // 3.93
    private double maxHoursPerWeek;             // 60h
    private double overworkMultiplier;          // 1.5
    private double standardWorkHoursPerWeek;    // 40h

    // - - - NEW VALUES - - -
    private double maxHoursPerDay;      // per workday/shift    // 12 h

    public LabourCode(double standardWorkHoursPerWeek, double minWagePerHour, double maxHoursPerWeek, double overworkMultiplier, double maxHoursPerDay) {
        this.standardWorkHoursPerWeek = standardWorkHoursPerWeek;
        this.minWagePerHour = minWagePerHour;
        this.maxHoursPerWeek = maxHoursPerWeek;
        this.overworkMultiplier = overworkMultiplier;
        this.maxHoursPerDay = maxHoursPerDay;
    }

    public double StandardWorkHoursPerWeek() {
        return standardWorkHoursPerWeek;
    }

    public double MinWagePerHour() {
        return minWagePerHour;
    }

    public double maxHoursPerDay() {
        return maxHoursPerDay;
    }

    public double MaxHoursPerWeek() {
        return maxHoursPerWeek;
    }

    public double OverworkMultiplier() {
        return overworkMultiplier;
    }
}
