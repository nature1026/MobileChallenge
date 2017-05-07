package com.kayshin.paytmlabs.model.cache;

/**
 * Created by Kay on 2017-05-05.
 */

public class Cache {

    private String id;
    private String jsonResponse;
    private long timeStamp;

    public Cache(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public long getTimeStamp(){
        return timeStamp;
    }

    public String getJsonResponse(){
        return jsonResponse;
    }

    public void setJsonResponse(String responseJson) {
        jsonResponse = responseJson;
        timeStamp = System.currentTimeMillis();
    }
}
