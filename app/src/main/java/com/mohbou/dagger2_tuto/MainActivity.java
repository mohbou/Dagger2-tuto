package com.mohbou.dagger2_tuto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mohbou.dagger2_tuto.component.ActivtyViewComponent;
import com.mohbou.dagger2_tuto.component.DaggerActivtyViewComponent;
import com.mohbou.dagger2_tuto.model.Row;
import com.mohbou.dagger2_tuto.model.Stocks;
import com.mohbou.dagger2_tuto.module.ContextModule;
import com.mohbou.dagger2_tuto.network.YhooServiceAPI;

import java.util.Iterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private YhooServiceAPI mService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        networkCall();
    }

    private void init() {
        Timber.plant(new Timber.DebugTree());

        ActivtyViewComponent component = DaggerActivtyViewComponent.
                builder().contextModule(new ContextModule(this))
                .build();

        mService = component.getYhooServiceAPI();
    }

    private void networkCall() {
        mService.stocks().enqueue(new Callback<Stocks>() {
            @Override
            public void onResponse(Call<Stocks> call, Response<Stocks> response) {
                Iterator<Row> iterator = response.body().getQuery().getResults().getRow().iterator();

                while (iterator.hasNext()) {
                    Row row = iterator.next();
                    Log.d("result", row.getSymbol() + " Change " + row.getChange() + " Price " + row.getPrice());
                }
            }
            @Override
            public void onFailure(Call<Stocks> call, Throwable t) {
                Log.d("result", "Something wrong happened " + t.getMessage());
            }
        });
    }
}
