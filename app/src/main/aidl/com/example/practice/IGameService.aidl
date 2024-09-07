// IGameService.aidl
package com.example.practice;
import com.example.practice.IRequestCallback;
// Declare any non-default types here with import statements

interface IGameService {
   void newMatch(String params);
   void canAcceptMatch(String params, IRequestCallback callback);
   void startApp(String params);
}