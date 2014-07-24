package com.morgan.barcodescannerapp.scanner;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class ScanActivity extends ActionBarActivity implements OnClickListener{

    private Button scanBtn;
    private TextView formatTxt, contentTxt , secondScanFormat, secondScanContent ;
    private Button scanCompBtn;
    private IntentIntegrator scanIntegrator ;
    private boolean isFirstScanButtonSelected = false  ;
    private boolean isSecondScanButtonSelected = false  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan );

        scanIntegrator = new IntentIntegrator(this);
        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        scanBtn.setOnClickListener(this);

        scanCompBtn= (Button)findViewById(R.id.scan_comp_qr);
        secondScanFormat = (TextView)findViewById(R.id.scan_format2);
        secondScanContent = (TextView)findViewById(R.id.scan_content2);
        scanCompBtn.setOnClickListener(this);
        // back on the acion bar

        ActionBar actionBar= getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

   }
    public void onClick(View v){
        //respond to clicks
       if(v.getId()==R.id.scan_button){
            //scan
            isFirstScanButtonSelected = true  ;
            scanIntegrator.initiateScan();
        }
        if(v.getId()==R.id.scan_comp_qr){
            //scan
            isSecondScanButtonSelected = true ;
            scanIntegrator.initiateScan();
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            //we have a result and store it to a variable
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();

            if (isFirstScanButtonSelected) {

                formatTxt.setText("FORMAT: " + scanFormat);
                contentTxt.setText("CONTENT: " + scanContent);

                isFirstScanButtonSelected = false ;
            } else if (isSecondScanButtonSelected) {
                secondScanFormat.setText("FORMAT: " + scanFormat);
                secondScanContent.setText("CONTENT: " + scanContent);
                isSecondScanButtonSelected = false ;
            }
        }



        else{


            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }

        //this is a test for the scann button





 // end of test


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
       //implementing the up button on the action bar

        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
               return true;
        }
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
                   }
        return super.onOptionsItemSelected(item);
    }
//test 2



}


