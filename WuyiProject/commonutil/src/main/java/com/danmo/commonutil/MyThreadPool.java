package com.danmo.commonutil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by tnsap10 on 2019/6/25.zhuyu 线程池
 */

public class MyThreadPool {
    public static MyThreadPool instance;
    private ExecutorService cachedExecutor= Executors.newCachedThreadPool();//创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
    private ExecutorService singleExecutor=Executors.newSingleThreadExecutor();//创建一个定长线程池，支持定时及周期性任务执行Android中单线程可用于数据库操作，文件操作，应用批量安装，应用批量删除等
    public static MyThreadPool getInstance(){
        if(null==instance){
            synchronized (MyThreadPool.class){
                if(null==instance){
                    instance=new MyThreadPool();
                }
            }

        }
        return  instance;
    }
    /*
    * */
    public ExecutorService getCachedExecutor(){
        return cachedExecutor;
    }
    public ExecutorService getSingleExecutor(){
        return singleExecutor;
    }


}
