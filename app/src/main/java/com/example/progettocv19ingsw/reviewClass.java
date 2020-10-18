package com.example.progettocv19ingsw;

import android.os.Parcel;
import android.os.Parcelable;

public class reviewClass implements Parcelable {
    private String reviewerName;
    private int reviewScore;
    private String reviewText;
    private String reviewerImage;

    public reviewClass(){

    }

    public reviewClass(String reviewerName, int reviewScore, String reviewText, String reviewerImage) {
        this.reviewerName = reviewerName;
        this.reviewScore = reviewScore;
        this.reviewText = reviewText;
        this.reviewerImage = reviewerImage;
    }

    protected reviewClass(Parcel in) {
        reviewerName = in.readString();
        reviewScore = in.readInt();
        reviewText = in.readString();
        reviewerImage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(reviewerName);
        dest.writeInt(reviewScore);
        dest.writeString(reviewText);
        dest.writeString(reviewerImage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<reviewClass> CREATOR = new Creator<reviewClass>() {
        @Override
        public reviewClass createFromParcel(Parcel in) {
            return new reviewClass(in);
        }

        @Override
        public reviewClass[] newArray(int size) {
            return new reviewClass[size];
        }
    };

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getReviewerImage() {
        return reviewerImage;
    }

    public void setReviewerImage(String reviewerImage) {
        this.reviewerImage = reviewerImage;
    }
}
