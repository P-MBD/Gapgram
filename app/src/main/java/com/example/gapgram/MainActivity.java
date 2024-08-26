package com.example.gapgram;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.gapgram.adapter.PostAdapter;
import com.example.gapgram.databinding.ActivityMainBinding;
import com.example.gapgram.model.IListResponse;
import com.example.gapgram.model.IResponse;
import com.example.gapgram.model.Post;
import com.example.gapgram.serviceCaller.WebserviceCaller;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;
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
  /* if(ApplicationPermission.isStoragePermissionGranted(MainActivity.this))
        {

        }*/
        // Request permission using Dexter
      /*   Dexter.withActivity(this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        Log.e("Permission", "Granted");
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Log.e("Permission", "Denied");
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        Log.e("Permission", "Rationale should be shown");
                        token.continuePermissionRequest();
                    }
                }).check(); */

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