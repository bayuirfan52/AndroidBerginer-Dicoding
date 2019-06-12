package com.bayuirfan.submission.features;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bayuirfan.submission.R;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private TextView txtTitle, txtGenre, txtType, txtEpisodes, txtStatus, txtScore, txtSynopsis;
    private ImageView imgDetail;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupComponent();
        getValueComponentExtra();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }

    private void setupComponent(){
        imgDetail = findViewById(R.id.img_detail);
        txtTitle = findViewById(R.id.txt_detail_title);
        txtGenre = findViewById(R.id.txt_detail_genre);
        txtStatus = findViewById(R.id.txt_detail_status);
        txtType = findViewById(R.id.txt_detail_type);
        txtEpisodes = findViewById(R.id.txt_detail_episodes);
        txtScore = findViewById(R.id.txt_detail_score);
        txtSynopsis = findViewById(R.id.txt_detail_synopsis);
    }

    private void getValueComponentExtra(){
        Glide.with(this)
                .load(getIntent().getStringExtra("picture"))
                .into(imgDetail);
        txtTitle.setText(getIntent().getStringExtra("title"));
        txtGenre.setText(getIntent().getStringExtra("genre"));
        txtStatus.setText(getIntent().getStringExtra("status"));
        txtType.setText(getIntent().getStringExtra("type"));
        txtEpisodes.setText(getIntent().getStringExtra("episodes"));
        txtScore.setText(getIntent().getStringExtra("score"));
        txtSynopsis.setText(getIntent().getStringExtra("synopsis"));
    }
}
