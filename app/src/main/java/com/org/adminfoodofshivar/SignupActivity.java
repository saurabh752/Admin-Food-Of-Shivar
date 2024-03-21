package com.org.adminfoodofshivar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignupActivity extends AppCompatActivity {
Button login_btn1;
EditText userr_name,Resto_name,User_email,User_Password;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        login_btn1=findViewById(R.id.add_item_btn);
        userr_name=findViewById(R.id.userr_name);
        Resto_name=findViewById(R.id.Resto_name);
        User_email=findViewById(R.id.User_email);
        User_Password=findViewById(R.id.User_Password);
        firebaseAuth=FirebaseAuth.getInstance();

        login_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String name1=userr_name.getText().toString();
                String Restoname1=Resto_name.getText().toString();
                String email1=User_email.getText().toString();
                String password1=User_Password.getText().toString();

                if (TextUtils.isEmpty(name1)||TextUtils.isEmpty(Restoname1)||TextUtils.isEmpty(email1)||TextUtils.isEmpty(password1))
                {
                    Toast.makeText(SignupActivity.this, "Plz Fill the all details", Toast.LENGTH_SHORT).show();
                }else {
                    Account_User(email1,password1,name1,Restoname1);
                }

//RealTime DataBase
                HashMap<String,Object> m= new HashMap<>();
                m.put("Name",userr_name.getText().toString());
                m.put("Restaurant Name",Resto_name.getText().toString());
                m.put("Email",User_email.getText().toString());
                m.put("Password",User_Password.getText().toString());

                FirebaseDatabase.getInstance().getReference().child("Admin").push().setValue(m);




            }

            
        });
        
    }

    private void Account_User(String email1, String password1, String name1, String Restoname1) {
        firebaseAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignupActivity.this, "Account Create successfully", Toast.LENGTH_SHORT).show();
                    Intent intent;
                    intent=new Intent(SignupActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(SignupActivity.this, "Failed to add user data to Firestore", Toast.LENGTH_SHORT).show();
                }            }
        });
    }


}