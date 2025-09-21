package com.idv.texteditor;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;

public class CustomTextView {

    Context context;
    ConstraintLayout constraintLayout;
    TextView currentTextView;
    int selectedViews = 0;
    boolean isSelected, isBold, isItalic, isUnderline;
    String align;

    public CustomTextView(Context context, ConstraintLayout constraintLayout, LinearLayout changeFont, TextView plusButton, TextView textSize,
                          TextView minusButton, ImageView bold, ImageView italic, ImageView underline, ImageView alignment) {
        this.context = context;
        this.constraintLayout = constraintLayout;
        this.isSelected = false;
        this.isBold = false;
        this.isItalic = false;
        this.isUnderline = false;
        this.align = "center";

        this.currentTextView = new TextView(context);

        this.currentTextView.setText("New Text");
        this.currentTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        this.currentTextView.setTypeface(null, Typeface.NORMAL);

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
                if (selectedViews > 0) {
                    v.setBackgroundResource(R.drawable.lostfocus_background);
                    selectedViews = 0;
                    CustomTextView.this.isSelected = false;
                }
            }
        });

        this.currentTextView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setBackgroundResource(R.drawable.onfocus_background);
                selectedViews++;
                CustomTextView.this.isSelected = true;
                return true;


            }
        });

        bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CustomTextView.this.isSelected) {
                    if (!CustomTextView.this.isBold) {
                        if (CustomTextView.this.isItalic)
                            CustomTextView.this.currentTextView.setTypeface(null, Typeface.BOLD_ITALIC);
                        else
                            CustomTextView.this.currentTextView.setTypeface(null, Typeface.BOLD);

                        CustomTextView.this.isBold = true;
                    } else {
                        if (CustomTextView.this.isItalic)
                            CustomTextView.this.currentTextView.setTypeface(null, Typeface.ITALIC);
                        else
                            CustomTextView.this.currentTextView.setTypeface(null, Typeface.NORMAL);

                        CustomTextView.this.isBold = false;
                    }
                }
            }
        });

        italic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CustomTextView.this.isSelected) {
                    if (!CustomTextView.this.isItalic) {
                        if (CustomTextView.this.isBold)
                            CustomTextView.this.currentTextView.setTypeface(null, Typeface.BOLD_ITALIC);
                        else
                            CustomTextView.this.currentTextView.setTypeface(null, Typeface.ITALIC);

                        CustomTextView.this.isItalic = true;
                    } else {
                            if (CustomTextView.this.isBold)
                                CustomTextView.this.currentTextView.setTypeface(null, Typeface.BOLD);
                            else
                                CustomTextView.this.currentTextView.setTypeface(null, Typeface.NORMAL);

                        CustomTextView.this.isItalic = false;
                    }
                }
            }
        });

        underline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!CustomTextView.this.isSelected) {
                    if (!CustomTextView.this.isUnderline) {
                        CustomTextView.this.currentTextView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
                        CustomTextView.this.isUnderline = true;
                    }
                    else {
                        int currentPaintFlags = CustomTextView.this.currentTextView.getPaintFlags();
                        int newPaintFlags = currentPaintFlags & ~Paint.STRIKE_THRU_TEXT_FLAG;
                        CustomTextView.this.currentTextView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
                    }
                }
            }
        });
    }
}

