package com.example.albatross;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {
    /*	@param savedInstanceState as the current state of the application
	 *
    	@effects initialize process to either log in or register
    	         if logging in - route to LoginActivity2
    	         if registering - route to RegisterActivity
    	@modifies updates state of the application
    	@throws nothing
    	@return nothing
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button loginButton = findViewById(R.id.button2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, LoginActivity2.class));
            }
        });

        Button registerButton = findViewById(R.id.button3);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this, RegisterActivity.class));
            }
        });
    }
}
