package utility;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Utilities {
    /**
     * Returns today's date
     *
     * @param pattern
     * @return
     */
    public static String getTodaysDate(String pattern) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    public static String getRandomTitle(String pattern) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    public static Date datesToModify(int daysToModify) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, daysToModify);
        return cal.getTime();
    }

    public static String getDateInFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy, HH:mm a");
        String finalDate = formatter.format(date);
        return finalDate;
    }

    public static String getDateInSimpleFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM");
        String finalDate = formatter.format(date);
        return finalDate;
    }

    public static String getDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        return formatter.format(date);
    }

    public static String getTimeStamp() {
        String timestamp = new Timestamp(System.currentTimeMillis()).toString();
        timestamp = timestamp.replace(".", "-").replace(":", "_").replace(" ", "_");
        return timestamp;

    }

    /**
     * Generates a random number between lower bound and upper bound
     *
     * @param lowerBound
     * @param upperBound
     * @return
     */
    public static int getRandomNumberBetween(int lowerBound, int upperBound) {
        return Integer.valueOf(new Random().nextInt(upperBound - lowerBound) + lowerBound);
    }
}
