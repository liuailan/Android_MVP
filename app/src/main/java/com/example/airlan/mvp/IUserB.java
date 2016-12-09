package com.example.airlan.mvp;

import android.content.AbstractThreadedSyncAdapter;

/**
 * Created by Airlan on 2016/8/11.
 */
public class IUserB implements IUserBir {

    @Override
    public void Login(final String name, final String number, final OnLoginListen onLoginListen) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if("lal".equals(name)&&"123".equals(number)){
                    User user=new User();
                    user.setName(name);
                    user.setNumber(number);
                    onLoginListen.LoginSuccess(user);
                }
                else{
                    onLoginListen.LoginError();
                }
            }
        }.start();
    }
}
