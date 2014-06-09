package com.morgan.barcodescannerapp.scanner;

import android.content.Intent;
import android.net.Uri;
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

/**
 * Created by Eugene Kamadi on 6/6/2014.
 */
public class LoginActivity extends ActionBarActivity {

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



                String username = ((EditText) findViewById(R.id.username_edittext)).getText().toString();
                String password = ((EditText) findViewById(R.id.password_edittext)).getText().toString() ;

                if(correctUsernameAndPasswordEntered(username, password)) {

                    Intent intent = new Intent(getApplicationContext(),SignActivity.class);



                    startActivity(intent) ;

                } else {
                    Toast.makeText(getApplicationContext(),
                                new String("Incorrect username or password"),
                                Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    private boolean correctUsernameAndPasswordEntered(String username, String  password) {
        return true ;
    }
}
