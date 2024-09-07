package com.example.gapgram.service;

import com.example.practice.IGameService;

public interface LauncherService {

    public  void onResult(IGameService gameInterface);
    public  void onFail(String  ErrorMessage);
}
