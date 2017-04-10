package sai.myroom;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class studentRegister extends AppCompatActivity {

    EditText name;

    EditText regNo;

    EditText roomNo;

    EditText blockNumber;

    EditText emailID;

    EditText studentPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_register);

        name = (EditText) findViewById(R.id.name);

        regNo = (EditText) findViewById(R.id.regNo);

        roomNo = (EditText) findViewById(R.id.roomNo);

        blockNumber = (EditText) findViewById(R.id.blockNumber);

        emailID = (EditText) findViewById(R.id.emailID);

        studentPassword = (EditText) findViewById(R.id.studentPassword);
    }

    public void register(View view){

        try {

        SQLiteDatabase studentDb = this.openOrCreateDatabase("Students",MODE_PRIVATE,null);

        studentDb.execSQL("CREATE TABLE IF NOT EXISTS students(name VARCHAR,regNo INTEGER PRIMARY KEY,roomNo INTEGER,blockNo INTEGER,emailID VARCHAR,password VARCHAR)");


        String studentName = name.getText().toString();

        String studentregNo = regNo.getText().toString();

        String studentroomNo = roomNo.getText().toString();

        String studentblockNo = blockNumber.getText().toString();

        String studentemailID = emailID.getText().toString();

        String studentPasswordd = studentPassword.getText().toString();

        /*Log.i("Name",studentName);
        Log.i("regNo",studentregNo);
        Log.i("roomNo",studentroomNo);
        Log.i("blockNo",studentblockNo);
        Log.i("emailID",studentemailID);
        Log.i("password",studentPasswordd);*/

        studentDb.execSQL("INSERT INTO students VALUES ('"+studentName+"',"+studentregNo+","+studentroomNo+","+studentblockNo+",'"+studentemailID+"','"+studentPasswordd+"')");

            Cursor c = studentDb.rawQuery("SELECT * FROM students", null);

            int nameIndex = c.getColumnIndex("name");
            int regIndex = c.getColumnIndex("regNo");
            int roomIndex = c.getColumnIndex("roomNo");

            c.moveToFirst();

            while (!c.isAfterLast()) {

                Log.i("Name",c.getString(nameIndex));
                Log.i("Registration Number",c.getString(regIndex));
                Log.i("Room Number",c.getString(roomIndex));

                c.moveToNext();

            }

            c.close();

            Intent i5 = new Intent(getApplicationContext(),studentActivity.class);

            i5.putExtra("emailID",studentemailID);

            i5.putExtra("roomNo",studentroomNo);

            Toast.makeText(getApplicationContext(),"Registered Successfully!",Toast.LENGTH_LONG).show();

            startActivity(i5);

        }
        catch(Exception e){

            Toast.makeText(getApplicationContext(),"Exception Occured",Toast.LENGTH_SHORT).show();

            e.printStackTrace();
        }

    }
}
