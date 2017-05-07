
package com.kayshin.paytmlabs.model;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kayshin.paytmlabs.Environment;
import com.kayshin.paytmlabs.constant.CurrencyString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Rates {

    private final static String TAG = Rates.class.getName();

    private HashMap<String, Double> exchangeRateMap;
    private List<String> currencyBaseList = new ArrayList<String>();

    @SerializedName("AUD")
    @Expose
    private Double aUD;
    @SerializedName("BGN")
    @Expose
    private Double bGN;
    @SerializedName("BRL")
    @Expose
    private Double bRL;
    @SerializedName("CHF")
    @Expose
    private Double cHF;
    @SerializedName("CAD")
    @Expose
    private Double cAD;
    @SerializedName("CNY")
    @Expose
    private Double cNY;
    @SerializedName("CZK")
    @Expose
    private Double cZK;
    @SerializedName("DKK")
    @Expose
    private Double dKK;
    @SerializedName("GBP")
    @Expose
    private Double gBP;
    @SerializedName("HKD")
    @Expose
    private Double hKD;
    @SerializedName("HRK")
    @Expose
    private Double hRK;
    @SerializedName("HUF")
    @Expose
    private Double hUF;
    @SerializedName("IDR")
    @Expose
    private Double iDR;
    @SerializedName("ILS")
    @Expose
    private Double iLS;
    @SerializedName("INR")
    @Expose
    private Double iNR;
    @SerializedName("JPY")
    @Expose
    private Double jPY;
    @SerializedName("KRW")
    @Expose
    private Double kRW;
    @SerializedName("MXN")
    @Expose
    private Double mXN;
    @SerializedName("MYR")
    @Expose
    private Double mYR;
    @SerializedName("NOK")
    @Expose
    private Double nOK;
    @SerializedName("NZD")
    @Expose
    private Double nZD;
    @SerializedName("PHP")
    @Expose
    private Double pHP;
    @SerializedName("PLN")
    @Expose
    private Double pLN;
    @SerializedName("RON")
    @Expose
    private Double rON;
    @SerializedName("RUB")
    @Expose
    private Double rUB;
    @SerializedName("SEK")
    @Expose
    private Double sEK;
    @SerializedName("SGD")
    @Expose
    private Double sGD;
    @SerializedName("THB")
    @Expose
    private Double tHB;
    @SerializedName("TRY")
    @Expose
    private Double tRY;
    @SerializedName("USD")
    @Expose
    private Double uSD;
    @SerializedName("ZAR")
    @Expose
    private Double zAR;
    @SerializedName("EUR")
    @Expose
    private Double eUR;

    public Double getAUD() {
        return aUD;
    }

    public void setAUD(Double aUD) {
        this.aUD = aUD;
    }

    public Double getBGN() {
        return bGN;
    }

    public void setBGN(Double bGN) {
        this.bGN = bGN;
    }

    public Double getBRL() {
        return bRL;
    }

    public void setBRL(Double bRL) {
        this.bRL = bRL;
    }

    public Double getCAD() {
        return cAD;
    }

    public void setCAD(Double cAD) {
        this.cAD = cAD;
    }

    public Double getCHF() {
        return cHF;
    }

    public void setCHF(Double cHF) {
        this.cHF = cHF;
    }

    public Double getCNY() {
        return cNY;
    }

    public void setCNY(Double cNY) {
        this.cNY = cNY;
    }

    public Double getCZK() {
        return cZK;
    }

    public void setCZK(Double cZK) {
        this.cZK = cZK;
    }

    public Double getDKK() {
        return dKK;
    }

    public void setDKK(Double dKK) {
        this.dKK = dKK;
    }

    public Double getGBP() {
        return gBP;
    }

    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

    public Double getHKD() {
        return hKD;
    }

    public void setHKD(Double hKD) {
        this.hKD = hKD;
    }

    public Double getHRK() {
        return hRK;
    }

    public void setHRK(Double hRK) {
        this.hRK = hRK;
    }

    public Double getHUF() {
        return hUF;
    }

    public void setHUF(Double hUF) {
        this.hUF = hUF;
    }

    public Double getIDR() {
        return iDR;
    }

    public void setIDR(Double iDR) {
        this.iDR = iDR;
    }

    public Double getILS() {
        return iLS;
    }

    public void setILS(Double iLS) {
        this.iLS = iLS;
    }

    public Double getINR() {
        return iNR;
    }

    public void setINR(Double iNR) {
        this.iNR = iNR;
    }

    public Double getJPY() {
        return jPY;
    }

    public void setJPY(Double jPY) {
        this.jPY = jPY;
    }

    public Double getKRW() {
        return kRW;
    }

    public void setKRW(Double kRW) {
        this.kRW = kRW;
    }

    public Double getMXN() {
        return mXN;
    }

    public void setMXN(Double mXN) {
        this.mXN = mXN;
    }

    public Double getMYR() {
        return mYR;
    }

    public void setMYR(Double mYR) {
        this.mYR = mYR;
    }

    public Double getNOK() {
        return nOK;
    }

    public void setNOK(Double nOK) {
        this.nOK = nOK;
    }

    public Double getNZD() {
        return nZD;
    }

    public void setNZD(Double nZD) {
        this.nZD = nZD;
    }

    public Double getPHP() {
        return pHP;
    }

    public void setPHP(Double pHP) {
        this.pHP = pHP;
    }

    public Double getPLN() {
        return pLN;
    }

    public void setPLN(Double pLN) {
        this.pLN = pLN;
    }

    public Double getRON() {
        return rON;
    }

    public void setRON(Double rON) {
        this.rON = rON;
    }

    public Double getRUB() {
        return rUB;
    }

    public void setRUB(Double rUB) {
        this.rUB = rUB;
    }

    public Double getSEK() {
        return sEK;
    }

    public void setSEK(Double sEK) {
        this.sEK = sEK;
    }

    public Double getSGD() {
        return sGD;
    }

    public void setSGD(Double sGD) {
        this.sGD = sGD;
    }

    public Double getTHB() {
        return tHB;
    }

    public void setTHB(Double tHB) {
        this.tHB = tHB;
    }

    public Double getTRY() {
        return tRY;
    }

    public void setTRY(Double tRY) {
        this.tRY = tRY;
    }

    public Double getUSD() {
        return uSD;
    }

    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    public Double getZAR() {
        return zAR;
    }

    public void setZAR(Double zAR) {
        this.zAR = zAR;
    }

    public Double getEUR() {
        return eUR;
    }

    public void setEUR(Double eUR) {
        this.eUR = eUR;
    }

    // =============================================================================
    // HELPER METHODS
    // =============================================================================

    /**
     *
     * @return rates object that initialized the hashmap used to get rates for each currency and
     * arraylist of currency that is sorted alphabetically
     */
    public Rates initialize() {
        exchangeRateMap = new HashMap<String, Double>();
        exchangeRateMap.put(CurrencyString.AUD, getAUD());
        exchangeRateMap.put(CurrencyString.BGN, getBGN());
        exchangeRateMap.put(CurrencyString.BRL, getBRL());
        exchangeRateMap.put(CurrencyString.CAD, getCAD());
        exchangeRateMap.put(CurrencyString.CHF, getCHF());
        exchangeRateMap.put(CurrencyString.CNY, getCNY());
        exchangeRateMap.put(CurrencyString.CZK, getCZK());
        exchangeRateMap.put(CurrencyString.DKK, getDKK());
        exchangeRateMap.put(CurrencyString.EUR, getEUR());
        exchangeRateMap.put(CurrencyString.GBP, getGBP());
        exchangeRateMap.put(CurrencyString.HKD, getHKD());
        exchangeRateMap.put(CurrencyString.HRK, getHRK());
        exchangeRateMap.put(CurrencyString.HUF, getHUF());
        exchangeRateMap.put(CurrencyString.IDR, getIDR());
        exchangeRateMap.put(CurrencyString.ILS, getILS());
        exchangeRateMap.put(CurrencyString.INR, getINR());
        exchangeRateMap.put(CurrencyString.JPY, getJPY());
        exchangeRateMap.put(CurrencyString.KRW, getKRW());
        exchangeRateMap.put(CurrencyString.MXN, getMXN());
        exchangeRateMap.put(CurrencyString.MYR, getMYR());
        exchangeRateMap.put(CurrencyString.NOK, getNOK());
        exchangeRateMap.put(CurrencyString.NZD, getNZD());
        exchangeRateMap.put(CurrencyString.PHP, getPHP());
        exchangeRateMap.put(CurrencyString.PLN, getPLN());
        exchangeRateMap.put(CurrencyString.RON, getRON());
        exchangeRateMap.put(CurrencyString.RUB, getRUB());
        exchangeRateMap.put(CurrencyString.SEK, getSEK());
        exchangeRateMap.put(CurrencyString.SGD, getSGD());
        exchangeRateMap.put(CurrencyString.THB, getTHB());
        exchangeRateMap.put(CurrencyString.TRY, getTRY());
        exchangeRateMap.put(CurrencyString.USD, getUSD());
        exchangeRateMap.put(CurrencyString.ZAR, getZAR());

        //remove currency that does not exist
        Iterator<Map.Entry<String,Double>> iter = exchangeRateMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String,Double> entry = iter.next();
            if(entry.getValue() == null){
                iter.remove();
            }
        }

        exchangeRateMap.put(Environment.CURRENCY_BASE, 1.0000);

        currencyBaseList = new ArrayList<String>(exchangeRateMap.keySet());
        Collections.sort(currencyBaseList, new nameComparator());

        return this;
    }

    /**
     *
     * @param currencyBase update the current exchangeRateMap based on the currencyBase
     */
    public void updateCurrency(String currencyBase){
        double foreignCurrencyScale = 1.0 / exchangeRateMap.get(currencyBase);
        for (Map.Entry<String, Double> entry : exchangeRateMap.entrySet()) {
            Double rate = entry.getValue();
            String key = entry.getKey();
            double newValue = foreignCurrencyScale * rate;
            exchangeRateMap.put(key, newValue);
        }
    }


    public static class nameComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            try {
                return (o1.toLowerCase()).compareTo(o2.toLowerCase());
            } catch (Exception e) {
                return 0;
            }
        }
    }

    public List<String> getCurrencyBaseList(){
        return currencyBaseList == null ? new ArrayList<String>() : currencyBaseList;
    }

    public Double getRate(String currency){
        try {
            if(exchangeRateMap.containsKey(currency)) {
                if(exchangeRateMap.get(currency) == null) {
                    return 1.0;
                } return exchangeRateMap.get(currency);

            }
        } catch (Exception e) {
            Log.e(TAG, e.toString() + " exchangeRateMap doesn't have currency");
        }
        return 1.0;
    }
}
