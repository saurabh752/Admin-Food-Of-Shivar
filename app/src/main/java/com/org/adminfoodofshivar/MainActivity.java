package com.org.adminfoodofshivar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout add_menu,all_item,order_dispatch,profile_btn,new_user,log_out;
    TextView pending_order_btn;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_menu=findViewById(R.id.add_menu);
        log_out=findViewById(R.id.log_out);
        all_item=findViewById(R.id.all_item);
        order_dispatch=findViewById(R.id.order_dispatch);
        profile_btn=findViewById(R.id.profile_btn);
        new_user=findViewById(R.id.new_user);
        pending_order_btn=findViewById(R.id.pending_order_btn);
        firebaseAuth = FirebaseAuth.getInstance();

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Logout the user
                firebaseAuth.signOut();

                // Redirect to the login activity
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                finish(); // Close the main activity
            }
        });
        new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CreateUserActivity.class);
                startActivity(intent);
            }
        });
        pending_order_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, PendingOrdersActivity.class);
                startActivity(intent);
            }
        });
        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AdminProfileActivity.class);
                startActivity(intent);
            }
        });
        order_dispatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, OutForDeliveryActivity.class);
                startActivity(intent);
            }
        });
        all_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AllitemActivity.class);
                startActivity(intent);
            }
        });
        add_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent=new Intent(MainActivity.this,AddItemActivity.class);
                startActivity(intent);
            }
        });
    }
}