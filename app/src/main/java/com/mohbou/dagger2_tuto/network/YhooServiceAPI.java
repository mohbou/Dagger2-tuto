package com.mohbou.dagger2_tuto.network;

import com.mohbou.dagger2_tuto.model.Stocks;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YhooServiceAPI {

@GET("yql?q=select%20*%20from%20csv%20where%20url%3D'http%3A%2F%2Fdownload.finance.yahoo.com%2Fd%2Fquotes.csv%3Fs%3DHPQ%2CYHOO%2CGOOG%2CAAPL%26f%3Dsl1d1t1c1ohgv%26e%3D.csv'%20and%20columns%3D'symbol%2Cprice%2Cdate%2Ctime%2Cchange%2Ccol1%2Chigh%2Clow%2Ccol2'&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
Call<Stocks> stocks();

}
