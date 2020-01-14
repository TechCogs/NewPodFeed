/*
 * NPFDate.java
 *
 * Created on May 11, 2007, 6:52 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package newpodfeed;

import java.util.*;

/**
 *
 * @author newpodfeed
 */
public class NPFDate {
    
    Calendar now;
    String date;
    
    /** Creates a new instance of NPFDate */
    public NPFDate() {
        now = Calendar.getInstance();
        date = "";
    }
    
    public String getDay() {
        switch(now.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.SUNDAY:  return "Sun";
            case Calendar.MONDAY:  return "Mon";
            case Calendar.TUESDAY:  return "Tue";
            case Calendar.WEDNESDAY:  return "Wed";
            case Calendar.THURSDAY:  return "Thu";
            case Calendar.FRIDAY:  return "Fri";
            case Calendar.SATURDAY:  return "Sat";
            default:  return "Mon";
        }
    }
    
    public int getDate() {
        return now.get(Calendar.DATE);
    }
    
    public String getMonth() {
        switch(now.get(Calendar.MONTH)) {
            case Calendar.JANUARY:  return "Jan";
            case Calendar.FEBRUARY:  return "Feb";
            case Calendar.MARCH:  return "Mar";
            case Calendar.APRIL:  return "Apr";
            case Calendar.MAY:  return "May";
            case Calendar.JUNE:  return "Jun";
            case Calendar.JULY:  return "Jul";
            case Calendar.AUGUST:  return "Aug";
            case Calendar.SEPTEMBER:  return "Sep";
            case Calendar.OCTOBER:  return "Oct";
            case Calendar.NOVEMBER:  return "Nov";
            case Calendar.DECEMBER:  return "Dec";
            default:  return "Jan";
        }
    }
    
    public int getYear() {
        return now.get(Calendar.YEAR);
    }
    
    public String getTime() {
        /* The method returns an int, so we convert it to a String */
        String hour = "" + now.get(Calendar.HOUR_OF_DAY);
        /* We check to see if the hour is single digit, and if so, we
        add a 0 to the beginning to make it comply with the RFC2822 standard
        for date and hour formats in RSS feeds.
        */
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        hour += ":00:00 GMT";
        return hour;
        //return now.get(Calendar.HOUR_OF_DAY) + ":00:00 GMT";
    }
    
    public String toString() {
        return getDay() + ", " + getDate() + " " + getMonth() + " " + getYear() + " " + getTime();
    }
    
}