package com.example.airlan.mvp;

/**
 * Created by Airlan on 2016/8/11.
 */
public interface UserView {
    public String getName();
    public String getNumber();
    public void ClearName();
    public void ClearNumber();
    public void ShowLoading();
    public void HideLoading();
    public void ToMainActvity(User user);
    public void showError();
}
