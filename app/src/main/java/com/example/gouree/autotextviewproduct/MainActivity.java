package com.example.gouree.autotextviewproduct;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private SQLiteCountryAssistant sqlliteCountryAssistant;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //autocompletetextview
        final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocompleteproduct);

        sqlliteCountryAssistant = new SQLiteCountryAssistant(MainActivity.this);
        sqlliteCountryAssistant.openDB();

        // Insert a few products
        sqlliteCountryAssistant.insertProduct("Samsung Mobile");
        sqlliteCountryAssistant.insertProduct("Samsung Tv");
        sqlliteCountryAssistant.insertProduct("Samsung Music System");
        sqlliteCountryAssistant.insertProduct("Samsung Speakers");
        sqlliteCountryAssistant.insertProduct("Samsung Earphones");
        sqlliteCountryAssistant.insertProduct("Apple Mobile");
        sqlliteCountryAssistant.insertProduct("Apple Tv");
        sqlliteCountryAssistant.insertProduct("Apple Speakers");
        sqlliteCountryAssistant.insertProduct("Apple Earphones");
        sqlliteCountryAssistant.insertProduct("Ziomi Mobile");
        sqlliteCountryAssistant.insertProduct("Oppo Mobile");
        sqlliteCountryAssistant.insertProduct("Vivo Mobile");



        //sqlliteCountryAssistant.removeCountry("Chad");
        //sqlliteCountryAssistant.updateCountry("Canada", "Costa Rica");


        //store all products in array of string
        String[] products = sqlliteCountryAssistant.getAllProducts();

        // Print out the values to the log
        for(int i = 0; i < products.length; i++)
        {
            Log.i(this.toString(), products[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, products);
        textView.setAdapter(adapter);
    }

    public void onDestroy()
    {
        super.onDestroy();
        sqlliteCountryAssistant.close();
    }

}