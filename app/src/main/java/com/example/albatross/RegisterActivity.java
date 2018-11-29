package com.example.albatross;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.albatross.Database;
import java.sql.*;

public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText username;
    EditText password;
    EditText phone;
    EditText city;
    EditText state;
    Button register;
    /*	@param savedInstanceState as the current state of the application
	 *
    	@effects initialize database and various other application processes
    	         store a registering user into the database
    	         route registered user to the MainActivity page next
    	@modifies set user details if registering
    	@throws nothing
    	@return nothing
	 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Made the database");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.NameText);
        email = findViewById(R.id.EmailText);
        username = findViewById(R.id.UsernameText);
        password = findViewById(R.id.PasswordText);
        phone = findViewById(R.id.PhoneText);
        city = findViewById(R.id.CityText);
        state = findViewById(R.id.StateText);
        register = findViewById(R.id.registration);


        System.out.println("THIS PRINTED********");



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseHelper dbs = new DatabaseHelper(RegisterActivity.this);
                System.out.println("THIS PRINTED%%%%%%%");
                //create a new user to be inserted into the database
                User newu = new User();
                newu.setName(name.getText().toString());
                newu.setEmail(email.getText().toString());
                newu.setUsername(username.getText().toString());
                newu.setPassword(password.getText().toString());
                dbs.addUser(newu);
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                System.out.println("THIS PRINTED");
            }

        });


    }
    /*	@param email of user
	 *
    	@effects none
    	@modifies nothing
    	@throws nothing
    	@return if an email is vaild
	 */
    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    /*	@param text of registering user
	 *
    	@effects none
    	@modifies nothing
    	@throws nothing
    	@return if passed in text is empty or if it is valid
	 */
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
    /*	@param nothing
	 *
    	@effects show to user if data used to register is valid
    	@modifies nothing
    	@throws nothing
    	@return nothing
	 */
    void checkDataEntered(){
        if(isEmpty(name)){
          Toast t = Toast.makeText(this, "Name is required to register", Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmail(email) == false){
            email.setError("Enter valid email");
        }
        if(isEmpty(username)){
            Toast t = Toast.makeText(this, "Username is required to register", Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(password)){
            Toast t = Toast.makeText(this, "Password is required to register", Toast.LENGTH_SHORT);
            t.show();
        }

        if(isEmpty(phone)){
            Toast t = Toast.makeText(this, "Phone is required to register", Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(city)){
            Toast t = Toast.makeText(this, "City is required to register", Toast.LENGTH_SHORT);
            t.show();
        }
        if(isEmpty(state)){
            Toast t = Toast.makeText(this, "State is required to register", Toast.LENGTH_SHORT);
            t.show();
        }

    }



}
;