package com.morgan.barcodescannerapp.scanner;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
// action bar imports
import android.app.ActionBar;
import android.view.MenuItem;


public class entryActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        // making the back button on the action bar viscible
        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);


        Button EntryButton= (Button ) findViewById(R.id.Scan_staff_qr);
        EntryButton .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();


                Intent intent = new Intent(getApplicationContext(),ScanActivity.class);
                startActivity(intent) ;
            }

        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                //app icon in action bar clicked; go home
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);

    }

}
