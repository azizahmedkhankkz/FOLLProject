package com.example.xubii.follproject.database;

import android.net.Uri;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Xubii on 17-Apr-18.
 */

@IgnoreExtraProperties
public class groundFB
{
    String groundName, ownerName, location, phone, email;
    Uri image;

    public groundFB(String groundName, String ownerName, String location, String phone, String email, Uri image) {
        this.groundName = groundName;
        this.ownerName = ownerName;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.image = image;
    }

    public groundFB()
    {
    }

    public String getGroundName() {
        return groundName;
    }

    public void setGroundName(String groundName) {
        this.groundName = groundName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }
}
