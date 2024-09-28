package com.example.imgareaeg;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ImageButton ib1 ,ib2;
    private final int[] Photos = {R.drawable.ex1,R.drawable.ex2,R.drawable.ex3,R.drawable.ex4,R.drawable.ex5,R.drawable.ex6,R.drawable.ex7};
    int CurrentIndex = 0;
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



        img = findViewById(R.id.mainimg);
        ib1 = findViewById((R.id.ib1));
        ib2 = findViewById((R.id.ib2));

        img.setImageResource(Photos[CurrentIndex]);

        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CurrentIndex > 0){
                    CurrentIndex--;
                    img.setImageResource(Photos[CurrentIndex]);
                }
            }
        });

        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CurrentIndex < Photos.length -1)
                {
                    CurrentIndex++;
                    img.setImageResource(Photos[CurrentIndex]);
                }
            }
        });

    }
}