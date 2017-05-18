package com.mohbou.dagger2_tuto.module;

import com.mohbou.dagger2_tuto.network.YhooServiceAPI;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class YHooServiceModule {
    private static final String BASE_URL = "https://query.yahooapis.com/v1/public/";
    @Provides
    public YhooServiceAPI getYhooServiceAPI(Retrofit retrofit) {
        return retrofit.create(YhooServiceAPI.class);
    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

}
