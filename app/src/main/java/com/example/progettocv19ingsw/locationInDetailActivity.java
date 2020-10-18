package com.example.progettocv19ingsw;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class locationInDetailActivity extends AppCompatActivity {
    private static final String TAG = "locationDetailActivity";
    private Button toReviews;
    private TextView locationName;
    private TextView locationType;
    private TextView locationDescription;
    private RatingBar locationAverageRating;
    private TextView locationAddress;
    private ImageView locationDefImage;
    private TextView locationReviewNumber;
    private Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        final locationClass chosenLocation = intent.getParcelableExtra("chosenLocation");
        setContentView(R.layout.location_data);
        locationName = findViewById(R.id.locationName5);
        locationName.setText(chosenLocation.getLocationName());
        locationType = findViewById(R.id.locationType5);
        locationType.setText(chosenLocation.getLocationType());
        locationDescription = findViewById(R.id.locationDescription);
        locationDescription.setText(chosenLocation.getLocationDescription());
        locationAverageRating = findViewById(R.id.average_rating);
        locationAverageRating.setRating(chosenLocation.getAverageRating());
        locationAddress = findViewById(R.id.address5);
        locationAddress.setText(chosenLocation.getAddress());
        locationDefImage = findViewById(R.id.imageView2);
        Picasso.get().load(chosenLocation.getLocationImage()).fit().centerCrop().into(locationDefImage);
        locationReviewNumber = findViewById(R.id.review_number5);
        int revs = chosenLocation.getReviewNumber();
        locationReviewNumber.setText(String.valueOf(revs));
        toReviews = findViewById(R.id.goToReviews);
        locationDefImage = findViewById(R.id.imageView2);
        Log.d(TAG, "onCreate: Started");
        toReviews.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(chosenLocation.getReviewNumber() > 0) {
                    Intent intent = new Intent(context, reviewActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(locationInDetailActivity.this, "Questo posto non ha recensioni", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}