package com.morgan.barcodescannerapp.scanner;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.TextView;

import com.morgan.barcodescannerapp.scanner.service.authentication.AuthenticationService;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Created by Eugene Kamadi on 6/6/2014.
 */
public class LoginActivity extends ActionBarActivity {

    private AuthenticationService authenticationService ;

    public LoginActivity() {
        authenticationService = new AuthenticationService();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login );

        Button loginButton = (Button) findViewById(R.id.log_In_btn) ;
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent data = new Intent();
               EditText username_edittext = (EditText) findViewById(R.id.username_edittext);
                EditText password_textview =(EditText)  findViewById(R.id.password_edittext);
                data.setData(Uri.parse(username_edittext.getText().toString()));

                setResult(RESULT_OK,data);
                finish();



                final String username = ((EditText) findViewById(R.id.username_edittext)).getText().toString();
                final String password = ((EditText) findViewById(R.id.password_edittext)).getText().toString() ;

                if(authenticationService.authenticate(username, password)) {
                    Intent intent = new Intent(getApplicationContext(),SignActivity.class);
                    startActivity(intent) ;
                } else {
                    Toast.makeText(getApplicationContext(),
                            new String("Incorrect username or password"),
                            Toast.LENGTH_LONG)
                            .show();
                }

                /*
                Authenticator.setDefault(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        PasswordAuthentication pa= new PasswordAuthentication(username,password.toCharArray());
                        System.out.println(pa.getUserName()+ ":" + new String(pa.getPassword()));
                    return pa;
                    }
                });
                */
            }
        });
    }

    private boolean correctUsernameAndPasswordEntered(String username, String  password) {
        return true ;
    }

    // thi is a trial






}
