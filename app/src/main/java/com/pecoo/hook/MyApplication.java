package com.pecoo.hook;

import android.app.Application;


import com.pecoo.hook.utils.HookAmsUtil;

/**
 *@author YangZhenYu
 *created at 17-5-16 上午10:47
 *功能：初始化我们的钩子。ProxyActivity就是一个正常的代理activity，需要在清单文件中注册好
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HookAmsUtil amsUtil = new HookAmsUtil(ProxyActivity.class,this);
        //在入口处挂一个钩子，代理意图替换掉真意图
        amsUtil.hookAms();
        //在出口处挂一个钩子，真意图替换掉代理意图
        amsUtil.hookSystemHandler();
    }


}