package com.kayshin.paytmlabs.model.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kay on 2017-05-05.
 */

public abstract class CacheBase {

    private static final String TAG = CacheBase.class.getName();
    protected Gson gson;
    private File cacheFile;

    public CacheBase(Context context, String cacheFileName){
        cacheFile = new File(context.getCacheDir(), cacheFileName);
        gson = new Gson();
    }


    protected List<Cache> getCachedDataList() {
        List<Cache> cachedDataList = new ArrayList<>();

        String json = readCacheFile();
        if (!TextUtils.isEmpty(json)) {
            Type listType = new TypeToken<ArrayList<Cache>>() {
            }.getType();
            cachedDataList = new Gson().fromJson(json, listType);
        }
        return cachedDataList;
    }

    protected Cache find(String id) {
        Cache foundCachedData = null;
        Cache searchCachedData = new Cache(id);

        List<Cache> cachedDataList = getCachedDataList();
        for (Cache cd : cachedDataList) {
            if (searchCachedData.getId().equals(cd.getId())) {
                foundCachedData = cd;
                break;
            }
        }
        return foundCachedData;
    }

    private String readCacheFile() {
        String fileContent = null;
        int length = (int) cacheFile.length();
        if (length > 0) {
            try {
                byte[] bytes = new byte[length];
                FileInputStream in = new FileInputStream(cacheFile);
                in.read(bytes);
                in.close();
                fileContent = new String(bytes);
            } catch (IOException e) {
            }
        }
        return fileContent;
    }

    protected void save(Cache cachedData) {
        // Find and update object or create new one
        boolean found = false;
        List<Cache> cachedDataList = getCachedDataList();
        for (Cache cd : cachedDataList) {
            if (cachedData.getId().equals(cd.getId())) {
                cd.setJsonResponse(cachedData.getJsonResponse());
                found = true;
                break;
            }
        }
        if (!found) {
            cachedDataList.add(cachedData);
        }
        saveCacheFile(new Gson().toJson(cachedDataList));
    }

    private void saveCacheFile(String fileContent) {
        try {
            FileOutputStream stream = new FileOutputStream(cacheFile);
            stream.write(fileContent.getBytes());
            stream.close();
        } catch (IOException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }

}
