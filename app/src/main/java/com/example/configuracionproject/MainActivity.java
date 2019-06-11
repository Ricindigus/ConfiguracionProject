package com.example.configuracionproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    TextView tv1,tv2,tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindearVistas();
        setupSharedPreferences();
    }

    private void bindearVistas() {
        tv1 = findViewById(R.id.tvTexto1);
        tv2 = findViewById(R.id.tvTexto2);
        tv3 = findViewById(R.id.tvTexto3);
    }

    private void setupSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mostrarTexto1(sharedPreferences.getBoolean(getString(R.string.preferences_key_visible1),
                getResources().getBoolean(R.bool.default_value_visible1)));
        mostrarTexto2(sharedPreferences.getBoolean(getString(R.string.preferences_key_visible2),
                getResources().getBoolean(R.bool.default_value_visible2)));
        mostrarTexto3(sharedPreferences.getBoolean(getString(R.string.preferences_key_visible3),
                getResources().getBoolean(R.bool.default_value_visible3)));

        boldTexto1(sharedPreferences.getBoolean(getString(R.string.preferences_key_bold1),
                getResources().getBoolean(R.bool.default_value_bold1)));
        boldTexto2(sharedPreferences.getBoolean(getString(R.string.preferences_key_bold2),
                getResources().getBoolean(R.bool.default_value_bold2)));
        boldTexto3(sharedPreferences.getBoolean(getString(R.string.preferences_key_bold3),
                getResources().getBoolean(R.bool.default_value_bold3)));

        colorTexto1(sharedPreferences.getString(getString(R.string.preferences_key_color1), ""));
        colorTexto2(sharedPreferences.getString(getString(R.string.preferences_key_color2), ""));
        colorTexto3(sharedPreferences.getString(getString(R.string.preferences_key_color3), ""));

        setearTexto1(sharedPreferences.getString(getString(R.string.preferences_key_texto1), "texto1"));
        setearTexto2(sharedPreferences.getString(getString(R.string.preferences_key_texto2), "texto2"));
        setearTexto3(sharedPreferences.getString(getString(R.string.preferences_key_texto3), "texto3"));

        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    private void colorTexto1(String color) {
        if (!TextUtils.isEmpty(color)){
            if (color.equals("red")) tv1.setTextColor(Color.RED);
            else if (color.equals("blue")) tv1.setTextColor(Color.BLUE);
            else if (color.equals("green")) tv1.setTextColor(Color.GREEN);
        }
    }

    private void colorTexto2(String color) {
        if (!TextUtils.isEmpty(color)){
            if (color.equals("red")) tv2.setTextColor(Color.RED);
            else if (color.equals("blue")) tv2.setTextColor(Color.BLUE);
            else if (color.equals("green")) tv2.setTextColor(Color.GREEN);
        }
    }

    private void colorTexto3(String color) {
        if (!TextUtils.isEmpty(color)){
            if (color.equals("red")) tv3.setTextColor(Color.RED);
            else if (color.equals("blue")) tv3.setTextColor(Color.BLUE);
            else if (color.equals("green")) tv3.setTextColor(Color.GREEN);
        }
    }


    private void boldTexto1(boolean bold) {
        if (bold) tv1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        else tv1.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }
    private void boldTexto2(boolean bold) {
        if (bold) tv2.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        else tv2.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }
    private void boldTexto3(boolean bold) {
        if (bold) tv3.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        else tv3.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }


    private void mostrarTexto1(boolean mostrarTexto) {
        if (!mostrarTexto) tv1.setVisibility(View.GONE);
        else tv1.setVisibility(View.VISIBLE);
    }

    private void mostrarTexto2(boolean mostrarTexto) {
        if (!mostrarTexto) tv2.setVisibility(View.GONE);
        else tv2.setVisibility(View.VISIBLE);
    }

    private void mostrarTexto3(boolean mostrarTexto) {
        if (!mostrarTexto) tv3.setVisibility(View.GONE);
        else tv3.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_settings){
            startActivity(new Intent(this,SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(getString(R.string.preferences_key_visible1)))
            mostrarTexto1(sharedPreferences.getBoolean(key,
                    getResources().getBoolean(R.bool.default_value_visible1)));

        else if (key.equals(getString(R.string.preferences_key_visible2)))
            mostrarTexto2(sharedPreferences.getBoolean(key,
                    getResources().getBoolean(R.bool.default_value_visible2)));

        else if (key.equals(getString(R.string.preferences_key_visible3)))
            mostrarTexto3(sharedPreferences.getBoolean(key,
                    getResources().getBoolean(R.bool.default_value_visible3)));

        else if (key.equals(getString(R.string.preferences_key_bold1)))
            boldTexto1(sharedPreferences.getBoolean(key,
                    getResources().getBoolean(R.bool.default_value_bold1)));

        else if (key.equals(getString(R.string.preferences_key_bold2)))
            boldTexto2(sharedPreferences.getBoolean(key,
                    getResources().getBoolean(R.bool.default_value_bold2)));

        else if (key.equals(getString(R.string.preferences_key_bold3)))
            boldTexto3(sharedPreferences.getBoolean(key,
                    getResources().getBoolean(R.bool.default_value_bold3)));

        else if (key.equals(getString(R.string.preferences_key_color1)))
            colorTexto1(sharedPreferences.getString(key, ""));

        else if (key.equals(getString(R.string.preferences_key_color2)))
            colorTexto2(sharedPreferences.getString(key, ""));

        else if (key.equals(getString(R.string.preferences_key_color3)))
            colorTexto3(sharedPreferences.getString(key, ""));

        else if (key.equals(getString(R.string.preferences_key_texto1)))
            setearTexto1(sharedPreferences.getString(key, "Texto1"));

        else if (key.equals(getString(R.string.preferences_key_texto2)))
            setearTexto2(sharedPreferences.getString(key, "Texto2"));

        else if (key.equals(getString(R.string.preferences_key_texto3)))
            setearTexto3(sharedPreferences.getString(key, "Texto3"));
    }

    private void setearTexto1(String texto) {
        tv1.setText(texto);
    }

    private void setearTexto2(String texto) {
        tv2.setText(texto);
    }

    private void setearTexto3(String texto) {
        tv3.setText(texto);
    }

}
