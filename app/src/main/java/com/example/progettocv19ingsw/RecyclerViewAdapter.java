package com.example.progettocv19ingsw;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.viewHolder> implements Filterable {

    private static final String TAG = "RecyclerView";
    Context context;
    static ArrayList<locationClass> locations;
    static ArrayList<locationClass> locationCopy;

    public RecyclerViewAdapter(Context c, ArrayList<locationClass> l){
        context = c;
        locations = l;
        locationCopy = new ArrayList<>(l);
    }

    public static ArrayList getArrayList(){
        return locations;
    }

    public void applyAdvancedFilters(ArrayList<locationClass> filteredList) {
        locations.clear();
        locations.addAll(filteredList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.location_recyclerrow, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.viewHolder holder, final int position) {
        holder.locationName.setText(locations.get(position).getLocationName());
        holder.locationType.setText(locations.get(position).getLocationType());
        holder.reviewNumber.setText(String.valueOf(locations.get(position).getReviewNumber()));
        holder.locationAddress.setText(locations.get(position).getAddress());
        holder.averageRating.setRating(locations.get(position).getAverageRating());
        holder.averageRating.setRating(locations.get(position).getAverageRating());
        holder.averageRating.setStepSize(locations.get(position).getAverageRating());
        Picasso.get().load(locations.get(position).getLocationImage()).fit().centerCrop().into(holder.locationPicture);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on " + locations.get(position));
                Intent intent = new Intent(context, locationInDetailActivity.class);
                intent.putExtra("chosenLocation", locations.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<locationClass> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(locationCopy);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(locationClass loc : locationCopy){
                    if(loc.getLocationName().toLowerCase().contains(filterPattern)){
                        filteredList.add(loc);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            locations.clear();
            locations.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }

    };

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView locationName, locationType, reviewNumber, locationAddress;
        RatingBar averageRating;
        ImageView locationPicture;
        RelativeLayout parent;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            locationName = (TextView) itemView.findViewById(R.id.locationName);
            locationPicture = (ImageView) itemView.findViewById(R.id.locationPicture);
            locationType = (TextView) itemView.findViewById(R.id.locationType);
            averageRating = (RatingBar) itemView.findViewById(R.id.averageRating);
            reviewNumber = (TextView) itemView.findViewById(R.id.reviewNumber);
            locationAddress = (TextView) itemView.findViewById(R.id.locationAddress);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}