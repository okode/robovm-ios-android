package com.okode.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.okode.demo.common.Common;
import com.okode.demo.common.Data;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Common.showMessage("Starting Android APP");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void btnQueryOnClick(View view) {
        EditText keyView = (EditText) findViewById(R.id.txtKey);
        TextView valueView = (TextView) findViewById(R.id.txtValue);
        String value = Common.getValueFromJson(Data.JSON, keyView.getText().toString());
        valueView.setText(value);
    }
}
