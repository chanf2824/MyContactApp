package com.example.chanf.mycontactapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.SEARCH_NAME);
        String data = intent.getStringExtra(MainActivity.INFO);

        TextView title = (TextView)findViewById(R.id.textView_Title);
        TextView info = (TextView) findViewById(R.id.textView_Info);

        title.setText(name);
        info.setText(data);
    }



}
