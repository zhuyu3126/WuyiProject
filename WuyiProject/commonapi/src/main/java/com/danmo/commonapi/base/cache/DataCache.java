package com.danmo.commonapi.base.cache;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.LruCache;

import com.danmo.commonutil.FileUtil;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 数据缓存工具可以同时使用内存缓存和磁盘缓存
 */
public class DataCache {
    private static int M = 1024 * 1024;
    ACache mDiskCache;//轻量级缓存框架类似Shardpfrence
    LruCache<String, Object> mLruCache;//内存缓存
    boolean isOpenDisLruCache=false;//是否开启磁盘缓存
    public Context context;
    /**
     * 图片硬盘缓存核心类。
     */


    public DataCache(Context context,boolean isOpenDisLruCache) {
        this.isOpenDisLruCache=isOpenDisLruCache;
        this.context=context;
        mDiskCache = ACache.get(new File(FileUtil.getExternalCacheDir(context.getApplicationContext(), "Ithouse-data")));
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        mLruCache = new LruCache<>(cacheSize);

    }
    /*
    * 是否开启磁盘缓存，默认不开
    * */
    public void setOpenDisLruCache(boolean openDisLruCache) {
        isOpenDisLruCache = openDisLruCache;
    }

    /**
     * 缓存List数据到内存缓存中
     * @param key
     * @param data
     * @param <T>
     */
    public <T extends Serializable> void saveListData(String key, List<T> data) {
        ArrayList<T> datas = (ArrayList<T>) data;
        mLruCache.put(key, datas);
        mDiskCache.put(key, datas, ACache.TIME_WEEK);     // 数据缓存时间为 1 周
        if(isOpenDisLruCache){
            DiskCache.getInstance(context)
                    .put(key, data);
        }

    }




    /**
     * 缓存object数据到内存缓存中
     * @param key
     * @param data
     * @param <T>
     */
    public <T extends Serializable> void saveData(@NonNull String key, @NonNull T data) {
        mLruCache.put(key, data);
        mDiskCache.put(key, data, ACache.TIME_WEEK);     // 数据缓存时间为 1 周
        if(isOpenDisLruCache){
            DiskCache.getInstance(context)
                    .put(key, data);
        }

    }


    /*
    * 获取内存缓存数据 如果内存缓存mLruCache中已经过期
    * */
    public <T extends Serializable> T getData(@NonNull String key) {
        T result = (T) mLruCache.get(key);
        if (result == null) {
            result = (T) mDiskCache.getAsObject(key);
            if (result != null) {
                mLruCache.put(key, result);
            }else if(isOpenDisLruCache){
                result=(T) DiskCache.getInstance(context).get(key);
            }
        }
        return result;
    }

    public void removeDate(String key) {
        if(null!=mLruCache.get(key)){
            mLruCache.remove(key);
        }
        mDiskCache.remove(key);
        if(isOpenDisLruCache){
            DiskCache.getInstance(context).remove(key);
        }
    }





}
