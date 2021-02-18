package com.chengfu.android.utils.demo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chengfu.android.utils.ColorUtils;

import java.text.MessageFormat;

public class ColorUtilsDemoActivity extends BaseUtilsActivity {

    private TextView parseColor;
    private EditText parseEditText;
    private Button parseBtn;
    private ImageView parseImg;
    private Button randomColorBtn;
    private TextView randomColorText;
    private ImageView randomColorImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_color_utils_demo);

        parseColor = findViewById(R.id.parseColor);
        parseEditText = findViewById(R.id.parseEditText);
        parseBtn = findViewById(R.id.parseBtn);
        parseImg = findViewById(R.id.parseImg);
        randomColorBtn = findViewById(R.id.randomColorBtn);
        randomColorText = findViewById(R.id.randomColorText);
        randomColorImg = findViewById(R.id.randomColorImg);

        parseBtn.setOnClickListener(v -> {
            if (parseEditText.getText() != null) {
                int color = ColorUtils.parseColor(parseEditText.getText().toString());
                parseColor.setText(MessageFormat.format("解析后: {0},是否浅色：{1}", color, ColorUtils.isLightColor(color)));
                parseImg.setBackgroundColor(color);
            }
        });

        randomColorBtn.setOnClickListener(v -> {
            int randomColor = ColorUtils.randomColor();
            randomColorText.setText(ColorUtils.color2RgbString(randomColor));
            randomColorImg.setBackgroundColor(randomColor);
        });

    }
}
