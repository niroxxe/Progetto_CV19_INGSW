package com.example.progettocv19ingsw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.viewHolder> implements Filterable {

    Context context;
    ArrayList<reviewClass> reviews;
    ArrayList<reviewClass> reviewCopy;

    public ReviewAdapter(Context c, ArrayList<reviewClass> r){
        context = c;
        reviews = r;
        reviewCopy = new ArrayList<>(r);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(context).inflate(R.layout.review_recyclerrow, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.reviewerName.setText(reviews.get(position).getReviewerName());
        holder.reviewText.setText(reviews.get(position).getReviewText());
        holder.reviewRating.setRating(reviews.get(position).getReviewScore());
        Glide.with(context).asBitmap().load(reviews.get(position).getReviewerImage()).into(holder.reviewerImage);
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView reviewerName, reviewText;
        RatingBar reviewRating;
        ImageView reviewerImage;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            reviewerName = (TextView) itemView.findViewById(R.id.reviewerName);
            reviewText = (TextView) itemView.findViewById(R.id.reviewText);
            reviewRating = (RatingBar) itemView.findViewById(R.id.reviewRating);
            reviewerImage = (ImageView) itemView.findViewById(R.id.reviewerImage);
        }
    }

    @Override
    public Filter getFilter() {
        return reviewFilter;
    }

    private Filter reviewFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<reviewClass> filteredList = new ArrayList<>();
            if(constraint == null || constraint.length() == 0){
                filteredList.addAll(reviewCopy);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for(reviewClass rev : reviewCopy){
                    if(rev.getReviewerName().toLowerCase().contains(filterPattern)){
                        filteredList.add(rev);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            reviewCopy.clear();
            reviewCopy.addAll((ArrayList) results.values);
            notifyDataSetChanged();
        }
    };
}