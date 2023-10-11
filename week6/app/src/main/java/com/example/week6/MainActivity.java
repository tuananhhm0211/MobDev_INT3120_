package com.example.week6;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView selection;
    String[] items = {"Android", "IPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
// set a clickable right push-button comboBox to show items
        ArrayAdapter<String> aa = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, items);
// provide a particular design for the drop-down lines
        aa.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
// associate GUI spinner and adapter
        spin.setAdapter(aa);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        LinearLayout spinnerContainer = findViewById(R.id.spinnerContainer);
        if (id == R.id.item2) {
            if (spinnerContainer.getVisibility() == View.GONE) {
                // Hiển thị Spinner layout
                spinnerContainer.setVisibility(View.VISIBLE);
            } else {
                // Ẩn Spinner layout
                spinnerContainer.setVisibility(View.GONE);
            }
            return true;
        } else if (id == R.id.item3) {
            spinnerContainer.setVisibility(View.GONE);
            return true;
        } else {
            Toast.makeText(MainActivity.this, "This is a default message", Toast.LENGTH_LONG).show();
            return super.onOptionsItemSelected(item);
        }
    }
}