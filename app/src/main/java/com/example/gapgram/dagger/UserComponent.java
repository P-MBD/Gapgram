package com.example.gapgram.dagger;

import com.example.gapgram.model.User;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {
    User provideUser();
}

