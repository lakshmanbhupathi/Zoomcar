package com.lakshman.sample.zoomcar.utils;

import java.util.Date;

public final class DateUtils {
    private DateUtils() {
    }

    public static boolean isBetween(Date date, Date dateStart, Date dateEnd) {
        boolean result = false;
        if (date != null && dateStart != null && dateEnd != null) {
            if (date.after(dateStart) && date.before(dateEnd)) {
                result = true;
            }
        }
        return result;
    }

    public static boolean areDatesEqual(Date date, Date dateStart, Date dateEnd){
        boolean result = false;
        if (date != null && dateStart != null && dateEnd != null) {
            if(date.equals(dateStart) || date.equals(dateEnd)){
                result = true;
            }
        }
        return result;
    }
}
