/*
 * Copyright 2017 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.

 */

package com.danmo.commonapi.base;

public class Constant {
    public static final int PARSE_DEFAULT = 0;
    public static final int PARSE_GSON = 1;
    public static final int PARSE_XML = 2;
    public static final int SUCCESS = 0;//接口获取成功
    public static final int ERROR = 500;//接口异常
/*    public static final String BASE_URL= "http://192.168.52.34:8080/action/market/";//host*/
 /*  public static final String BASE_URL= "http://192.168.51.242:80/action/market/";//host*/
    public static final String sign="tnpower2018";//登录接口验签标识
    //正式服务器地址
    public static final String BASE_URL = "http://47.111.73.206:8081/app/";
    public static final String IMAGE_URL ="http://47.111.73.206:8889/";

}
