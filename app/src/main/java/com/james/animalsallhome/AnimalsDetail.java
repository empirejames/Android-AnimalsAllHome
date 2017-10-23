package com.james.animalsallhome;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by 101716 on 2017/9/13.
 */

public class AnimalsDetail extends AppCompatActivity {
    private ArrayList<String> getMedData = new ArrayList<String>();
    private String animal_status, animal_id, animal_subid, animal_place, animal_foundplace, animal_update, shelter_address, shelter_tel, album_file;
    private String TAG = AnimalsDetail.class.getSimpleName();
    private TextView tv_name, tv_subid, tv_place, tv_foundplace, tv_update, tv_address, tv_tel, tv_status;

    private Button tv_ZooMap, tv_voiceZoo;
    private ImageView imgView;
    private Button button;
    private String strInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animaldetail);
        initView();
        Intent intent = getIntent();
        Bundle buldle = intent.getExtras();
        animal_id = buldle.getString("animal_id");
        animal_subid = buldle.getString("animal_subid");
        animal_place = buldle.getString("animal_place");
        animal_foundplace = buldle.getString("animal_foundplace");
        animal_update = buldle.getString("animal_update");
        shelter_address = buldle.getString("shelter_address");
        shelter_tel = buldle.getString("shelter_tel");
        album_file = buldle.getString("album_file");
        animal_status = buldle.getString("animal_status");
        setTvValue();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_right_1, R.anim.slide_in_right_2);
            }
        });
        tv_ZooMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String vDirectionUrl = "https://maps.google.com/maps?q=" + shelter_address;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(vDirectionUrl));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
        tv_voiceZoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntentDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + strInput));
                startActivity(myIntentDial);
            }
        });
        imgView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                openWebView(album_file);
            }
        });


        new DownloadImageTask((ImageView) findViewById(R.id.img_pic))
                .execute(album_file);
    }

    @Override
    public void onBackPressed() {
        this.finish();
        overridePendingTransition(R.anim.slide_in_right_1, R.anim.slide_in_right_2);
    }
    public void initView() {
        imgView = (ImageView) findViewById(R.id.img_pic);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_subid = (TextView) findViewById(R.id.animal_subid);
        tv_place = (TextView) findViewById(R.id.animal_place);
        tv_foundplace = (TextView) findViewById(R.id.animal_foundplace);
        tv_update = (TextView) findViewById(R.id.animal_update);
        tv_address = (TextView) findViewById(R.id.shelter_address);
        tv_tel = (TextView) findViewById(R.id.animal_tel);
        tv_status = (TextView) findViewById(R.id.tv_status);
        button = (Button) findViewById(R.id.btnReturn);
        tv_ZooMap = (Button) findViewById(R.id.zooMap);
        tv_ZooMap.getBackground().setAlpha(0);
        tv_voiceZoo = (Button) findViewById(R.id.voiceZoo);
        tv_voiceZoo.getBackground().setAlpha(0);
    }

    public void setTvValue() {
        tv_name.setText(animal_id);
        tv_subid.setText(animal_subid);
        tv_place.setText(animal_place);
        tv_foundplace.setText(animal_foundplace);
        tv_update.setText(animal_update);
        tv_address.setText(shelter_address);
        tv_tel.setText(shelter_tel);
        if (shelter_tel.length() > 11) {
            strInput = getTelNumber(shelter_tel);
        } else {
            Log.e(TAG,"else shelter_tel : " + shelter_tel);
            strInput = shelter_tel;
        }
        tv_status.setText(animal_status);
    }

    private String getTelNumber(String str) {
        Log.e(TAG,"str: " + str  + " " + shelter_tel.length());
        String result = str.substring(0, shelter_tel.length() - 12);
        return result;
    }
    private void openWebView(String url) {
        Intent intentWV = new Intent(AnimalsDetail.this, WebViewActivity.class);
        intentWV.putExtra("URL", url);
        startActivity(intentWV);
        overridePendingTransition(R.anim.slide_in_left_1, R.anim.slide_in_left_2);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
