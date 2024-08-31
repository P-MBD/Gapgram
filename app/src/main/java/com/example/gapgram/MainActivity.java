package com.example.gapgram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gapgram.adapter.PostAdapter;
import com.example.gapgram.databinding.ActivityMainBinding;
import com.example.gapgram.model.IListResponse;
import com.example.gapgram.model.IResponse;
import com.example.gapgram.model.Post;
import com.example.gapgram.serviceCaller.WebserviceCaller;
import com.example.gapgram.ui.profile.ProfileForm;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding>  {
    RecyclerView recyclerView;
    WebserviceCaller webserviceCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Use binding to access views
        recyclerView = binding.recyclerPosts;
        webserviceCaller = new WebserviceCaller();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        getCount();
        try {
            getPosts();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BottomNavigationView bottomNavigationView = binding.menuBottom;
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.navigation_home) {
                    // Handle home action
                    return true;
                } else if (itemId == R.id.navigation_search) {
                    // Handle search action
                    return true;
                } else if (itemId == R.id.navigation_profile) {
                    // Handle profile action
                    openProfileActivity();
                    return true;
                }
                return false;
            }
        });

    }



    @Override
    protected ActivityMainBinding inflateBindingLayout() {
        // Inflate the layout using View Binding
        return ActivityMainBinding.inflate(getLayoutInflater());
    }
    private void openProfileActivity() {
        Intent intent = new Intent(MainActivity.this, ProfileForm.class);
        startActivity(intent);
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

    public void getPosts() throws  Exception{
        webserviceCaller.getPosts(new IListResponse() {
            @Override
            public void onSuccess(List responseBody) {
                recyclerView.setAdapter(new PostAdapter(MainActivity.this, responseBody));

            }

            @Override
            public void onFail() {

            }
        });
    }

       /* if(ApplicationPermission.isStoragePermissionGranted(MainActivity.this))
        {

        }*/



}