package com.kayshin.paytmlabs;

public class Environment {
    public static long CACHE_LIFETIME_IN_MILLIS = 1000  * 60 * 30;      //30 MINUTES
    public static String CURRENCY_BASE = "CAD";                         //Quote Rates against CAD
    public static String CURRENCY_RATE_ROUND = "%.2f";                  //round the currency to Two
    public static String CURRENCY_RATE_SCIENTIFIC_NOTATION = "%.2e";    //when the numbers are too big, use scientific notation
    public static final int NUM_COLUMNS = 4;                            //number of columns in grid layouts to show each currency
}
