package com.kayshin.paytmlabs.retro;

import com.kayshin.paytmlabs.model.ForeignExchange;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kay on 2017-04-19.
 */

public interface ApiService {
    @GET("/latest")
    Call<ForeignExchange> getMyJSON(@Query("base") String base);
}
