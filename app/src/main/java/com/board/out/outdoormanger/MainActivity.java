package com.board.out.outdoormanger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.board.out.outdoormanger.model.User;
import com.board.out.outdoormanger.network.ApiCLient;
import com.board.out.outdoormanger.network.LoginService;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="tag" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initLoginService();
    }

    private void initLoginService() {
        LoginService loginService = ApiCLient.getClient(this).create(LoginService.class);
        loginService.getUser().
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver());
    }

    public DisposableObserver<User> getObserver(){
        // User here should be replaced with User Resonse.....
        return new DisposableObserver<User>() {

            @Override
            public void onNext(@NonNull User movieResponse) {
//                Log.d(TAG,"OnNext"+movieResponse.getTotalResults());
//                mvi.displayMovies(movieResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
//                mvi.displayError("Error fetching Movie Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
            }
        };
    }
}

