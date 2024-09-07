package com.example.gapgram.serviceCaller;



import com.example.gapgram.PostCount;
import com.example.gapgram.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("posts/count/")
    Call<PostCount> getPostCount();

    @GET("posts/")
    Call<List<Post>> getPosts();








}
