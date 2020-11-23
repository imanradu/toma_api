package restassured.util;

import org.apache.commons.lang3.RandomUtils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utils {

    private static Random rand = new Random();

    public static long randomNumberByDigits(int numberOfDigits) {
        long startInclusive = (long) Math.pow(10, numberOfDigits - 1);
        long endExclusive = (long) Math.pow(10, numberOfDigits);

        return RandomUtils.nextLong(startInclusive, endExclusive);
    }

    public static StringBuilder missingFields(String response, String[] model) {
        StringBuilder missingFields = new StringBuilder();
        for (String field : model) {
            if (!response.contains(field)) {
                missingFields.append(field).append(", ");
            }
        }
        return missingFields;
    }

    public static Object nullToZero(Object fieldToConvert) {
        if (fieldToConvert == null) {
            fieldToConvert = 0;
        }
        return fieldToConvert;
    }

    public static String getDateTimePlusHours(int hour, String timezone) {
        ZoneId zoneId = ZoneId.of(timezone);
        return ZonedDateTime.now(zoneId).plusHours(hour)
                            .format(DateTimeFormatter.ISO_INSTANT);
    }

    public static String getDateTimeMinusHours(int hour, String timezone) {
        ZoneId zoneId = ZoneId.of(timezone);
        return ZonedDateTime.now(zoneId).minusHours(hour)
                            .format(DateTimeFormatter.ISO_INSTANT);
    }
}
