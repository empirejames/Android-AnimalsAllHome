package com.james.animalsallhome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

/**
 * Created by 101716 on 2017/10/18.
 */

public class WheelPicker extends Activity {
    private NumberPicker mPicker;
    private Button btn_text;
    private String getValue;
    private String result;
    private String TAG = WheelPicker.class.getSimpleName();
    private String[] data = new String[]{"臺北市", "新北市", "基隆市", "宜蘭縣"
            ,"桃園市", "新竹縣", "新竹市", "苗栗縣"
            , "臺中市", "彰化縣", "南投縣"
            , "雲林縣", "嘉義縣", "嘉義市", "臺南市"
            , "高雄市", "屏東縣"
            , "花蓮縣", "臺東縣"
            , "澎湖縣", "金門縣", "連江縣"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheelpicker);
        mPicker = (NumberPicker) findViewById(R.id.number_picker);
        btn_text = (Button) findViewById(R.id.button2);
        mPicker.setMinValue(0);
        mPicker.setMaxValue(data.length - 1);
        mPicker.setDisplayedValues(data);
        result = data[0];
        mPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            public void onValueChange(NumberPicker view, int oldValue, int newValue) {
                getValue = String.valueOf(newValue+2);
                Log.e(TAG,data[newValue]);
                result = data[newValue];

            }
        });
        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity();
            }
        });
    }

    public void goToActivity(){
        Intent i = new Intent(WheelPicker.this, MainActivity.class);
        i.putExtra("area", result);
        startActivity(i);
    }
}
