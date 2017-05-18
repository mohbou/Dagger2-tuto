package com.mohbou.dagger2_tuto.component;


import com.mohbou.dagger2_tuto.module.YHooServiceModule;
import com.mohbou.dagger2_tuto.network.YhooServiceAPI;

import dagger.Component;

@Component(modules = YHooServiceModule.class)
public interface ActivtyViewComponent {
    YhooServiceAPI getYhooServiceAPI();
}
