package com.xujun.funapp.common;

import android.os.Environment;

import java.io.File;

/**
 * Created by xujun、on 2016/5/5.
 */
public class Constants {
    public static final String REQUEST_SUC = "0";//请求成功
    public final static String FIRST = "first";
    public final static String PATH = "path";
    public final static String MD5 = "md5";
    public final static String KEY_LOCK_PWD = "lock_pwd";
    //是否设置了手势密码
    public final static String HAS_GES = "has_lock";
    public final static String CONFIG = "config";
    //用户上网token
    public final static String TOKEN = "token";
    //是否记住登陆密码
    public final static String IS_REMBER_PAS = "is_check";
    public final static String USER = "user";
    public final static String USERNAME = "user_name";
    // 用户ID
    public final static String ID = "staff_no";
    public final static String LOGIN_OUT = "login_out";
    public final static String BaseCachePath = Environment.getExternalStoragePublicDirectory("Download") + File.separator + APP.getInstance().getPackageName() + File.separator;



    public static class IntentConstants {
        public static final String DEFAULT_PARCEABLE_NAME = "DEFAULT_PARCEABLE_NAME";
        public static final String DEFAULT_PARCEABLE_LIST_NAME = "DEFAULT_PARCEABLE_LIST_NAME";
        public static final String Action_ChuanYueDetailActivity = "Action_ChuanYueDetailActivity";
        public static final String Action_PiYueDetailActivity = "Action_PiYueDetailActivity";
    }

    public static  class URLConstants{
        public static final String URL_IMAGE_BASE="http://tnfs.tngou.net/image";
    }
}
