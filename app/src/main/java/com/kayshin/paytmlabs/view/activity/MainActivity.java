package com.kayshin.paytmlabs.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.kayshin.paytmlabs.Environment;
import com.kayshin.paytmlabs.R;
import com.kayshin.paytmlabs.model.ForeignExchange;
import com.kayshin.paytmlabs.presenter.ConversionPresenterImp;
import com.kayshin.paytmlabs.utility.Util;
import com.kayshin.paytmlabs.view.MainView;
import com.kayshin.paytmlabs.view.ViewUI;
import com.kayshin.paytmlabs.view.adapter.ConversionAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView, TextWatcher, AdapterView.OnItemSelectedListener, SwipeRefreshLayout.OnRefreshListener {

    private final String TAG = MainActivity.class.getName();
    private ConversionPresenterImp conversionPresenterImp;

    @Bind(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.pbConversionRate)
    ProgressBar pbConversionRate;
    @Bind(R.id.srl)
    SwipeRefreshLayout srl;
    @Bind(R.id.rvConversionRateTable)
    RecyclerView rvConversionRateTable;
    ConversionAdapter conversionAdapter;
    @Bind(R.id.etCurrency)
    EditText etCurrency;
    @Bind(R.id.spCurrency)
    Spinner spCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        etCurrency.addTextChangedListener(this);
        etCurrency.setSelection(etCurrency.getText().length());
        spCurrency.setOnItemSelectedListener(this);
        srl.setOnRefreshListener(this);
        rvConversionRateTable.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, Environment.NUM_COLUMNS);
        rvConversionRateTable.setLayoutManager(layoutManager);

        conversionAdapter = new ConversionAdapter(MainActivity.this);
        rvConversionRateTable.setAdapter(conversionAdapter);

        if (conversionPresenterImp == null) {
            conversionPresenterImp = new ConversionPresenterImp(this);
        }
        conversionPresenterImp.initialize(true, false);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void updateAdapterData(ForeignExchange foreignExchange) {
        if(foreignExchange != null) conversionAdapter.updateData(foreignExchange);
    }

    @Override
    public void showProgressBar() {
        pbConversionRate.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbConversionRate.setVisibility(View.GONE);
        srl.setRefreshing(false);
    }

    @Override
    public void showError(String msg) {
        ViewUI.showMessage(coordinatorLayout, getString(R.string.error_network), getString(R.string.button_retry), new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conversionPresenterImp.initialize(true, false);
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String inputCurrency = editable.toString();
        if(inputCurrency.equals("")) {
            conversionAdapter.updateCurrency(0.0);
        } else {
            try {
                double num = Double.parseDouble(inputCurrency);
                conversionAdapter.updateCurrency(num);
                Log.i(TAG, num+" is a number");
            } catch (NumberFormatException e) {
                Toast.makeText(this, " Please enter a valid number ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void showSpinnerAdapter(List<String> spinnerDataList) {
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerDataList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCurrency.setAdapter(dataAdapter);

        int defaultSelection = Util.getPostiton(spinnerDataList, Environment.CURRENCY_BASE);
        if(defaultSelection != -1 )spCurrency.setSelection(defaultSelection);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String currencyBase = adapterView.getItemAtPosition(i).toString();
        conversionPresenterImp.updateCurrencyBase(currencyBase);
    }

    @Override
    public void updateCurrencyBase(ForeignExchange foreignExchange, String currencyBasse) {
        conversionAdapter.updateCurrencyBase(foreignExchange, currencyBasse);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    public void onRefresh() {
        conversionPresenterImp.initialize(false, true);
        ViewUI.showMessage(coordinatorLayout, getString(R.string.toast_currency_updated));
    }
}
