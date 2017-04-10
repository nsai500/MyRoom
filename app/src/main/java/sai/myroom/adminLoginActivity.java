package sai.myroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

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

        if(adminEmailID.equals("admin") && adminPasswordd.equals("admin")) {
            Intent adminIntent = new Intent(getApplicationContext(), adminActivity.class);

            Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();

            startActivity(adminIntent);
        }else{
            Toast.makeText(getApplicationContext(),"Invalid Administrator ID or Password",Toast.LENGTH_SHORT).show();
        }

    }

}
