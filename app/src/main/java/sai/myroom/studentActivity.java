package sai.myroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class studentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
    }

    public void addRequest(View view){

        Intent i9 = new Intent(getApplicationContext(),requestActivity.class);

        startActivity(i9);

    }
}
