package com.example.xubii.follproject.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.firebase.database.IgnoreExtraProperties;

@Entity (tableName="ground")
@IgnoreExtraProperties
public class ground
{
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo
    String groundName;
    @ColumnInfo
    String ownerName;
    @ColumnInfo
    String location;
    @ColumnInfo
    String phone;
    @ColumnInfo
    String email;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    byte[] image;
    @ColumnInfo
    int rating;

   public ground()
    {
       /* rating=0;
        id=0;
        image=null;
        */
    }

    public ground(int id, String groundName, String ownerName, String location, String phone, String email, byte[] image, int rating) {
        this.id = id;
        this.groundName = groundName;
        this.ownerName = ownerName;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.image = image;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}


