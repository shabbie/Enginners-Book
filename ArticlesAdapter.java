package com.example.abhishekkoranne.engineersbook;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abhishekkoranne.engineersbook.Fragment.ArticlesFragment;
import com.example.abhishekkoranne.engineersbook.model.Article;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jiggy on 26-11-2017.
 */

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder> {
    Context cont;
    ArrayList<Article> articleList=new ArrayList<>();
    DisplayImageOptions options;
    ImageLoader imgloader=ImageLoader.getInstance();

    public ArticlesAdapter(Context cont, ArrayList<Article> art) {
        this.cont = cont;
        this.articleList = art;
        options= new DisplayImageOptions.Builder().build();
    }

    @Override
    public ArticlesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(cont);
        View myView = myInflater.inflate(R.layout.articles_item, parent, false);
        return new ArticlesViewHolder(myView);
    }
    @Override
    public void onBindViewHolder(ArticlesViewHolder holder, int position) {
        String userName=articleList.get(position).getUser().getFirstName().toString()+" "+articleList.get(position).getUser().getLastName().toString();
        /*Date date=new Date(articleList.get(position).getTime());
        SimpleDateFormat dateFormat=new SimpleDateFormat();*/

        Date date = new Date(articleList.get(position).getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate= formatter.format(date);


        imgloader.displayImage("https://goo.gl/images/4BDHri", holder.profile_pic, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

        imgloader.displayImage("https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fpbs.twimg.com%2Fprofile_images%2F1811310904%2Flogo100x100_SM_twitter_400x400.jpg&imgrefurl=https%3A%2F%2Ftwitter.com%2Fsomos100x100&docid=ZK72S9aXTiELUM&tbnid=-1E2q0TplBkcCM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA..i&w=400&h=400&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA&iact=mrc&uact=8", holder.image_post, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
//        holder.image_post.setImageResource(images[position]);
        holder.user_name.setText(userName);
        holder.timestamp.setText(strDate);
        holder.text_post.setText(""+articleList.get(position).getArticle_text_post());
        holder.no_of_comments.setText(""+articleList.get(position).getComments());
        holder.no_of_shares.setText(""+articleList.get(position).getShares());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
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