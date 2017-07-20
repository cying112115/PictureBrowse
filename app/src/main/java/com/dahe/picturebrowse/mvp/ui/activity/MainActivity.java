package com.dahe.picturebrowse.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dahe.picturebrowse.R;
import com.dahe.picturebrowse.mvp.ui.base.BaseActivity;
import com.dahe.picturebrowse.widget.textview.StrokeTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    private final String path = "http://img4.imgtn.bdimg.com/it/u=659323563,2437967239&fm=23&gp=0.jpg";
    private final String path1 = "http://img4.imgtn.bdimg.com/it/u=2499298600,1622021988&fm=23&gp=0.jpg";
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.imageView1)
    ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.imageView, R.id.imageView1})
    void onClick() {
        Intent intent = new Intent(this, PicturePreviewActivity.class);
        startActivity(intent);
        MainActivity.this.overridePendingTransition(R.anim.toast_enter, 0);
    }

    @Override
    public void initInjector() {

    }

    @Override
    protected void initViewsAndEvents() {
        StrokeTextView strokeTextView = (StrokeTextView) findViewById(R.id.test_stroketextview);
//        strokeTextView.setText("hi大搜房hi哦");
//        TextView textView1 = (TextView) findViewById(R.id.textttt);
//
//        SpannableStringBuilder builder = new SpannableStringBuilder(textView1.getText().toString());
//
//        //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色
//        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.RED);
//        ForegroundColorSpan whiteSpan = new ForegroundColorSpan(Color.WHITE);
//        ForegroundColorSpan blueSpan = new ForegroundColorSpan(Color.BLUE);
//        ForegroundColorSpan greenSpan = new ForegroundColorSpan(Color.GREEN);
//        ForegroundColorSpan yellowSpan = new ForegroundColorSpan(Color.YELLOW);
//
//        builder.setSpan(redSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        builder.setSpan(whiteSpan, 1, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
//        builder.setSpan(blueSpan, 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        builder.setSpan(greenSpan, 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        builder.setSpan(yellowSpan, 4,5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        textView1.setText(builder);

        Glide.with(mContext)
                .load(path)
                //.fitCenter()
                // .placeholder(R.drawable.icon_audio)//占位图片
                //.error(R.drawable.icon_audio) //load失败时加载的图片
                .thumbnail(0.1f)  //用原图的1/10作为缩略图
                .crossFade(500) //淡出时间
                .into(imageView);
        Glide.with(mContext)
                .load(path1)
                //.fitCenter()
                // .placeholder(R.drawable.icon_audio)//占位图片
                //.error(R.drawable.icon_audio) //load失败时加载的图片
                .thumbnail(0.1f)  //用原图的1/10作为缩略图
                .crossFade(500) //淡出时间
                .into(imageView1);
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }
}
