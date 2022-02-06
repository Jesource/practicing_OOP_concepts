import java.time.LocalDate;
import java.util.HashMap;

public class EmployeesWorkCalendar {

    HashMap<LocalDate, Double> workHoursCalendar = new HashMap<>();

    public void addWorkdayRecord(LocalDate day, double workdayHours) {
        workHoursCalendar.put(day, getWorkdayRecord(day) + workdayHours);
    }

    public double getWorkdayRecord(LocalDate day) {
        if (workHoursCalendar.get(day) == null) {
            return  0;
        } else {
            return workHoursCalendar.get(day);
        }
    }

    private int detectDayOfWeek(LocalDate day) {
        return day.getDayOfWeek().getValue();
    }

    private LocalDate getFirstDayOfWeek(LocalDate date) {
        return date.minusDays(detectDayOfWeek(date)).plusDays(1);
    }

    public int calculateWorkedHoursPerWeek(LocalDate date) {
        var firstWeekDate = getFirstDayOfWeek(date);
        int workedHours = 0;

        for (LocalDate start = firstWeekDate; start.isBefore(date.plusDays(7)); start = start.plusDays(1)) {
            workedHours += getWorkdayRecord(start);
        }

        return workedHours;
    }


    private LocalDate getFirstDayOfMonth(LocalDate date) {
        return date.minusDays(date.getDayOfMonth()).plusDays(1);
    }

    public int calculateWorkedHoursPerMonth(LocalDate date) {
        int workedHours = 0;
        var firstMonthDayDate = getFirstDayOfMonth(date);
        var lastMonthDayDate = firstMonthDayDate.plusMonths(1).minusDays(1);

        for (LocalDate start = firstMonthDayDate; start.isBefore(lastMonthDayDate.plusDays(1)); start = start.plusDays(1)) {
            workedHours += getWorkdayRecord(start);
        }

        return workedHours;
    }

    public void fillWeek7days(LocalDate date, double hoursPerDay, LabourCode labourCode) {
        for (LocalDate start = date; start.isBefore(date.plusDays(7)); start = start.plusDays(1)) {
            if ((getWorkdayRecord(start) + hoursPerDay) > labourCode.maxHoursPerDay()) {
                throw new IllegalArgumentException("Shift Work Hours Error: trying to insert too much hours per shift! (Inserting: " + (getWorkdayRecord(start) + hoursPerDay)
                        + "; maximum allowed is: "
                        + labourCode.maxHoursPerDay() + ")");
            } else {
                addWorkdayRecord(start, (hoursPerDay + getWorkdayRecord(start)));
            }
        }
    }
}
