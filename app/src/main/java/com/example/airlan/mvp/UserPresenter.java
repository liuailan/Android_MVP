package com.example.airlan.mvp;

import java.util.logging.Handler;

/**
 * Created by Airlan on 2016/8/11.
 */
public class UserPresenter {
    private IUserBir iuserbir;
    private UserView userView;
    private android.os.Handler handler;
    public UserPresenter(UserView view){
        userView=view;
        iuserbir=new IUserB();
        handler=new android.os.Handler();
    }

    public void Login(){
       userView.ShowLoading();
        iuserbir.Login(userView.getName(), userView.getNumber(), new OnLoginListen() {
            @Override
            public void LoginSuccess(final User user) {

              handler.post(new Runnable() {
                  @Override
                  public void run() {
                      userView.ToMainActvity(user);
                      userView.HideLoading();
                  }
              });
            }

            @Override
            public void LoginError() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.showError();
                        userView.HideLoading();
                    }
                });
            }
        });
    }

    public void clear(){
            userView.ClearName();
            userView.ClearNumber();
    }
}
