package sai.myroom;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class studentActivity extends AppCompatActivity {

    ArrayList<String> requests = new ArrayList<String>();

    ArrayAdapter arrayAdapter;

    String emailID;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Intent i = getIntent();

        emailID = i.getStringExtra("emailID");

        //Log.i("emailID",emailID);
        //Log.i("password",password);

        updateList();

    }

    public void updateList(){

        SQLiteDatabase requestsDb = this.openOrCreateDatabase("Requests",MODE_PRIVATE,null);

        requestsDb.execSQL("CREATE TABLE IF NOT EXISTS requests(requestData VARCHAR,date VARCHAR,time VARCHAR,emailID VARCHAR)");

        Cursor c = requestsDb.rawQuery("SELECT * FROM requests WHERE emailID='"+emailID+"'", null);

        int requestIndex = c.getColumnIndex("requestData");
        int dateIndex = c.getColumnIndex("date");
        int timeIndex = c.getColumnIndex("time");

        c.moveToFirst();

        while (!c.isAfterLast()) {

            requests.add(c.getString(requestIndex));

            c.moveToNext();

        }

        c.close();

        ListView listView = (ListView) findViewById(R.id.requests);

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,requests);

        listView.setAdapter(arrayAdapter);

    }

    public void addRequest(View view){

        Intent i9 = new Intent(getApplicationContext(),requestActivity.class);

        i9.putExtra("emailID", emailID);

        startActivity(i9);

    }
}
