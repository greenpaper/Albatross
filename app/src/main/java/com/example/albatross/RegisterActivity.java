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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                checkDataEntered();
                System.out.println("THIS PRINTED%%%%%%%");
                startDatabase();
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                System.out.println("THIS PRINTED");
            }

        });


    }

    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

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

    public void startDatabase(){

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/albatross", "postgres", "postgres")) {

            System.out.println("Java JDBC PostgreSQL Example");
            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within

            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.

           //Class.forName("org.postgresql.Driver");

            System.out.println("Connected to PostgreSQL database!");

            Statement statement = connection.createStatement();

            System.out.println("Reading car records...");

            System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.cars");

            while (resultSet.next()) {

                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("model"), resultSet.getString("price"));

            }


        } /*catch (ClassNotFoundException e) {
28
            System.out.println("PostgreSQL JDBC driver not found.");
29
            e.printStackTrace();
30
        }*/ catch (SQLException e) {

            System.out.println("Connection failure.");

            e.printStackTrace();

        }

    }


}
;