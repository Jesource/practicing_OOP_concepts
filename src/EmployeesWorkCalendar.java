import java.time.LocalDate;
import java.util.HashMap;

public class EmployeesWorkCalendar {

    HashMap<LocalDate, Double> workHoursCalendar = new HashMap<>();

    public void addWorkdayRecord(LocalDate day, double workdayHours) {
        workHoursCalendar.put(day, workdayHours);
    }

    public double getWorkdayRecord(LocalDate day) {
        return workHoursCalendar.get(day);
    }
}
