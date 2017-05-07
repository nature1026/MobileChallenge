package com.kayshin.paytmlabs.model;

import android.content.Context;

import com.kayshin.paytmlabs.Environment;
import com.kayshin.paytmlabs.model.cache.ForeignExchangeCache;
import com.kayshin.paytmlabs.presenter.ConversionPresenter;
import com.kayshin.paytmlabs.retro.ApiService;
import com.kayshin.paytmlabs.retro.RetroClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kay on 2017-05-05.
 */

public class ForeignExchangeRepository {

    private static final String TAG = ForeignExchangeRepository.class.getName();
    private ForeignExchange foreignExchange;
    private ForeignExchangeCache foreinExchangeCache;

    public ForeignExchangeRepository(Context context){
        foreinExchangeCache = new ForeignExchangeCache(context);
    }

    /**
     *
     * @param ratesListListener Listener that listens to data download
     * @param forceRefresh whether to use cache or force download
     */
    public void getRates(final RatesListListener ratesListListener, boolean forceRefresh){
        //1. check if cache exists - if yes,
        // 1.1 see if cache's expired - if no, use it
        //2. if expired, download and cache
        if(!forceRefresh && foreinExchangeCache.isCacheValid()) {
            ForeignExchange foreignExchange = foreinExchangeCache.getForeignExchagneCache();
            ForeignExchangeRepository.this.foreignExchange = foreignExchange;
            foreignExchange.getRates().initialize();
            ratesListListener.onRatesReceived(foreignExchange);
        } else {
            ApiService api = RetroClient.getApiService();
            Call<ForeignExchange> call = api.getMyJSON(Environment.CURRENCY_BASE);
            call.enqueue(new Callback<ForeignExchange>() {
                @Override
                public void onResponse(Call<ForeignExchange> call, Response<ForeignExchange> response) {
                    if(response.isSuccessful()) {
                        ForeignExchange foreignExchange = response.body();
                        ForeignExchangeRepository.this.foreignExchange = foreignExchange;
                        foreinExchangeCache.saveBase(foreignExchange);
                        foreignExchange.getRates().initialize();
                        ratesListListener.onRatesReceived(foreignExchange);
                    }
                }
                @Override
                public void onFailure(Call<ForeignExchange> call, Throwable t) {
                    ratesListListener.onFail(t.getMessage());
                }
            });
        }
    }

    public void updateCurrencyBase(RatesListListener ratesListListener, String currencyBase){
        foreignExchange.getRates().updateCurrency(currencyBase);
        ratesListListener.onCurrencyBaseUpdated(foreignExchange, currencyBase);
    }

    public interface RatesListListener {
        void onRatesReceived(ForeignExchange foreignExchange);
        void onFail(String msg);
        void onCurrencyBaseUpdated(ForeignExchange foreignExchange, String currencyBase);
    }
}
