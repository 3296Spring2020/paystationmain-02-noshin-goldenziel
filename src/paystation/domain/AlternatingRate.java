package paystation.domain;

import java.time.DayOfWeek;

public class AlternatingRate implements RateStrategy {

    private RateStrategy rs;

    @Override
    public int calculateTime(int moneyInserted) {
        DayOfWeek dayOfWeek = DayOfWeek.from(java.time.LocalDate.now());
        int day = dayOfWeek.getValue(); // Uses java.time to calculate the day of the week

        if (day == 1 || day == 2 || day == 3 || day == 4 || day == 5) { // Monday-Friday
            rs = new ProgressiveRate();
        } else { // Saturday-Sunday
            rs = new LinearRate();
        }

        return rs.calculateTime(moneyInserted);
    }

}
