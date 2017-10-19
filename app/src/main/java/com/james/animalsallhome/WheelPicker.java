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
    private NumberPicker mPicker, mPicker2;
    private Button btn_text;
    private String getValue = "2";
    private String getAnimalHome;
    private String[] data_local;
    private String TAG = WheelPicker.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheelpicker);
        mPicker = (NumberPicker) findViewById(R.id.number_picker);
        mPicker2 = (NumberPicker) findViewById(R.id.number_picker_home);
        btn_text = (Button) findViewById(R.id.button2);
        String[] data = getResources().getStringArray(R.array.city);
        mPicker.setMinValue(0);
        mPicker.setMaxValue(data.length - 1);
        mPicker.setDisplayedValues(data);
        mPicker2.setDisplayedValues(getResources().getStringArray(R.array.Taipei));
        mPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int oldValue, int newValue) {
                getAnimalHome = data_local[newValue];
                //Log.e(TAG,data_local[newValue]);
            }
        });

        mPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            public void onValueChange(NumberPicker view, int oldValue, int newValue) {
                getValue = String.valueOf(newValue + 2);
                data_local = null;
                mPicker = null;
                mPicker2.setDisplayedValues(null);
                if (getValue.equals("2")) {
                    data_local = getResources().getStringArray(R.array.Taipei);
                }
                if (getValue.equals("3")) {
                    data_local = getResources().getStringArray(R.array.NewTaipei);
                }
                if (getValue.equals("4")) {
                    data_local = getResources().getStringArray(R.array.kiLong);
                }
                if (getValue.equals("5")) {
                    data_local = getResources().getStringArray(R.array.YiLamg);
                }
                if (getValue.equals("6")) {
                    data_local = getResources().getStringArray(R.array.Taouan);
                }
                if (getValue.equals("7")) {
                    data_local = getResources().getStringArray(R.array.ShinChuLine);
                }
                if (getValue.equals("8")) {
                    data_local = getResources().getStringArray(R.array.ShinChu);
                }
                if (getValue.equals("9")) {
                    data_local = getResources().getStringArray(R.array.MauLiCity);
                }
                if (getValue.equals("10")) {
                    data_local = getResources().getStringArray(R.array.TaiChung);
                }
                if (getValue.equals("11")) {
                    data_local = getResources().getStringArray(R.array.ChanHua);
                }
                if (getValue.equals("12")) {
                    data_local = getResources().getStringArray(R.array.NaiTao);
                }
                if (getValue.equals("13")) {
                    data_local = getResources().getStringArray(R.array.YunLin);
                }
                if (getValue.equals("14")) {
                    data_local = getResources().getStringArray(R.array.ChaYi);
                }
                if (getValue.equals("15")) {
                    data_local = getResources().getStringArray(R.array.ChaYiCity);
                }
                if (getValue.equals("16")) {
                    data_local = getResources().getStringArray(R.array.TaiNam);
                }
                if (getValue.equals("17")) {
                    data_local = getResources().getStringArray(R.array.KaoShung);
                }
                if (getValue.equals("18")) {
                    data_local = getResources().getStringArray(R.array.PingTung);
                }
                if (getValue.equals("19")) {
                    data_local = getResources().getStringArray(R.array.HuaLang);
                }
                if (getValue.equals("20")) {
                    data_local = getResources().getStringArray(R.array.TaiTung);
                }
                if (getValue.equals("21")) {
                    data_local = getResources().getStringArray(R.array.PongHu);
                }
                if (getValue.equals("22")) {
                    data_local = getResources().getStringArray(R.array.KingMan);
                }
                if (getValue.equals("23")) {
                    data_local = getResources().getStringArray(R.array.LangChung);
                }
                if (data_local != null) {
                    getAnimalHome = data_local[0];
                    mPicker2.setMinValue(0);
                    mPicker2.setMaxValue(data_local.length - 1);
                    mPicker2.setDisplayedValues(data_local);
                }
            }
        });
        btn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity();
            }
        });
    }

    public void goToActivity() {
        Intent i = new Intent(WheelPicker.this, MainActivity.class);
        Log.e(TAG, "Get Value " + getAnimalHome);
        i.putExtra("area", getAnimalHome);
        startActivity(i);
    }
}
