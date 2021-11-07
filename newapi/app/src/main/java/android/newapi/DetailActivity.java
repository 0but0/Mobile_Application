package android.newapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.newapi.Utils.utlis;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class DetailActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{
    private ImageView imageView;
    private TextView Navibartitle, Navibarsubtitle, date, time, title;
    private String Urldetail, imgdetail, Titledetail, Datedetail, Sourcedetail, Authordetail;
    private FrameLayout NavibarBehavior;
    private LinearLayout titleNavibar;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private boolean HideToolbarView = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final CollapsingToolbarLayout cotola = findViewById(R.id.collapsing_toolbar);
        cotola.setTitle("");

        appBarLayout = findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(this);
        titleNavibar = findViewById(R.id.titleappbar);
        NavibarBehavior = findViewById(R.id.navibarBehavior);
        imageView = findViewById(R.id.backlayout);
        Navibartitle = findViewById(R.id.navibartitle);
        Navibarsubtitle = findViewById(R.id.navibarsubtitle);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        title = findViewById(R.id.title);

        Intent intent = getIntent();
        Urldetail = intent.getStringExtra("url");
        Titledetail = intent.getStringExtra("title");
        imgdetail = intent.getStringExtra("imageView");
        Authordetail = intent.getStringExtra("author");
        Datedetail = intent.getStringExtra("date");
        Sourcedetail = intent.getStringExtra("source");

        SupportTranFormat();
        Weblaydetail(Urldetail);

    }
    private void SupportTranFormat()
    {
        String author;
        RequestOptions rq = new RequestOptions();
        rq.error(utlis.getRandomdrawbleColor());

        Glide.with(this).load(imgdetail).apply(rq).transition(DrawableTransitionOptions.withCrossFade()).into(imageView);

        Navibarsubtitle.setText(Urldetail);
        Navibartitle.setText(Sourcedetail);
        date.setText(utlis.DateFormat(Datedetail));
        title.setText(Titledetail);
        if (Authordetail != null){
            author = " \u2022 " + Authordetail;
        } else {
            author = "";
        }
        time.setText(Sourcedetail + author + " \u2022 " + utlis.DateFormat(Datedetail));
    }

    private void Weblaydetail(String url){
        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int ScrollView = appBarLayout.getTotalScrollRange();
        float per = (float) Math.abs(verticalOffset) / (float) ScrollView;

        if (per == 1f && HideToolbarView) {
            NavibarBehavior.setVisibility(View.GONE);
            titleNavibar.setVisibility(View.VISIBLE);
            HideToolbarView = !HideToolbarView;

        } else if (per < 1f && !HideToolbarView) {
            NavibarBehavior.setVisibility(View.VISIBLE);
            titleNavibar.setVisibility(View.GONE);
            HideToolbarView = !HideToolbarView;
        }

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}