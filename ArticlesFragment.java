package com.example.abhishekkoranne.engineersbook.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abhishekkoranne.engineersbook.ArticlesAdapter;
import com.example.abhishekkoranne.engineersbook.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends Fragment {
    RecyclerView rv_article;
    String[] user_name;
    String[] time_stamp;
    String[] text_post;
    String[] no_of_comments;
    String[] no_of_shares;
    int[] images={R.drawable.img,R.drawable.scene1};


    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.fragment_articles, container, false);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rv_article= (RecyclerView) getActivity().findViewById(R.id.rv_article);

        user_name=getResources().getStringArray(R.array.user_name);
        time_stamp=getResources().getStringArray(R.array.time_stamp);
        text_post=getResources().getStringArray(R.array.text_post);
        no_of_comments=getResources().getStringArray(R.array.no_of_comments);
        no_of_shares= getResources().getStringArray(R.array.no_of_shares);

        ArticlesAdapter adapt=new ArticlesAdapter(this,images,user_name,time_stamp,text_post,no_of_comments,no_of_shares);

        rv_article.setAdapter(adapt);
        rv_article.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    }


}
