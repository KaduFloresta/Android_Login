package com.example.android_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserData extends AppCompatActivity {
    private String name, email, user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        Bundle args = getIntent().getExtras();
        name = args.getString("nome");
        email = args.getString("email");
        user = args.getString("usuario");
        password = args.getString("senha");

        TextView txtInfoName = (TextView) findViewById(R.id.txtInfoName);
        txtInfoName.setText("Nome: " + name);
        TextView txtInfoEmail = (TextView) findViewById(R.id.txtInfoEmail);
        txtInfoEmail.setText("Email: " + email);
        TextView txtInfoUser = (TextView) findViewById(R.id.txtInfoUser);
        txtInfoUser.setText("Usuário: " + user);
        TextView txtInfoPassword = (TextView) findViewById(R.id.txtInfoPassword);
        txtInfoPassword.setText("Senha: " + password);

        Button btnUpdate = (Button) findViewById(R.id.buttonUpdate);
        btnUpdate.setOnClickListener(onClickUpdate());
    }

    private View.OnClickListener onClickUpdate() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(UserData.this, UserCreate.class);
                startActivityForResult(myIntent, 2);
                Bundle params = new Bundle();
                params.putString("nome", name);
                params.putString("email", email);
                params.putString("usuario", user);
                params.putString("senha", password);
                myIntent.putExtras(params);
                startActivity(myIntent);
            }
        };
    }
}