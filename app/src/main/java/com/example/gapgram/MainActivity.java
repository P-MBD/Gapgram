package com.example.gapgram;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;

import com.example.gapgram.adapter.PostAdapter;
import com.example.gapgram.databinding.ActivityMainBinding;
import com.example.gapgram.model.IResponse;
import com.example.gapgram.model.Post;
import com.example.gapgram.serviceCaller.WebserviceCaller;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding>  {
    WebserviceCaller webserviceCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webserviceCaller = new WebserviceCaller();

        binding.recyclerPosts.setLayoutManager(new LinearLayoutManager(this));

        // ایجاد نمونه‌ای از آداپتر با لیستی خالی به طور موقت
        PostAdapter postAdapter = new PostAdapter(new ArrayList<>());
        binding.recyclerPosts.setAdapter(postAdapter);

        getCount();
    }

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected ActivityMainBinding inflateBindingLayout() {
        // Inflate the layout using View Binding
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    public void getCount() {
        webserviceCaller.getPostCount(new IResponse<List<Post>>() {
            @Override
            public void onSuccess(List<Post> responseBody) {
                Log.e("MainActivity", "Response to get post count");
                // به‌روزرسانی آداپتر با داده‌های جدید
            }

            @Override
            public void onFail() {
                Log.e("MainActivity", "Failed to get post count");
            }
        });
    }

}