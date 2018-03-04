package com.example.abhishekkoranne.engineersbook.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abhishekkoranne.engineersbook.R;
import com.example.abhishekkoranne.engineersbook.Adapter.ArticlesAdapter;
import com.example.abhishekkoranne.engineersbook.model.Article;
import com.example.abhishekkoranne.engineersbook.model.Comment;
import com.example.abhishekkoranne.engineersbook.model.User;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArticlesFragment extends Fragment {
    RecyclerView rv_article;
    /*String[] user_name;
    String[] time_stamp;
    String[] text_post;
    String[] no_of_comments;
    String[] no_of_shares;
    int[] images={R.drawable.img,R.drawable.jiggy};*/

    ArrayList<Article> articleList = new ArrayList<>();
    ArrayList<String> comment = new ArrayList<>();


    public ArticlesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_articles, container, false);

        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rv_article = (RecyclerView) getActivity().findViewById(R.id.rv_article);

     /*   user_name=getResources().getStringArray(R.array.user_name);
        time_stamp=getResources().getStringArray(R.array.time_stamp);
        text_post=getResources().getStringArray(R.array.text_post);
        no_of_comments=getResources().getStringArray(R.array.no_of_comments);
        no_of_shares= getResources().getStringArray(R.array.no_of_shares);

        ArticlesAdapter adapt=new ArticlesAdapter(this,images,user_name,time_stamp,text_post,no_of_comments,no_of_shares);

        rv_article.setAdapter(adapt);
        rv_article.setLayoutManager(new LinearLayoutManager(this.getActivity()));*/

        rv_article = (RecyclerView) getActivity().findViewById(R.id.rv_article);

        User user1 = new User(1, "xx@xx.com", "abc@gmail.com", "Abhi", "Koranne", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");
        User user2 = new User(2, "abc@gmail.com", "abc@gmail.com", "JIGGY", "VYAS", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");
        User user3 = new User(3, "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8", "abc@gmail.com", "Shabbi", "SRK", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");
        User user4 = new User(4, "ac@gmail.com", "abc@gmail.com", "GABRU", "JAVA", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");
        User user5 = new User(5, "bc@gmail.com", "abc@gmail.com", "NABDU", "Dot NET", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");


        articleList.add(new Article(5555, 1, "This is post1 who you are? Hope you are doing well! Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fpbs.twimg.com%2Fprofile_images%2F1811310904%2Flogo100x100_SM_twitter_400x400.jpg&imgrefurl=https%3A%2F%2Ftwitter.com%2Fsomos100x100&docid=ZK72S9aXTiELUM&tbnid=-1E2q0TplBkcCM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA..i&w=400&h=400&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA&iact=mrc&uact=8", 0, 0, 0, user1, new ArrayList<Comment>()));


        articleList.add(new Article(5000, 2, "This is post2...How are you? Good to see after long time" +
                "Good to see after long time" + "Good to see after long time\n" +
                "        Good to see after long time\n" +
                "        Good to see after long time\n" +
                "        Good to see after long time\n" +
                "        Good to see after long time\n" +
                "        Good to see after long time."
                , "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fpbs.twimg.com%2Fprofile_images%2F1811310904%2Flogo100x100_SM_twitter_400x400.jpg&imgrefurl=https%3A%2F%2Ftwitter.com%2Fsomos100x100&docid=ZK72S9aXTiELUM&tbnid=-1E2q0TplBkcCM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA..i&w=400&h=400&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA&iact=mrc&uact=8", 5, 6, 9, user2, new ArrayList<Comment>()));


        articleList.add(new Article(1000, 3, "This is post1 who you are? Hope you are doing well! Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fpbs.twimg.com%2Fprofile_images%2F1811310904%2Flogo100x100_SM_twitter_400x400.jpg&imgrefurl=https%3A%2F%2Ftwitter.com%2Fsomos100x100&docid=ZK72S9aXTiELUM&tbnid=-1E2q0TplBkcCM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA..i&w=400&h=400&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA&iact=mrc&uact=8", 2, 10, 20, user3, new ArrayList<Comment>()));


        articleList.add(new Article(5555, 4, "This is post1 who you are? Hope you are doing well! Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fpbs.twimg.com%2Fprofile_images%2F1811310904%2Flogo100x100_SM_twitter_400x400.jpg&imgrefurl=https%3A%2F%2Ftwitter.com%2Fsomos100x100&docid=ZK72S9aXTiELUM&tbnid=-1E2q0TplBkcCM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA..i&w=400&h=400&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA&iact=mrc&uact=8", 3, 30, 40, user4, new ArrayList<Comment>()));


        articleList.add(new Article(2000, 5, "This is post1 who you are? Hope you are doing well! Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!" +
                "Hope you are doing well!", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fpbs.twimg.com%2Fprofile_images%2F1811310904%2Flogo100x100_SM_twitter_400x400.jpg&imgrefurl=https%3A%2F%2Ftwitter.com%2Fsomos100x100&docid=ZK72S9aXTiELUM&tbnid=-1E2q0TplBkcCM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA..i&w=400&h=400&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwg-KAAwAA&iact=mrc&uact=8", 10, 20, 30, user5, new ArrayList<Comment>()));

        ArticlesAdapter adapt = new ArticlesAdapter(getActivity(), articleList);
        rv_article.setAdapter(adapt);
        rv_article.setLayoutManager(new LinearLayoutManager(this.getActivity()));


    }


}
