package com.board.out.outdoormanger.network;

import android.test.mock.MockContentProvider;

import com.board.out.outdoormanger.model.User;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface LoginService {
        @GET("/user")
        Observable<User> getUser();
}
