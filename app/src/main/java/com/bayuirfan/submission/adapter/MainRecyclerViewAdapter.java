package com.bayuirfan.submission.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bayuirfan.submission.R;
import com.bayuirfan.submission.data.Series;
import com.bayuirfan.submission.features.DetailActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder> {

    private Context context;
    private ArrayList<Series> list;

    public MainRecyclerViewAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_layout, viewGroup, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        final Series series = getList().get(i);

        Glide.with(context)
                .load(series.getPicture())
                .into(mainViewHolder.imgList);

        mainViewHolder.txtTitle.setText(series.getName());
        mainViewHolder.txtGenre.setText(series.getGenre());
        mainViewHolder.txtType.setText(series.getType());
        mainViewHolder.txtScore.setText(series.getScore());

        mainViewHolder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("title",series.getName());
                intent.putExtra("picture",series.getPicture());
                intent.putExtra("genre",series.getGenre());
                intent.putExtra("type",series.getType());
                intent.putExtra("score",series.getScore());
                intent.putExtra("status",series.getStatus());
                intent.putExtra("synopsis",series.getSynopsis());
                intent.putExtra("episodes",series.getEpisodes());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    private ArrayList<Series> getList() {
        return list;
    }

    public void setList(ArrayList<Series> list) {
        this.list = list;
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
        ImageView imgList;
        Button btnDetail;
        TextView txtTitle, txtGenre, txtType, txtScore;
        MainViewHolder(@NonNull View itemView) {
            super(itemView);
            imgList = itemView.findViewById(R.id.img_list_item);
            txtTitle = itemView.findViewById(R.id.txt_list_title);
            txtGenre = itemView.findViewById(R.id.txt_list_genre);
            txtType = itemView.findViewById(R.id.txt_list_type);
            txtScore = itemView.findViewById(R.id.txt_list_score);
            btnDetail = itemView.findViewById(R.id.btn_detail);
        }
    }
}
