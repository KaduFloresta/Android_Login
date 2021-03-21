package com.example.android_login;

import androidx.appcompat.app.AppCompatActivity;

// Bibliotecas
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String name, email, user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = (Button) findViewById(R.id.buttonSend);
        btnSend.setOnClickListener(onClickSend());
    }

    // Evento do botão para direcionar á um tela...
    private View.OnClickListener onClickSend() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtUser = (TextView) findViewById(R.id.inputUser);
                user = txtUser.getText().toString();
                TextView txtPassword = (TextView) findViewById(R.id.inputPassword);
                password = txtPassword.getText().toString();

                // Se o usuário for igual á "cefloresta" e a senha igual á "abc123"...
                if ("cefloresta".equals(user) && "abc123".equals(password)) {
                    // ...tela direcionada para Dados do Usuário ou...
                    Intent direction = new Intent(MainActivity.this, UserData.class);
                    startActivityForResult(direction, 2);
                    Bundle params = new Bundle();
                    params.putString("nome", "Kadu Floresta");
                    params.putString("email", "cefloresta1@gmail.com");
                    params.putString("usuario", user);
                    params.putString("senha", password);
                    direction.putExtras(params);
                    startActivity(direction);
                }
                // ...caso contrário, direciona para a tela Criar Usuário
                else {
                    Intent myIntent = new Intent(MainActivity.this, UserCreate.class);
                    startActivityForResult(myIntent, 2);
                    Bundle params = new Bundle();
                    params.putString("nome", name);
                    params.putString("email", email);
                    params.putString("usuario", user);
                    params.putString("senha", password);
                    myIntent.putExtras(params);
                    startActivity(myIntent);
                }
            }
        };
    }
}