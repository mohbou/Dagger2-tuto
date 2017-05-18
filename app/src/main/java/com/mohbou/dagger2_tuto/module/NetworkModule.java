package com.mohbou.dagger2_tuto.module;

import android.content.Context;
import java.io.File;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes=ContextModule.class)
public class NetworkModule {



    @Provides
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {

       return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    public Cache cache(File file) {
          file.mkdir();
        return new Cache(file, 10 * 1000 * 1000);//10mb file
    }

    @Provides
    HttpLoggingInterceptor loggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
    }

    @Provides
    public File file(Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

}
