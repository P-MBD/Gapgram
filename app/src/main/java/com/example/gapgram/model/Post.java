package com.example.gapgram.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Post implements Parcelable {
    private int id;
    private String title;
    private String message;
    private String created_time;
    private String image;
    private int likes_count;
    private int comments_count;
    private int shares_count;

    protected Post(Parcel in) {
        id = in.readInt();
        title = in.readString();
        message = in.readString();
        created_time = in.readString();
        image = in.readString();
        likes_count = in.readInt();
        comments_count = in.readInt();
        shares_count = in.readInt();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getCreated_time() { return created_time; }
    public void setCreated_time(String created_time) { this.created_time = created_time; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public int getLikes_count() { return likes_count; }
    public void setLikes_count(int likes_count) { this.likes_count = likes_count; }

    public int getComments_count() { return comments_count; }
    public void setComments_count(int comments_count) { this.comments_count = comments_count; }

    public int getShares_count() { return shares_count; }
    public void setShares_count(int shares_count) { this.shares_count = shares_count; }

    @Override
    public int describeContents() {
        return 0;
     }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(message);
        dest.writeString(created_time);
        dest.writeString(image);
        dest.writeInt(likes_count);
        dest.writeInt(comments_count);
        dest.writeInt(shares_count);
    }
}