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

public class studentLoginActivity extends AppCompatActivity {

    EditText emailText;

    EditText passwordText;

    boolean loginFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        emailText = (EditText) findViewById(R.id.emailText);

        passwordText = (EditText) findViewById(R.id.passwordText);
    }

    public void loginCheck(View view){

            try {

                SQLiteDatabase studentDb = this.openOrCreateDatabase("Students",MODE_PRIVATE,null);

                String emailID = emailText.getText().toString();

                String password = passwordText.getText().toString();

                Cursor c = studentDb.rawQuery("SELECT * FROM students", null);

                int emailIDIndex = c.getColumnIndex("emailID");
                int passwordIndex = c.getColumnIndex("password");

                c.moveToFirst();

                while (!c.isAfterLast()) {

                    /*Log.i("emailID",c.getString(emailIDIndex));
                    Log.i("Password",c.getString(passwordIndex));*/

                    if(c.getString(emailIDIndex).equals(emailID) && c.getString(passwordIndex).equals(password)){

                        Intent i10 = new Intent(getApplicationContext(),studentActivity.class);

                        Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_LONG).show();

                        i10.putExtra("emailID", emailID);

                        i10.putExtra("password", password);

                        loginFlag=true;

                        startActivity(i10);

                    }

                    c.moveToNext();

                }

                c.close();
                if(!loginFlag) {
                    Toast.makeText(getApplicationContext(), "The email address or password that you've entered doesn't match any account. Sign up for an account.", Toast.LENGTH_SHORT).show();
                }
            }
            catch(Exception e){

                Toast.makeText(getApplicationContext(),"Exception Occured",Toast.LENGTH_SHORT).show();

                e.printStackTrace();
            }

    }

    public void studentRegister(View view){

        Intent i4 = new Intent(getApplicationContext(),studentRegister.class);

        startActivity(i4);

    }
}
