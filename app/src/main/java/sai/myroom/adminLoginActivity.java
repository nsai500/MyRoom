package sai.myroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;

public class adminLoginActivity extends AppCompatActivity {

    EditText adminID;

    EditText adminPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        adminID = (EditText) findViewById(R.id.adminID);

        adminPassword = (EditText) findViewById(R.id.adminPassword);
    }

    public void adminLoginCheck(View view){

        String adminEmailID = adminID.getText().toString();

        String adminPasswordd = adminPassword.getText().toString();

    }

}
