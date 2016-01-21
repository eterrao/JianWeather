package com.dreamyrao.jianweather.ui.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.dreamyrao.jianweather.R;
import com.dreamyrao.jianweather.bean.WeatherBean;
import com.dreamyrao.jianweather.utils.AppConstant;
import com.dreamyrao.jianweather.utils.AsyncRequestable;
import com.dreamyrao.jianweather.utils.Executable;
import com.dreamyrao.jianweather.utils.HttpUtils;

public class MainActivity extends AppCompatActivity {
    private TextView cityNameTV;
    private TextView tmpValueTV;
    private TextView humValueTV;
    private TextView flValueTV;
    private TextView pm25TV;
    private TextView airQltyTV;
    private Toolbar toolbar;
    private CollapsingToolbarLayout toolbarLayout;
    private FloatingActionButton fab;

    private RequestQueue queue;

    private WeatherBean weatherBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
        initView();

    }

    private void initView() {
        cityNameTV = (TextView) findViewById(R.id.tv_city_name);
        tmpValueTV = (TextView) findViewById(R.id.tv_value_tmp);
        humValueTV = (TextView) findViewById(R.id.tv_value_hum);
        airQltyTV = (TextView) findViewById(R.id.tv_value_quality);
        flValueTV = (TextView) findViewById(R.id.tv_value_fl);
        pm25TV = (TextView) findViewById(R.id.tv_value_pm25);

        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        getWeatherInfo();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWeatherInfo();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    private void getWeatherInfo() {
        HttpUtils.doVolleyPost(new AsyncRequestable() {
            @Override
            public String getQueueTag() {
                return null;
            }

            @Override
            public RequestQueue getQueue() {
                return queue;
            }
        }, HttpUtils.getWeatherUrl(), new Executable<String>() {
            @Override
            public void execute(String s) {
//                Toast.makeText(MainActivity.this, s.toString(), Toast.LENGTH_SHORT).show();
                cityNameTV.setText(weatherBean.createFromJsonString(s.toString()).getCity());
                tmpValueTV.setText(weatherBean.createFromJsonString(s.toString()).getTmp());
                toolbarLayout.setTitle("当前温度：" + tmpValueTV.getText().toString());
                humValueTV.setText(weatherBean.createFromJsonString(s.toString()).getHum());
                airQltyTV.setText(weatherBean.createFromJsonString(s.toString()).getQlty());
                flValueTV.setText(weatherBean.createFromJsonString(s.toString()).getFl());
                pm25TV.setText(weatherBean.createFromJsonString(s.toString()).getPm25());
            }
        }, new Executable<VolleyError>() {
            @Override
            public void execute(VolleyError volleyError) {

            }
        }, "cityid", AppConstant.API_WEATHER_CITY_ID, "key", AppConstant.API_WEATHER_KEY);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
