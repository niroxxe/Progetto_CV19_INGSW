/*package com.example.progettocv19ingsw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.RatingBar;
import android.widget.Spinner;

import java.util.ArrayList;

public class AdvancedFilters extends AppCompatActivity implements TextWatcher, AdapterView.OnItemSelectedListener, RatingBar.OnRatingBarChangeListener {

    private Button apply_filters;
    private EditText addressEdit, minPriceEdit, maxPriceEdit;
    private Spinner typeSpin;
    private RatingBar minimumRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_filters);
        apply_filters = findViewById(R.id.applyButton);
        addressEdit = findViewById(R.id.indirizzoEdit);
        minPriceEdit = findViewById(R.id.minimumEdit);
        maxPriceEdit = findViewById(R.id.maximumEdit);
        typeSpin = findViewById(R.id.typeSpinner);
        minimumRating = findViewById(R.id.ratingBar);
        apply_filters.addTextChangedListener(this);
        addressEdit.addTextChangedListener(this);
        minPriceEdit.addTextChangedListener(this);
        maxPriceEdit.addTextChangedListener(this);
        typeSpin.setOnItemSelectedListener(this);
        minimumRating.setOnRatingBarChangeListener(this);
    }

    private void filter(String addressFilter, String minPriceFilter, String maxPriceFilter, String typeFilter, float minRatingFilter){
        ArrayList<locationClass> locations = null;
        locations = RecyclerViewAdapter.getArrayList();
        ArrayList<locationClass> filteredList = null;
        if(addressFilter == null && minPriceFilter == null && maxPriceFilter == null && typeFilter == "Qualsiasi" && minRatingFilter == 0.0){
            filteredList.addAll(locations);
        }else{
            String addressPattern = addressFilter.toLowerCase().trim();
            String minPricePattern = minPriceFilter.toLowerCase().trim();
            String maxPricePattern = maxPriceFilter.toLowerCase().trim();
            String spinnerPattern = typeFilter.toLowerCase().trim();
            for(locationClass loc : locations){
                if(loc.getLocationName().toLowerCase().contains(addressPattern) && (loc.getLocationType().toLowerCase().contains(spinnerPattern)) && (loc.getAverageRating() >= minRatingFilter)){
                    filteredList.add(loc);
                }
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String address = addressEdit.getText().toString();
        String minPrice = minPriceEdit.getText().toString();
        String maxPrice = maxPriceEdit.getText().toString();
        String spinChoice = typeSpin.getSelectedItem().toString();
        float ratingChoice = minimumRating.getRating();
        filter(address,minPrice,maxPrice,spinChoice,ratingChoice);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        String address = addressEdit.getText().toString();
        String minPrice = minPriceEdit.getText().toString();
        String maxPrice = maxPriceEdit.getText().toString();
        String spinChoice = typeSpin.getSelectedItem().toString();
        float ratingChoice = minimumRating.getRating();
        filter(address,minPrice,maxPrice,spinChoice,ratingChoice);
    }
}*/