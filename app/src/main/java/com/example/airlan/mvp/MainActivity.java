package com.example.airlan.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements UserView{

    private Button button1,button2;
    private EditText editText1,editText2;
    private ProgressBar rationBar;
    private UserPresenter presenter;
    //private IUserB iu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }
    public void Init(){
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        rationBar=(ProgressBar)findViewById(R.id.rationBr);
        //iu=new IUserB();
        presenter=new UserPresenter(this);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.Login();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clear();
            }
        });
    }

    @Override
    public String getName() {
        return editText1.getText().toString();
    }

    @Override
    public String getNumber() {
        return editText2.getText().toString();
    }

    @Override
    public void ClearName() {
        editText1.setText("");
    }

    @Override
    public void ClearNumber() {
        editText2.setText("");
    }

    @Override
    public void ShowLoading() {
            rationBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void HideLoading() {
            rationBar.setVisibility(View.GONE);
    }

    @Override
    public void ToMainActvity(User user) {
        Toast.makeText(this,user.getUserName()+"success login MainActivity",Toast.LENGTH_SHORT).show();;
    }

    @Override
    public void showError() {
        Toast.makeText(this,"Login Error",Toast.LENGTH_SHORT).show();
    }
}
