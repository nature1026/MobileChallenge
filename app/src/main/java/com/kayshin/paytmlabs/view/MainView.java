package com.kayshin.paytmlabs.view;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.kayshin.paytmlabs.model.ForeignExchange;

import java.util.List;

/**
 * Created by Kay on 2017-05-04.
 */

public interface MainView {

    Context getContext();

    /**
     *
     * @param currencyList list of currency bases
     */
    void showSpinnerAdapter(List<String> currencyList);
    void updateAdapterData(ForeignExchange foreignExchange);

    /**
     *
     * @param foreignExchange foreign exchange data that's downloaded
     * @param currencyBase currency the rates will be based on
     */
    void updateCurrencyBase(ForeignExchange foreignExchange, String currencyBase);
    void showProgressBar();
    void hideProgressBar();
    void showError(String msg);

}
