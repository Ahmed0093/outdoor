package com.board.out.outdoormanger.network;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCLient {

        private final static String BASE_URL = "https://min-api.cryptocompare.com/";

        private static Retrofit retrofit = null;

        public static Retrofit getClient(Context context) {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(BASE_URL)
                        .build();
            }
            return retrofit;
        }

}
