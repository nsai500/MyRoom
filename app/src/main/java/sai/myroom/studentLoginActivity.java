package sai.myroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class studentLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
    }

    public void loginCheck(View view){



    }

    public void studentRegister(View view){

        Intent i4 = new Intent(getApplicationContext(),studentRegister.class);

        startActivity(i4);

    }
}
