package com.example.gapgram.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gapgram.R;
import com.example.gapgram.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> postList;
    private Context context;

    public PostAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Post post = postList.get(position);

        // تنظیم عنوان پست
        holder.titleTextView.setText(post.getTitle());

        // تنظیم زمان پست
        holder.timeTextView.setText(post.getCreated_time());

        // تنظیم تصویر پست
        Glide.with(context).load(post.getImage()).into(holder.postImageView);

        // تنظیم متن پست
        holder.messageTextView.setText(post.getMessage());

        // تنظیم تعداد لایک‌ها
        holder.likesTextView.setText(post.getLikes_count() + " Likes");

        // تنظیم تعداد کامنت‌ها
        holder.commentsTextView.setText(post.getComments_count() + " Comments");

        // تنظیم تعداد اشتراک‌گذاری‌ها
        holder.sharesTextView.setText(post.getShares_count() + " Shares");
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView timeTextView;
        ImageView postImageView;
        TextView messageTextView;
        TextView likesTextView;
        TextView commentsTextView;
        TextView sharesTextView;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            postImageView = itemView.findViewById(R.id.postImageView);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            likesTextView = itemView.findViewById(R.id.likesTextView);
            commentsTextView = itemView.findViewById(R.id.commentsTextView);
            sharesTextView = itemView.findViewById(R.id.sharesTextView);
        }
    }

    public void updatePosts(List<Post> posts) {
        this.postList = posts;
        notifyDataSetChanged();
    }
}