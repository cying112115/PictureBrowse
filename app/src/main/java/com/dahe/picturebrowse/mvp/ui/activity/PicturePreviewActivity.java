package com.dahe.picturebrowse.mvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.dahe.picturebrowse.R;
import com.dahe.picturebrowse.mvp.ui.fragment.PicturePreviewFragment;
import com.dahe.picturebrowse.widget.PreviewViewPager;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by cying on 2017/5/19.
 */
public class PicturePreviewActivity extends FragmentActivity {

    private ImageButton left_back;
    private TextView tv_title;
    private PreviewViewPager viewPager;
    private List<String> images = new ArrayList<>();
    private SimpleFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_preview);

        /**
         * 例子图片
         */
        images.add("http://img4.imgtn.bdimg.com/it/u=659323563,2437967239&fm=23&gp=0.jpg");
        images.add("http://img4.imgtn.bdimg.com/it/u=2499298600,1622021988&fm=23&gp=0.jpg");
        images.add("http://img0.imgtn.bdimg.com/it/u=3187801856,2663441372&fm=23&gp=0.jpg");
        images.add("http://img1.imgtn.bdimg.com/it/u=2056417444,2718815107&fm=23&gp=0.jpg");

        tv_title = (TextView) findViewById(R.id.picture_title);
        left_back = (ImageButton) findViewById(R.id.left_back);
        viewPager = (PreviewViewPager) findViewById(R.id.preview_pager);
        left_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initViewPageAdapterData();
    }

    private void initViewPageAdapterData() {
        tv_title.setText(1 + "/" + images.size());
        adapter = new SimpleFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_title.setText(position + 1 + "/" + images.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public class SimpleFragmentAdapter extends FragmentPagerAdapter {

        public SimpleFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            PicturePreviewFragment fragment = PicturePreviewFragment.getInstance(images.get(position));
            return fragment;
        }

        @Override
        public int getCount() {
            return images.size();
        }
    }
}
