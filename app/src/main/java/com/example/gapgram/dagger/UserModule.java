package com.example.gapgram.dagger;

import android.util.Log;

import com.example.gapgram.model.Contact;
import com.example.gapgram.model.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UserModule {

    @Provides
    @Singleton
    Contact provideContact(){
        Log.d("UserModule", "Providing new Contact");
        return new Contact();
    }

    @Provides
    @Singleton
    User provideUser(){
        Log.d("UserModule", "Providing new User with Contact");
        return new User(new Contact());
    }
}
