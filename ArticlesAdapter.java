package com.example.abhishekkoranne.engineersbook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abhishekkoranne.engineersbook.Fragment.ArticlesFragment;

/**
 * Created by Jiggy on 26-11-2017.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {
    Context cont;
    String[] user_name;
    String[] time_stamp;
    String[] text_post;
    String[] no_of_comments;
    String[] no_of_shares;
    int[] images;

    public ArticlesAdapter(ArticlesFragment articlesFragment, int[] images, String[] user_name, String[] time_stamp, String[] text_data, String[] no_of_comments, String[] no_of_shares) {
        cont = articlesFragment.getActivity();
        this.images = images;
        this.user_name = user_name;
        this.time_stamp = time_stamp;
        this.no_of_comments = no_of_comments;
        this.no_of_shares = no_of_shares;
        this.text_post = text_data;
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(cont);
        View myView = myInflater.inflate(R.layout.articles_item, parent, false);
        return new ArticlesViewHolder(myView);
    }
    @Override
    public void onBindViewHolder(ArticlesViewHolder holder, int position) {
        holder.profile_pic.setImageResource(images[position]);
        holder.image_post.setImageResource(images[position]);
        holder.user_name.setText(user_name[position]);
        holder.timestamp.setText(time_stamp[position]);
        holder.text_post.setText(text_post[position]);
        holder.no_of_comments.setText(no_of_comments[position]);
        holder.no_of_shares.setText(no_of_shares[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ArticlesViewHolder extends RecyclerView.ViewHolder {
        ImageView profile_pic, image_post;
        TextView user_name, timestamp, text_post, no_of_comments, no_of_shares;

        public ArticlesViewHolder(View itemView) {
            super(itemView);
            user_name = (TextView) itemView.findViewById(R.id.user_name);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);
            profile_pic = (ImageView) itemView.findViewById(R.id.profile_pic);
            image_post = (ImageView) itemView.findViewById(R.id.image_post);
            text_post = (TextView) itemView.findViewById(R.id.text_post);
            no_of_comments = (TextView) itemView.findViewById(R.id.no_of_comments);
            no_of_shares = (TextView) itemView.findViewById(R.id.no_of_shares);
        }
    }
}