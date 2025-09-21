package com.idv.texteditor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Canvas;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView bold, italic, underline, alignment;
    LinearLayout addText, changeFont;
    ConstraintLayout constraintLayout;
    TextView plusButton, textSize, minusButton;
//    SurfaceView surfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addText = findViewById(R.id.ll_add_text);
        changeFont = findViewById(R.id.ll_change_font);
        plusButton = findViewById(R.id.txt_plus_button);
        textSize = findViewById(R.id.txt_size);
        minusButton = findViewById(R.id.txt_minus_button);
        bold = findViewById(R.id.img_bold);
        italic = findViewById(R.id.img_italic);
        underline = findViewById(R.id.img_underline);
        alignment = findViewById(R.id.img_align);
        constraintLayout = findViewById(R.id.constraint_canvas);

        addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomTextView obj = new CustomTextView(MainActivity.this, constraintLayout, changeFont, plusButton, textSize, minusButton, bold, italic, underline, alignment);
            }
        });
    }
}