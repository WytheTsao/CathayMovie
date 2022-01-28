package com.example.cathaymovie;

import android.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private CardView cardView;
    private ArrayList<MovieModel> movieModelList;
    private View view;

    public RecycleViewAdapter(ArrayList<MovieModel> movieModelList) {
        this.movieModelList = movieModelList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView movieName, movieEngName, movieType, movieComeOutDay, movieRunTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            movieName = itemView.findViewById(R.id.movie_name);
            movieEngName = itemView.findViewById(R.id.movie_eng_name);
            movieType = itemView.findViewById(R.id.movie_type);
            movieComeOutDay = itemView.findViewById(R.id.movie_come_out_day);
            movieRunTime = itemView.findViewById(R.id.run_time);
        }
    }


    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.movieName.setText(movieModelList.get(position).getName());
        holder.movieEngName.setText(movieModelList.get(position).getEngName());
        holder.movieRunTime.setText(movieModelList.get(position).getRunTime());
        holder.movieComeOutDay.setText(movieModelList.get(position).getComeOutDate());
        holder.movieType.setText(movieModelList.get(position).getType());
        cardView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(v.getContext()).setTitle(movieModelList.get(position).getName()).setMessage(movieModelList.get(position).getAbout()).show();
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return movieModelList.size();
    }
}
