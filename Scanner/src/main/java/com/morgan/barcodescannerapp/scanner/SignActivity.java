package com.morgan.barcodescannerapp.scanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.security.PublicKey;

/**
 * Created by Eugene Kamadi on 6/6/2014.
 */
public class SignActivity extends ActionBarActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign );

        Button SignButton = (Button ) findViewById(R.id.signin);
        SignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();


                Intent intent = new Intent(getApplicationContext(),entryActivity.class);
                startActivity(intent) ;
            }


        }
        )


        ;

        Button logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view){
                Intent data = new Intent();

                Intent intent =  new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }

        });
Button SignOut =(Button) findViewById(R.id.signout);
        SignOut.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View view){
                Intent Intent = new Intent(getApplicationContext(),ExitActivity.class);
                startActivity(Intent);
            }
        });


        }





    }





