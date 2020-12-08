package com.example.carbgg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SettingsPage extends AppCompatActivity {
    private EditText et;
    public final String savefile = "configs.txt";
    public final String insulinEfficiencyKey = "inEfKey";
    protected float insulinEfficiency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        et=findViewById(R.id.etCoefficient);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        SharedPreferences prefGet = getSharedPreferences(savefile , Context.MODE_PRIVATE);
        float insulinEf = prefGet.getFloat("inEfKey", 1);
        et.setText(Float.toString(insulinEf));
    }
    public void btnSaveCoefficient(View view) {
        insulinEfficiency = Float.parseFloat(et.getText().toString());
        SharedPreferences prefPutter = getSharedPreferences(savefile,Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPutter.edit();
        prefEditor.putFloat(insulinEfficiencyKey, insulinEfficiency);
        prefEditor.commit();

        Intent j = new Intent(SettingsPage.this,MainActivity.class);
        startActivity(j);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}