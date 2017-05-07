package com.kayshin.paytmlabs.utility;

import java.util.List;

/**
 * Created by Kay on 2017-05-07.
 */

public class Util {
    public static int getPostiton(List<String> currencyList, String currency) {
        if(currencyList == null) return -1;
        for (int i = 0; i < currencyList.size(); i++) {
            if (currencyList.get(i).equals(currency)) return i;
        }
        return -1;
    }
}
