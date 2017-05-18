package com.mohbou.dagger2_tuto.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context mContext;

    public ContextModule(Context context) {
        mContext=context;
    }

    @Provides
    public Context context() {
        return mContext;
    }
}
