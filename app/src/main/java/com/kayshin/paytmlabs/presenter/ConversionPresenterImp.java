package com.kayshin.paytmlabs.presenter;

import com.kayshin.paytmlabs.model.ForeignExchange;
import com.kayshin.paytmlabs.model.ForeignExchangeRepository;
import com.kayshin.paytmlabs.view.MainView;

/**
 * Created by Kay on 2017-05-04.
 */

public class ConversionPresenterImp implements ConversionPresenter, ForeignExchangeRepository.RatesListListener {

    private MainView mainView;
    private ForeignExchangeRepository foreignExchangeRepository;
    public ConversionPresenterImp(MainView mainView){
        this.mainView = mainView;
        foreignExchangeRepository = new ForeignExchangeRepository(mainView.getContext());
    }

    @Override
    public void updateCurrencyBase(String currencyBase) {
        mainView.showProgressBar();
        foreignExchangeRepository.updateCurrencyBase(this, currencyBase);
    }

    @Override
    public void onCurrencyBaseUpdated(ForeignExchange foreignExchange, String currencyBase){
        mainView.hideProgressBar();
        mainView.updateCurrencyBase(foreignExchange, currencyBase);
    }

    @Override
    public void initialize(boolean showProgressBar, boolean forceRefresh) {
        if(showProgressBar) mainView.showProgressBar();
        foreignExchangeRepository.getRates(this, forceRefresh);
    }

    @Override
    public void destroy() {
        mainView = null;
        foreignExchangeRepository = null;
    }

    @Override
    public void onRatesReceived(ForeignExchange foreignExchange) {
        mainView.hideProgressBar();
        mainView.updateAdapterData(foreignExchange);
        mainView.showSpinnerAdapter(foreignExchange.getRates().getCurrencyBaseList());
    }

    @Override
    public void onFail(String msg) {
        mainView.hideProgressBar();
        mainView.showError(msg);
    }
}
