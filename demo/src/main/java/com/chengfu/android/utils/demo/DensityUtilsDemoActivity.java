package com.chengfu.android.utils.demo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

import com.chengfu.android.utils.DensityUtils;

import java.text.MessageFormat;

public class DensityUtilsDemoActivity extends BaseUtilsActivity {
    private RadioGroup rgTarget;
    private RadioGroup rgResult;

    private EditText editTargetInput;
    private TextView tvResult;

    @IdRes
    private int targetCheckedId;
    @IdRes
    private int resultCheckedId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_density_utils_demo);

        rgTarget = findViewById(R.id.rgTarget);
        targetCheckedId = rgTarget.getCheckedRadioButtonId();
        rgTarget.setOnCheckedChangeListener((group, checkedId) -> {
            targetCheckedId = checkedId;
            convert();
        });

        editTargetInput = findViewById(R.id.editTargetInput);
        editTargetInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                convert();
            }
        });

        rgResult = findViewById(R.id.rgResult);
        resultCheckedId = rgResult.getCheckedRadioButtonId();
        rgResult.setOnCheckedChangeListener((group, checkedId) -> {
            resultCheckedId = checkedId;
            convert();
        });


        tvResult = findViewById(R.id.tvResult);

        convert();

    }

    private void convert() {
        String targetStr = editTargetInput.getText() != null ? editTargetInput.getText().toString() : null;
        if (!TextUtils.isEmpty(targetStr)) {
            float targetValue = Float.parseFloat(targetStr);
            float resultValue = targetValue;
            if (targetCheckedId == R.id.rbTargetPx) {
                if (resultCheckedId == R.id.rbResultDp) {
                    resultValue = DensityUtils.px2dp(targetValue);
                } else if (resultCheckedId == R.id.rbResultSp) {
                    resultValue = DensityUtils.px2sp(targetValue);
                }
            }else if (targetCheckedId == R.id.rbTargetDp) {
                if (resultCheckedId == R.id.rbResultPx) {
                    resultValue = DensityUtils.dp2px(targetValue);
                } else if (resultCheckedId == R.id.rbResultSp) {
                    resultValue = DensityUtils.dp2sp(targetValue);
                }
            }else if (targetCheckedId == R.id.rbTargetSp) {
                if (resultCheckedId == R.id.rbResultPx) {
                    resultValue = DensityUtils.sp2px(targetValue);
                } else if (resultCheckedId == R.id.rbResultDp) {
                    resultValue = DensityUtils.sp2dp(targetValue);
                }
            }
            tvResult.setText(MessageFormat.format("{0}", resultValue));
        } else {
            tvResult.setText("");
        }
    }
}
