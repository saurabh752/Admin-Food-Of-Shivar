package com.org.adminfoodofshivar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminProfileActivity extends AppCompatActivity {

    EditText name_text1,address_text1,email_text1,phone_text1,Password_text1;
    TextView edit_profile;
    ImageView back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);
        name_text1=findViewById(R.id.name_text1);
        address_text1=findViewById(R.id.address_text1);
        email_text1=findViewById(R.id.email_text1);
        Password_text1=findViewById(R.id.Password_text1);
        phone_text1=findViewById(R.id.phone_text1);
        edit_profile=findViewById(R.id.edit_profile);
        back_btn=findViewById(R.id.back_btn);

        name_text1.setEnabled(false);
        address_text1.setEnabled(false);
        email_text1.setEnabled(false);
        phone_text1.setEnabled(false);
        Password_text1.setEnabled(false);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_text1.setEnabled(true);
                address_text1.setEnabled(true);
                email_text1.setEnabled(true);
                phone_text1.setEnabled(true);
                Password_text1.setEnabled(true);
            }
        });

    }
}