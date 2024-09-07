package com.example.gapgram.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.practice.IGameService;
import com.example.practice.IRequestCallback;

public class GameService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mbinder;
    }
    public  final IGameService.Stub mbinder = new IGameService.Stub() {
        @Override
        public void newMatch(String params) throws RemoteException {
            Log.e("","");
        }

        @Override
        public void canAcceptMatch(String params, IRequestCallback callback) throws RemoteException {
            Log.e("","");
        }

        @Override
        public void startApp(String params) throws RemoteException {
            Log.e("","");
        }
    };
}
