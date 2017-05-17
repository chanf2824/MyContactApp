package com.example.chanf.mycontactapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
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
        boolean isInserted = myDb.insertData(editName.getText().toString(),
                editNumber.getText().toString(),
                editAddress.getText().toString());
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

    public void viewData(View v){
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0){
            showMessage("Error", "No data is found in the database");
            //Output message using Log.d and Toast
            return;
        }

        StringBuffer buffer = new StringBuffer();
        //setup a loop with the Cursor (res) using moveToNext
            //  append each COL to the buffer
            //  display message using showMessage
        showMessage("Data", buffer.toString());
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true); //cancel using back button
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
