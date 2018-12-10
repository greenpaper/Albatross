package com.example.albatross;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//class to add contacts
public class Contact_activity extends AppCompatActivity {
    private BottomNavigationView mBottomNavigationView;
    EditText name;
    EditText number;
    EditText remove;
    Button add_cont;
    Button del_cont;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        //check text input for contacts
        name = findViewById(R.id.addname);
        number = findViewById(R.id.addcontact);
        remove = findViewById(R.id.delcontact);
        add_cont = findViewById(R.id.addbutton);
        del_cont = findViewById(R.id.buttondel);

        //check action for adding contact
        add_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message_alert(0);
            }
        });

        //check action for deleting contact
        del_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message_alert(1);
            }
        });

        //navigation check for back button back to main page
        mBottomNavigationView = findViewById(R.id.contacts_navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.backtrack:
                                startActivity(new Intent(Contact_activity.this, MainActivity.class));
                                break;
                        }
                        return true;
                    }
                });
    }

    public void message_alert(int n){
        if(n == 0){
            String message = "Contact " + name.getText().toString() + " is added to contacts list";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        else{
            String message = "Contact " + " has been deleted from contacts list";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

}
