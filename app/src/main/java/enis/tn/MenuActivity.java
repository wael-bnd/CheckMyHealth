package enis.tn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ImageButton imageButton_img = (ImageButton) findViewById(R.id.imageButton_img);
        imageButton_img. setOnClickListener (new ImageButton.OnClickListener() {

            public void onClick (View v){
                //permet d'aller à la page de calcule

                Intent j = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(j);

            }
        });

    }
}
