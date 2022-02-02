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

        for (LocalDate start = firstWeekDate; start.isBefore(date.plusDays(5)); start = start.plusDays(1)) {
            workedHours += getWorkdayRecord(start);
//            System.out.println("On " + start.getDayOfWeek() + " (" + start + ") employee worked for " + getWorkdayRecord(start) + " hours, " + workedHours + " hours this week.");
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

//        System.out.println("First day is " + firstMonthDayDate + " and last month day is " + lastMonthDayDate);

        for (LocalDate start = firstMonthDayDate; start.isBefore(lastMonthDayDate.plusDays(1)); start = start.plusDays(1)) {
            workedHours += getWorkdayRecord(start);
//            System.out.println("On " + start + " employee worked for " + getWorkdayRecord(start) + " hours, " + workedHours + " hours this month.");
        }

        return workedHours;
    }

    public void fillWeek(LocalDate date, double hoursPerDay) {
        for (LocalDate start = date; start.isBefore(date.plusDays(7)); start = start.plusDays(1)) {
            addWorkdayRecord(start, hoursPerDay);
        }
    }
}
