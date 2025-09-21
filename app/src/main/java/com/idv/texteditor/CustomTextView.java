package com.idv.texteditor;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomTextView {

    Context context;
    ConstraintLayout constraintLayout;
    TextView currentTextView;
    int selectedViews = 0;

    public CustomTextView(Context context, ConstraintLayout constraintLayout) {
        this.context = context;
        this.constraintLayout = constraintLayout;

        this.currentTextView = new TextView(context);

        this.currentTextView.setText("New Text");
        this.currentTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        params.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        params.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;
        params.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
        params.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;

        this.currentTextView.setLayoutParams(params);
        constraintLayout.addView(this.currentTextView);
        this.currentTextView.setTextIsSelectable(true);

        this.currentTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Text " + CustomTextView.this.currentTextView.getText().toString() + " clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        this.currentTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setBackgroundResource(R.drawable.onfocus_background);
                selectedViews++;
                return true;
            }
        });

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedViews > 0) {
                    CustomTextView.this.currentTextView.setBackgroundResource(R.drawable.lostfocus_background);
                }
            }
        });
    }
}
