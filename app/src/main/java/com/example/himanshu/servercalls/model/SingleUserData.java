package com.example.himanshu.servercalls.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by himanshu on 6/5/17.
 */

public class SingleUserData implements Parcelable {


    @SerializedName("userId")
    private int userId;
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    protected SingleUserData(Parcel in) {
        userId = in.readInt();
        id = in.readInt();
        title = in.readString();
        body = in.readString();
    }

    public static final Creator<SingleUserData> CREATOR = new Creator<SingleUserData>() {
        @Override
        public SingleUserData createFromParcel(Parcel in) {
            return new SingleUserData(in);
        }

        @Override
        public SingleUserData[] newArray(int size) {
            return new SingleUserData[size];
        }
    };

    public int getUserId() {
        return userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(userId);
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(body);
    }
}
