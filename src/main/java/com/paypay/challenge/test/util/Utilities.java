package com.paypay.challenge.test.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Provides utility method(s) used in testing.
 * 
 * @author hoang.tran
 */
public class Utilities {
    /**
     * Converts date from String to Date.
     * 
     * @param date
     *            the {@code String} representing date in the form of 'yyyy-MM-dd'.
     * @return
     *         <ul>
     *         <li>the {@code Date} object representing the input {@code String}
     *         date.</li>
     *         <li>{@code null} if any errors occur during the parse of the input
     *         {@code date} parameter.</li>
     *         </ul>
     */
    public static Date stringToDate(String date) {
	try {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    return formatter.parse(date);
	} catch (ParseException e) {
	    return null;
	}
    }
}