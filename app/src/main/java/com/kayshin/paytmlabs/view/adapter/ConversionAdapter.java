package com.kayshin.paytmlabs.view.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.kayshin.paytmlabs.Environment;
import com.kayshin.paytmlabs.R;
import com.kayshin.paytmlabs.model.ForeignExchange;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.kayshin.paytmlabs.Environment.CURRENCY_BASE;

/**
 * Created by Kay on 2017-05-04.
 */

public class ConversionAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<String> currencyList;
    private ForeignExchange foreignExchange;
    private double inputCurrency = 1.0;
    private String currencyBase = CURRENCY_BASE;

    public ConversionAdapter(Context context) {
        this.context = context;
        currencyList = new ArrayList<String>();
    }

    public void updateData(ForeignExchange foreignExchange){
        this.foreignExchange = foreignExchange;
        this.currencyList = foreignExchange.getRates().getCurrencyBaseList();
        notifyDataSetChanged();
    }

    public void updateCurrency(double inputCurrency){
        this.inputCurrency = inputCurrency;
        notifyDataSetChanged();
    }

    public void updateCurrencyBase(ForeignExchange foreignExchange, String currencyBase){
        this.foreignExchange = foreignExchange;
        this.currencyBase = currencyBase;
        notifyDataSetChanged();
    }

    public class CurrencyViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView tvCurrency;
        public TextView tvRate;

        public CurrencyViewHolder(View v) {
            super(v);
            mView = v;
            tvCurrency = (TextView)  v.findViewById(R.id.tvCurrency);
            tvRate = (TextView)  v.findViewById(R.id.tvRate);
            v.setTag(this);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CurrencyViewHolder(
                LayoutInflater.from(context).inflate(R.layout.list_item_currency, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        CurrencyViewHolder currencyViewHolder = (CurrencyViewHolder) holder;
        String currency = currencyList.get(position);
        currencyViewHolder.tvCurrency.setText(currency);
         double rate = foreignExchange.getRates().getRate(currency);
        double convertedValue = inputCurrency * rate;

        String outputCurrency;
        outputCurrency = String.format(Environment.CURRENCY_RATE_ROUND, convertedValue);
        if(outputCurrency.length() > 10) outputCurrency = String.format(Environment.CURRENCY_RATE_SCIENTIFIC_NOTATION, convertedValue);

        currencyViewHolder.tvRate.setText(outputCurrency);
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }
}
