package eapli.base.app.common.console.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The type Date util.
 */
public class DateUtil {
    private static final String[] dateSeparators = {"/", "-", " "};

    private static final String DMY_FORMAT = "dd{sep}MM{sep}yyyy";

    private static final String dmy_template = "\\d{2}{sep}\\d{2}{sep}\\d{4}.*";

    /**
     * To date date.
     *
     * @param rawDate the raw date
     * @return the date
     */
    public static Date toDate(String rawDate) {
        Date date = null;
        String dateFormat = getDateFormat(rawDate);

        if (dateFormat != null) {
            for (String sep : dateSeparators) {
                String actualDateFormat = patternForSeparator(dateFormat, sep);
                date = tryParse(rawDate, actualDateFormat);

                if (date != null) {
                    return date;
                }
            }
        }

        System.out.println("Invalid date format!");

        return date;
    }

    private static String getDateFormat(String date) {
        for (String sep : dateSeparators) {
            String dmyPattern = patternForSeparator(dmy_template, sep);
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
