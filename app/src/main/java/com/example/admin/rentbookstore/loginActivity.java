package com.example.admin.rentbookstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button = findViewById(R.id.button_accept);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EditText =findViewById(R.id.editText_admin);

                if(!EditText.getText().toString().equals("admin") ){
                    Toast t = Toast.makeText(loginActivity.this,"รหัสผ่านไม่ถูกต้อง "+EditText.getText().toString(),Toast.LENGTH_LONG);
                    t.show();
                }else {


                    Intent i = new Intent(loginActivity.this,EditActivity.class);
                    startActivity(i);


                }
            }
        });

    }
}
