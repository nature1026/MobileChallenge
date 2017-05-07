package com.kayshin.paytmlabs.model.cache;

import android.content.Context;

import com.google.gson.reflect.TypeToken;
import com.kayshin.paytmlabs.Environment;
import com.kayshin.paytmlabs.model.ForeignExchange;

import java.lang.reflect.Type;

/**
 * Created by Kay on 2017-05-05.
 */

public class ForeignExchangeCache extends CacheBase {

    private static final String CACHE_ID_FOREIN_EXCHANGE = "CACHE_ID_FOREIN_EXCHANGE";
    private static final String CACHE_FOREIN_EXCHANGE_FILE_NAME = "ForeinExchange.json";

    public ForeignExchangeCache(Context context){
        super(context, CACHE_FOREIN_EXCHANGE_FILE_NAME);
    }

    public void saveBase(ForeignExchange foreignExchange) {
        String responseJson = gson.toJson(foreignExchange);
        Cache cachedData = find(CACHE_ID_FOREIN_EXCHANGE);
        if (cachedData == null) {
            cachedData = new Cache(CACHE_ID_FOREIN_EXCHANGE);
        }
        cachedData.setJsonResponse(responseJson);
        save(cachedData);
    }

    public ForeignExchange getForeignExchagneCache() {
        ForeignExchange foreignExchange = null;
        Cache foundCache = find(CACHE_ID_FOREIN_EXCHANGE);
        if (isCacheValid()) {
            Type listType = new TypeToken<ForeignExchange>() {
            }.getType();
            foreignExchange = gson.fromJson(foundCache.getJsonResponse(), listType);
        }
        return foreignExchange;
    }

    public boolean isCacheValid(){
        Cache cache = find(CACHE_ID_FOREIN_EXCHANGE);
        return cache != null && Environment.CACHE_LIFETIME_IN_MILLIS > System.currentTimeMillis() - cache.getTimeStamp();
    }
}
