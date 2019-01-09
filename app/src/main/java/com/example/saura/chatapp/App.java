package com.example.saura.chatapp;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("TYgat8ttL4CL3xHzmdsLbM3da3tqmzzAcjZUOOuH")
                // if defined
                .clientKey("z22zheBKT5IoLrZzG3scyP2sAyM9BYeDsCw0CwUQ")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
