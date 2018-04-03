package com.example.abhishekkoranne.engineersbook.Activity;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.abhishekkoranne.engineersbook.R;
import com.example.abhishekkoranne.engineersbook.Adapter.DoubtAnswerAdapter;
import com.example.abhishekkoranne.engineersbook.model.Answer;
import com.example.abhishekkoranne.engineersbook.model.Doubt;
import com.example.abhishekkoranne.engineersbook.model.User;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;

public class DoubtsQuestionActivity extends AppCompatActivity {
    ArrayList<Answer> answerList = new ArrayList<>();
    TextView no_of_upvotes, doubt_question, doubt_question_tag, doubt_question_detailed_form_text, no_of_answers;
    RecyclerView rv_doubt_question_answers;
    NestedScrollView sv_doubts_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doubts_question);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        no_of_upvotes = (TextView) findViewById(R.id.no_of_upvotes);
        doubt_question = (TextView) findViewById(R.id.doubt_question);
        doubt_question_tag = (TextView) findViewById(R.id.doubt_question_tag);
        doubt_question_detailed_form_text = (TextView) findViewById(R.id.doubt_question_detailed_form_text);
        no_of_answers = (TextView) findViewById(R.id.no_of_answers);
        sv_doubts_question = (NestedScrollView) findViewById(R.id.sv_doubts_question);

        rv_doubt_question_answers = (RecyclerView) findViewById(R.id.rv_doubt_question_answers);

        /*sv_doubts_question.fullScroll(ScrollView.FOCUS_UP);*/
        sv_doubts_question.smoothScrollTo(0, 0);

        /*Intent ii = getIntent();
        Bundle extras = ii.getExtras();
        String
        total_upvotes = extras.getString("no_of_upvotes");
        String doubt_quest = extras.getString("doubt_question");
        String doubt_quest_tag = extras.getString("doubt_question_tag");*/

        Intent ii = getIntent();
        Doubt doubt_object = (Doubt) ii.getParcelableExtra("doubt_object");
        String total_upvotes = "" + doubt_object.getUpVote();
        String doubt_quest = doubt_object.getDoubt();
        ArrayList<String> doubt_quest_tag_list = doubt_object.getDoubtTagsList();

        String doubt_quest_tag = "";
        for (int i = 0, n = doubt_quest_tag_list.size(); i < n; i++) {
            doubt_quest_tag += doubt_quest_tag_list.get(i);
        }

        no_of_upvotes.setText(total_upvotes);
        doubt_question.setText(doubt_quest);
        doubt_question_tag.setText(doubt_quest_tag);

        doubt_question_detailed_form_text.setText("Form error in php...session err...cookies error....Form error in php...session err...cookies errorForm error in php...session err...cookies errorForm error in php...session err...cookies errorForm error in php...session err...cookies errorForm error in php...session err...cookies error");

        User user1 = new User(1, "xx@xx.com", "abc@gmail.com", "Abhi", "Koranne", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");
        User user2 = new User(2, "abc@gmail.com", "abc@gmail.com", "JIGGY", "VYAS", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");
        User user3 = new User(3, "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8", "abc@gmail.com", "Shabbi", "SRK", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");
        User user4 = new User(4, "ac@gmail.com", "abc@gmail.com", "GABRU", "JAVA", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");
        User user5 = new User(5, "bc@gmail.com", "abc@gmail.com", "NABDU", "Dot NET", "https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fwww.internetvibes.net%2Fwp-content%2Fgallery%2Favatars%2F017.png&imgrefurl=https%3A%2F%2Fwww.internetvibes.net%2Fgallery%2Fnice-avatar-set-613-avatars-100x100%2F&docid=TOdPgfD5Tee_eM&tbnid=7fp-HioZO06DsM%3A&vet=10ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw..i&w=100&h=100&bih=653&biw=1517&q=images%20100x100&ved=0ahUKEwjRq9i2ybPYAhWMpY8KHffNBp0QMwhFKAcwBw&iact=mrc&uact=8");

        answerList.add(new Answer(5000, 1, 00, "This is comment 1", 13, 1, "This is answer 1", user1));
        answerList.add(new Answer(100000, 2, 01, "This is comment 2", 23, 2, "This is answer 2", user2));
        answerList.add(new Answer(2149813, 3, 02, "This is comment 3", 11, 3, "This is answer 3", user3));
        answerList.add(new Answer(324712, 4, 03, "This is comment 4", 44, 4, "This is answer 4", user4));
        answerList.add(new Answer(123124, 5, 04, "This is comment 5", 16, 5, "This is answer 5", user5));


        DoubtAnswerAdapter adapt = new DoubtAnswerAdapter(this, answerList);
        rv_doubt_question_answers.setAdapter(adapt);
        rv_doubt_question_answers.setLayoutManager(new LinearLayoutManager(this));

        no_of_answers.setText("" + answerList.size() + " Answers");
    }

    public void addAnswer(View view) {
        startActivity(new Intent(DoubtsQuestionActivity.this,AddAnswerActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //finish();

                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}
