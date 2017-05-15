package com.example.chanf.mycontactapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName;
    EditText editNumber;
    EditText editAddress;
    Button btnAddData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        //Add the layout vars
        editName = (EditText)findViewById(R.id.editText_name);
        editNumber = (EditText)findViewById(R.id.editText_number);
        editAddress = (EditText)findViewById(R.id.editText_address);

    }

    public void addData(View v){
        boolean isInserted = myDb.insertData(editName.getText().toString());
        Context context = getApplicationContext();
        CharSequence text;


        if(isInserted == true){
            Log.d("MyContact", "Success inserting data");
            //Insert Toast message here.....
            text = "Data inserted!";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            Log.d("MyContact", "Failure inserting data");
            text = "Data couldn't be inserted";
            //Insert Toast message here.....
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
