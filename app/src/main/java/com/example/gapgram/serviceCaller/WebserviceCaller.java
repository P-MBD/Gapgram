package com.example.gapgram.serviceCaller;

import android.util.Log; // اضافه کردن این خط برای استفاده از Log

import com.example.gapgram.PostCount;
import com.example.gapgram.model.IListResponse;
import com.example.gapgram.model.IResponse;
import com.example.gapgram.model.Post;
import com.example.gapgram.serviceCaller.ApiClient;
import com.example.gapgram.serviceCaller.ApiInterface;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {
    private ApiInterface apiInterface;
    private static final String TAG = "WebserviceCaller";

    public WebserviceCaller() {
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
    }

    public void getPostCount(final IResponse iResponse) {
        Call<PostCount> call = apiInterface.getPostCount();
        call.enqueue(new Callback<PostCount>() {
            @Override
            public void onResponse(Call<PostCount> call, Response<PostCount> response) {
                if (response.isSuccessful() && response.body() != null) {
                    PostCount postCount = response.body();
                    int count = postCount.getCount();
                    Log.d(TAG, "Post count: " + count);
                    // ارسال count به iResponse یا استفاده از آن در برنامه
                } else {
                    Log.e(TAG, "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PostCount> call, Throwable t) {
                Log.e(TAG, "Failure: " + t.getMessage());
            }
        });
    }

    public void getPosts(final IListResponse listResponse)throws Exception{

        Call<List<Post>> call=apiInterface.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                listResponse.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                listResponse.onFail();
            }
        });

    }
}