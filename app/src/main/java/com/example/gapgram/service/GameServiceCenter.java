package com.example.gapgram.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.practice.IGameService;

public class GameServiceCenter {

    private IGameService gameService;

    public void init(Context context) {
        Intent intent = new Intent("com.example.practice.IGameService");
        intent.setPackage("com.example.practice");

        context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            gameService = IGameService.Stub.asInterface(service);
            Log.d("GameServiceCenter", "Service connected");

            try {
                // فراخوانی متد newMatch
                gameService.newMatch("New Match from Gapgram");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            gameService = null;
            Log.d("GameServiceCenter", "Service disconnected");
        }
    };

    public void startMatch() {
        if (gameService != null) {
            try {
                gameService.newMatch("Start new match");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
