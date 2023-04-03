package com.example.users;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editFirstName;
    private EditText editLastName;
    private EditText editEmail;
    private String degreeProgram, completed;
    private CheckBox kandi, diplomi, tohtori, uima;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*userStorage.getInstance().loadUsers(context);*/

        kandi = findViewById(R.id.checkKandi);
        kandi.setOnClickListener(this);
        diplomi = findViewById(R.id.checkDiplomi);
        diplomi.setOnClickListener(this);
        tohtori = findViewById(R.id.checkTohtori);
        tohtori.setOnClickListener(this);
        uima = findViewById(R.id.checkUima);
        uima.setOnClickListener(this);
        context = MainActivity.this;
    }
    @Override
    public void onClick(View view) {
        StringBuilder sb = new StringBuilder();
        if (kandi.isChecked()) {
            sb.append("Kandidaatin tutkinto\n");
        }
        if (diplomi.isChecked()) {
            sb.append("Diplomi-insinöörin tutkinto\n");
        }
        if (tohtori.isChecked()) {
            sb.append("Tekniikan tohtorin tutkinto\n");
        }
        if (uima.isChecked()) {
            sb.append("Uimamaisteri\n");
        }
        completed = sb.toString();
    }

    public void addUser(View view){

        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);

        RadioGroup rgDegreeProgram = findViewById(R.id.rgDegreeProgram);

        switch(rgDegreeProgram.getCheckedRadioButtonId()){
            case R.id.rbTite:
                degreeProgram = "Tietotekniikka";
                break;
            case R.id.rbTuta:
                degreeProgram = "Tuotantotalous";
                break;
            case R.id.rbLate:
                degreeProgram = "Laskennallinen tekniikka";
                break;
            case R.id.rbSate:
                degreeProgram = "Sähkötekniikka";
                break;
        }

        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String email = editEmail.getText().toString();

        userStorage.getInstance().addUser(new User(firstName, lastName, email, degreeProgram, completed));
        userStorage.getInstance().saveUsers(context);
    }

    public void switchToUserList(View view){
        userStorage.getInstance().sortList();
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
        userStorage.getInstance().listUsers();
    }
}