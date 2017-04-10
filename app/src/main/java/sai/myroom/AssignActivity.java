package sai.myroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AssignActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign);
    }

    public void assignTask(View view){

        Toast.makeText(getApplicationContext(),"Task Assigned",Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(),adminActivity.class);

        startActivity(intent);

    }

}
