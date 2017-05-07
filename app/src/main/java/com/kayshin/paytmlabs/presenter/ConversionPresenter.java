package com.kayshin.paytmlabs.presenter;

/**
 * Created by Kay on 2017-05-04.
 */

public interface ConversionPresenter {
    void updateCurrencyBase(String baseCurrency);

    /**
     *
     * @param showProgressBar whether to show progressBar in main screen while downloading
     * @param forceRefresh ignore the cache data and force refresh
     */
    void initialize(boolean showProgressBar, boolean forceRefresh);
    void destroy();
}
