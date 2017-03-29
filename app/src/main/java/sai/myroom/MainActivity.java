package sai.myroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * The following method takes the user to the student view
     * @param view
     */

    public void studentMode(View view){

        Intent i = new Intent(getApplicationContext(),studentLoginActivity.class);

        startActivity(i);

    }

    /**
     * The following method takes the user to the administrator view
     * @param view
     */

    public void adminMode(View view){

        Intent i2 = new Intent(getApplicationContext(),adminLoginActivity.class);

        startActivity(i2);

    }

    public void shortcut(View view){

        Intent test = new Intent(getApplicationContext(),requestActivity.class);

        startActivity(test);

    }
}
