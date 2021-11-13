package enis.tn;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
//importation des widgets
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //déclaration des variables

    private EditText poids;
    private EditText taille;
    private EditText age;
    private RadioButton sexeh;
    private ImageView img;
    private TextView message;
    private TextView message2;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ecoute_btn_calcul();
        ecoute_btn_acceuil();
        
    }
    private void init() {
        //pointer les variables sur les widgets

        poids = (EditText) findViewById(R.id.editTextNumber2);
        taille = (EditText) findViewById(R.id.editTextNumber3);
        age = (EditText) findViewById(R.id.editTextNumber4);
        sexeh = (RadioButton) findViewById(R.id.radioButton);
        btn = (Button) findViewById(R.id.button2);
        img = (ImageView) findViewById(R.id.imageView2);
        message = (TextView) findViewById(R.id.resultat);
        message2 = (TextView) findViewById(R.id.text_coments);
    }
    private void ecoute_btn_calcul(){
        //permet de calculer l'IMG
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer p = Integer.parseInt(poids.getText().toString());
                Integer t = Integer.parseInt(taille.getText().toString());
                Integer a = Integer.parseInt(age.getText().toString());
                Integer s;
                if (sexeh.isChecked()) {
                    s = 1;
                } else
                    s = 0;

                float tc=(float)t/100;

                float r = (float)(((1.2 * p) / (tc * tc)) + (0.23 * a) - (10.83 * s) - 5.4);
                String m="";
                if (s == 0) {
                    if (r < 15) {
                        m = "trop maigre";
                        message.setTextColor(Color.RED);
                        message2.setTextColor(Color.RED);
                    } else if (r > 15 && r < 30) {
                        m = "normale";
                        message.setTextColor(Color.GREEN);
                        message2.setTextColor(Color.GREEN);
                    } else if (r > 30) {
                        m = "trop graisse";
                        message.setTextColor(Color.RED);
                        message2.setTextColor(Color.RED);
                    }
                } else {
                    if (r < 10) {
                        m = "trop maigre";
                        message.setTextColor(Color.RED);
                        message2.setTextColor(Color.RED);
                    } else if (r > 10 && r < 25) {
                        m = "normale";
                        message.setTextColor(Color.GREEN);
                        message2.setTextColor(Color.GREEN);
                    } else if (r > 25) {
                        m = "trop graisse";
                        message.setTextColor(Color.RED);
                        message2.setTextColor(Color.RED);
                    }
                }
                if (m == "trop maigre") {
                    img.setImageResource(R.drawable.maigre);
                } else if (m == "normale") {
                    img.setImageResource(R.drawable.normal);
                } else {
                    img.setImageResource(R.drawable.graisse);
                }
                message.setText("IMG = " + r );
                message2.setText(m);


            }
        });

    }

    private void ecoute_btn_acceuil() {
        //permet de revenir à la page d'accueil

        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View v) {
                Intent iii = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(iii);

            }
        });
    }
}

