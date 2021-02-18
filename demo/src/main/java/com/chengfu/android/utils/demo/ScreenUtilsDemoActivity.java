package com.chengfu.android.utils.demo;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chengfu.android.utils.ScreenUtils;

public class ScreenUtilsDemoActivity extends BaseUtilsActivity {

    private TextView tvInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_screen_utils_demo);

        tvInfo = findViewById(R.id.tvInfo);

        refresh();
    }

    private void refresh() {
        StringBuilder builder = new StringBuilder();

        builder.append("AppScreenWidth=");
        builder.append(ScreenUtils.getAppScreenWidth(this));
        builder.append("\n\n");
        builder.append("AppScreenHeight=");
        builder.append(ScreenUtils.getAppScreenHeight(this));
        builder.append("\n\n");

        builder.append("ScreenWidth=");
        builder.append(ScreenUtils.getScreenWidth(this));
        builder.append("\n\n");
        builder.append("ScreenHeight=");
        builder.append(ScreenUtils.getScreenHeight(this));
        builder.append("\n\n");

        builder.append("ScreenDensity=");
        builder.append(ScreenUtils.getScreenDensity());
        builder.append("\n\n");
        builder.append("ScreenDensityDpi=");
        builder.append(ScreenUtils.getScreenDensityDpi());
        builder.append("\n\n");

        builder.append("isPortrait=");
        builder.append(ScreenUtils.isPortrait(this));
        builder.append("\n\n");
        builder.append("isLandscape=");
        builder.append(ScreenUtils.isLandscape(this));
        builder.append("\n\n");

        tvInfo.setText(builder.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_screen_utils_demo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_refresh) {
            refresh();
        }
        return true;
    }
}
