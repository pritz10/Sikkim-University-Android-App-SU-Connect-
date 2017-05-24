package com.pritz.sikkimuniversity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

/**
 * Created by Alaeddin on 5/14/2017.
 */

public class DisplayData extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_displaydata);

        String UserNameStr=getIntent().getStringExtra("UserName");
        String PasswordStr=getIntent().getStringExtra("Password");
        TextView UserNameTV=(TextView)findViewById(R.id.tvUserName);
        TextView PasswordTV=(TextView)findViewById(R.id.tvPassword);
        UserNameTV.setText(UserNameStr);
        PasswordTV.setText(PasswordStr);
    }
}
