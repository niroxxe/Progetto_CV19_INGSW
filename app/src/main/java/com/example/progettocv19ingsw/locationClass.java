package com.example.progettocv19ingsw;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class locationClass implements Parcelable {
    private String locationName;
    private String locationType;
    private String address;
    private String locationDescription;
    private String locationImage;
    private float averageRating;
    private int reviewNumber;

    public locationClass(){

    }

    protected locationClass(Parcel in) {
        locationName = in.readString();
        locationType = in.readString();
        address = in.readString();
        locationDescription = in.readString();
        locationImage = in.readString();
        averageRating = in.readFloat();
        reviewNumber = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(locationName);
        dest.writeString(locationType);
        dest.writeString(address);
        dest.writeString(locationDescription);
        dest.writeString(locationImage);
        dest.writeFloat(averageRating);
        dest.writeInt(reviewNumber);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<locationClass> CREATOR = new Creator<locationClass>() {
        @Override
        public locationClass createFromParcel(Parcel in) {
            return new locationClass(in);
        }

        @Override
        public locationClass[] newArray(int size) {
            return new locationClass[size];
        }
    };

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationImage() {
        return locationImage;
    }

    public void setLocationImage(String locationImage) {
        this.locationImage = locationImage;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public int getReviewNumber() {
        return reviewNumber;
    }

    public void setReviewNumber(int reviewNumber) {
        this.reviewNumber = reviewNumber;
    }
}
