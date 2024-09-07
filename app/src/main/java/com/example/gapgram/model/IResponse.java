package com.example.gapgram.model;

public interface  IResponse<T> {

    public void onSuccess(T responseBody);
    public void onFail();

}
