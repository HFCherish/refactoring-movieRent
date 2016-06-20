import java.util.Calendar;

public class RentTime {
    private int durationDays;
    private Calendar startDate;
    private Calendar endDate;

    public RentTime(Calendar startDate, int durationDays){
        this.startDate = startDate;
        this.durationDays = durationDays;
        endDate = startDate;
        endDate.add(Calendar.DATE, this.durationDays);
    }

    public int getDurationDays() {
        return durationDays;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }
}
