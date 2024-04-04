package com.example.joquempo;

import static com.example.joquempo.R.*;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        // Resetar a opacidade de todas as imagens
        findViewById(R.id.imagePedra).setAlpha(1.0f);
        findViewById(R.id.imagePapel).setAlpha(1.0f);
        findViewById(R.id.imageTesoura).setAlpha(1.0f);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        // Destacar a opção selecionada pelo usuário
        switch (opcaoSelecionada) {
            case "pedra":
                findViewById(R.id.imagePedra).setAlpha(0.5f); // Reduz a opacidade para 50%
                break;

            case "papel":
                findViewById(R.id.imagePapel).setAlpha(0.5f); // Reduz a opacidade para 50%
                break;

            case "tesoura":
                findViewById(R.id.imageTesoura).setAlpha(0.5f); // Reduz a opacidade para 50%
                break;
        }

        if ((opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura"))) {
            textResultado.setText("Você Perdeu !!");
        } else if ((opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel")) ||
                (opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra")) ||
                (opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura"))) {
            textResultado.setText("Você Ganhou!!");
        } else {
            textResultado.setText("Empatamos !!");
        }
    }


//    public void opcaoSelecionada(String opcaoSelecionada) {
//
//        ImageView imageResultado = findViewById(R.id.imageResultado);
//        TextView textResultado = findViewById(R.id.textResultado);
//
//        int numero = new Random().nextInt(3);
//        String[] opcoes = {"pedra", "papel", "tesoura"};
//        String opcaoApp = opcoes[numero];
//
//        switch (opcaoApp) {
//            case "pedra":
//                imageResultado.setImageResource(R.drawable.pedra);
//                break;
//
//            case "papel":
//                imageResultado.setImageResource(R.drawable.papel);
//                break;
//
//            case "tesoura":
//                imageResultado.setImageResource(R.drawable.tesoura);
//                break;
//        }
//
//        if ((opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
//                (opcaoApp == "papel" && opcaoSelecionada == "pedra") ||
//                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura")
//        ) {
//            textResultado.setText("Voce Perdeu !!");
//        } else if ((opcaoSelecionada == "tesoura" && opcaoApp == "papel") ||
//                (opcaoSelecionada == "papel" && opcaoApp == "pedra") ||
//                (opcaoSelecionada == "pedra" && opcaoApp == "tesoura")
//        ) {
//            textResultado.setText("Voce Ganhou!!");
//        } else {
//            textResultado.setText("Empatamos !!");
//        }
//
//    }

}