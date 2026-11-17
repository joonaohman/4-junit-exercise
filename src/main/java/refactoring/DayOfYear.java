package refactoring;

public class DayOfYear {

    public static int dayOfYear(int month, int dayOfMonth, int year) {
        return dayOfYearFixed(month, dayOfMonth, year);
    }

    public static int dayOfYearFixed(int month, int dayOfMonth, int year) {

        int[] daysInMonths = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        boolean leapYear =
                (year % 400 == 0)
                || (year % 4 == 0 && year % 100 != 0);

        if (leapYear) {
            daysInMonths[1] = 29;
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }

        if (dayOfMonth < 1 || dayOfMonth > daysInMonths[month - 1]) {
            throw new IllegalArgumentException("Invalid day");
        }

        int dayOfYear = dayOfMonth;

        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonths[i];
        }

        return dayOfYear;
    }
}