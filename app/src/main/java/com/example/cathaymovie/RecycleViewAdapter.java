package com.example.cathaymovie;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    CardView cardView;
    MovieModel movieModel;
    View view;

    public RecycleViewAdapter(MovieModel movieModel) {
        this.movieModel = movieModel;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView movieName, movieEngName, movieType, movieTag, movieComeOutDay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            movieName = itemView.findViewById(R.id.movie_name);
            movieEngName = itemView.findViewById(R.id.movie_eng_name);
            movieType = itemView.findViewById(R.id.movie_type);
            movieTag = itemView.findViewById(R.id.movie_tag);
            movieComeOutDay = itemView.findViewById(R.id.movie_come_out_day);
        }
    }


    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try {
            holder.movieComeOutDay.setText(movieModel.getMovieComeOutDate().get(position));
            holder.movieName.setText(movieModel.getMovieName().get(position));
            holder.movieEngName.setText(movieModel.getMovieEngName().get(position));
            holder.movieType.setText(movieModel.getMovieType().get(position));
            holder.movieTag.setText(movieModel.getMovieTag().get(position));

        } catch (Exception e) {
        }

        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getAdapterPosition();
                new AlertDialog.Builder(v.getContext()).setTitle(movieModel.getMovieName().get(position)).setMessage(movieModel.getMovieAbout().get(position)).show();
                return false;
            }
        });


    }

    public int getPosition() {
        return new ViewHolder(view).getAdapterPosition();
    }

    @Override
    public int getItemCount() {
        return movieModel.movieNameList.size();
    }
}
