package com.dateroullete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener {


    EditText etUsername, etPassword;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword= (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);



    }


    @Override
    public void processFinish(String result) {
        if(result.equals("success")) {
            Intent in = new Intent(this, Welcome.class);
            startActivity(in);
        }
        else{
            Toast.makeText(this, "Login Failed!", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onClick(View v) {

        HashMap postData = new HashMap();
        //postData.put("btnLogin", "Login");
        postData.put("mobile", "android");
        postData.put("txtUsername", etUsername.getText().toString());
        postData.put("txtPassword", etPassword.getText().toString());



        PostResponseAsyncTask task = new PostResponseAsyncTask(this,postData);
        task.execute("http://10.0.2.2/~franklynvictoria/clients/login.php");
    }
}
