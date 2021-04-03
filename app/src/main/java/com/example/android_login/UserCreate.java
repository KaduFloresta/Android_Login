package com.example.android_login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserCreate extends AppCompatActivity {
    private String name, email, user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_create);

        // Recebe os "args" em formato String pela chave
        Bundle args = getIntent().getExtras();
        name = args.getString("nome");
        email = args.getString("email");
        user = args.getString("usuario");
        password = args.getString("senha");

        // R é a classe que extende ao Objeto
        TextView txtCreateName = (TextView) findViewById(R.id.txtCreateName);
        txtCreateName.setText(name);
        TextView txtCreateEmail = (TextView) findViewById(R.id.txtCreateEmail);
        txtCreateEmail.setText(email);
        TextView txtCreateUser = (TextView) findViewById(R.id.txtCreateUser);
        txtCreateUser.setText(user);
        TextView txtCreatePassword = (TextView) findViewById(R.id.txtCreatePassword);
        txtCreatePassword.setText(password);

        Button btnConfirm = (Button) findViewById(R.id.buttonConfirm);
        btnConfirm.setOnClickListener(onClickConfirm());
    }

    // Evento do botão Confirmar a criação do usuário
    private View.OnClickListener onClickConfirm() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtName = (TextView) findViewById(R.id.txtCreateName);
                name = txtName.getText().toString();
                TextView txtEmail = (TextView) findViewById(R.id.txtCreateEmail);
                email = txtEmail.getText().toString();
                TextView txtUser = (TextView) findViewById(R.id.txtCreateUser);
                user = txtUser.getText().toString();
                TextView txtPassword = (TextView) findViewById(R.id.txtCreatePassword);
                password = txtPassword.getText().toString();

                Intent myIntent = new Intent(UserCreate.this, UserData.class);
                startActivityForResult(myIntent, 3);

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