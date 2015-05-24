package com.okode.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.okode.demo.common.Common;
import com.okode.demo.common.Data;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

    static {
        RoboGuice.setUseAnnotationDatabases(false);
    }

    @InjectView(R.id.txtKey)
    private EditText txtKey;

    @InjectView(R.id.txtValue)
    private TextView txtValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Common.showMessage("Starting Android APP");
    }

    public void btnQueryOnClick(View view) {
        txtValue.setText(Common.getValueFromJson(Data.JSON, txtKey.getText().toString()));
    }
}
