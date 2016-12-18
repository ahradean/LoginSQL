package com.example.loginsql.Login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginsql.R;
import com.example.loginsql.Register.RegisterActivity;
import com.example.loginsql.database.SQLController;

public class MainActivity extends AppCompatActivity {

    private EditText loginName;
    private EditText passWord;
    private Button login_bt;
    private Button regis_bt;
    private SQLController databasecall;
    private Context mContext;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mContext = this;

        loginName = (EditText) findViewById(R.id.login_text);
        passWord = (EditText) findViewById(R.id.pass_text);
        login_bt = (Button) findViewById(R.id.login_button);
        regis_bt = (Button) findViewById(R.id.regis_account_button);

        databasecall = new SQLController(this);
        databasecall.open();
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkLogin();
            }
        });

        regis_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent main = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(main);
            }
        });
    }

    private void checkLogin() {
        String username = loginName.getText().toString();
        String password = passWord.getText().toString();

       /* login_bt.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(SQLController user, ParseException e) {
                if (e == null) {
                    Intent intent = new Intent(mContext, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });*/

    }
}
