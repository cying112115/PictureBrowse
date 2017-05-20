package com.dahe.picturebrowse.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dahe.picturebrowse.R;
import com.dahe.picturebrowse.ui.base.BaseActivity;

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
