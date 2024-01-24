package eapli.base.app.common.console.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Date util.
 */
public class DateTimeUtil {
    private static final String[] timeFormats = {"HH:mm:ss", "HH:mm"};
    private static final String[] dateSeparators = {"/", "-", " "};

    private static final String DMY_FORMAT = "dd{sep}MM{sep}yyyy";
    private static final String YMD_FORMAT = "yyyy{sep}MM{sep}dd";

    private static final String ymd_template = "\\d{4}{sep}\\d{2}{sep}\\d{2}.*";
    private static final String dmy_template = "\\d{2}{sep}\\d{2}{sep}\\d{4}.*";

    public static Date toDateTime(String input) {
        Date date = null;
        String dateFormat = getDateFormat(input);
        if (dateFormat == null) {
            throw new IllegalArgumentException("Date is not in an accepted format " + input);
        }

        for (String sep : dateSeparators) {
            String actualDateFormat = patternForSeparator(dateFormat, sep);
            for (String time : timeFormats) {
                date = tryParse(input, actualDateFormat + " " + time);
                if (date != null) {
                    return date;
                }
            }
            date = tryParse(input, actualDateFormat);
            if (date != null) {
                return date;
            }
        }
        System.out.println("Invalid date format!");

        return date;
    }

    private static String getDateFormat(String date) {
        for (String sep : dateSeparators) {
            String ymdPattern = patternForSeparator(ymd_template, sep);
            String dmyPattern = patternForSeparator(dmy_template, sep);
            if (date.matches(ymdPattern)) {
                return YMD_FORMAT;
            }
            if (date.matches(dmyPattern)) {
                return DMY_FORMAT;
            }
        }
        return null;
    }

    private static String patternForSeparator(String template, String sep) {
        return template.replace("{sep}", sep);
    }

    private static Date tryParse(String input, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(input);
        } catch (ParseException e) {
        }
        return null;
    }
}