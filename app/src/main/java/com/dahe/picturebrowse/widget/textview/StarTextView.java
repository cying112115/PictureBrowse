package com.dahe.picturebrowse.widget.textview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;

import com.dahe.picturebrowse.mvp.ui.activity.MainActivity;

/**
 * Created by cying on 2017/6/3.
 */

public class StarTextView extends AppCompatTextView {
    public StarTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        String origin = getText().toString();
        /**
         * 带红色*号的标签
         */
        //if(origin.startsWith("*")){
        //            SpannableString str  = new SpannableString(origin);
        //            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        //            str.setSpan(foregroundColorSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //            setText(str);
        //    }
        /**
         * 设置字体的颜色
         */
        //        SpannableString spannableString = new SpannableString("她的名字叫欢欢");
        //        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        //        spannableString.setSpan(colorSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //        setText(spannableString);

        /**
         * 设置背景颜色
         */
        //        SpannableString spannableString = new SpannableString("她的名字叫欢欢");
        //        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#0099EE"));
        //        spannableString.setSpan(backgroundColorSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //        setText(spannableString);

        /**
         * 设置字体大小
         */
        //        SpannableString spannableString = new SpannableString("她的名字叫欢欢");
        //        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(2.0f);
        //        spannableString.setSpan(relativeSizeSpan, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //        setText(spannableString);

        /**
         * 设置删除线
         */
        //        SpannableString spannableString = new SpannableString("$588$788");
        //
        //        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        //        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(2.0f);
        //        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
        //
        //        spannableString.setSpan(strikethroughSpan, 4, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //        spannableString.setSpan(relativeSizeSpan, 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //        spannableString.setSpan(foregroundColorSpan, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //        setText(spannableString);


        /**
         * 设置下划线
         */
        //        SpannableString spannableString = new SpannableString("她的名字叫欢欢");
        //        UnderlineSpan underlineSpan = new UnderlineSpan();
        //        spannableString.setSpan(underlineSpan, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //        setText(spannableString);
        /**
         * 设置上下角标
         */
        //        SpannableString spannableString = new SpannableString("X2+Y2=Z2");
        //        SuperscriptSpan superscriptSpan = new SuperscriptSpan(); //上标
        //        SuperscriptSpan superscriptSpan1 = new SuperscriptSpan(); //上标
        //        spannableString.setSpan(superscriptSpan, 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //        spannableString.setSpan(superscriptSpan1, 4, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //
        //        SubscriptSpan subscriptSpan = new SubscriptSpan(); //下标
        //        spannableString.setSpan(subscriptSpan, 7, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //
        //        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.5f);
        //        RelativeSizeSpan relativeSizeSpan1 = new RelativeSizeSpan(0.5f);
        //        RelativeSizeSpan relativeSizeSpan2 = new RelativeSizeSpan(0.5f);
        //        spannableString.setSpan(relativeSizeSpan, 1, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //        spannableString.setSpan(relativeSizeSpan1, 4, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //        spannableString.setSpan(relativeSizeSpan2, 7, 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //
        //        setText(spannableString);

        /**
         * 给文字设置粗体和斜体
         */
        //        SpannableString spannableString = new SpannableString("她的名字叫欢欢");
        //        StyleSpan styleSpan_B  = new StyleSpan(Typeface.BOLD);
        //        StyleSpan styleSpan_I  = new StyleSpan(Typeface.ITALIC);
        //        spannableString.setSpan(styleSpan_B, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //        spannableString.setSpan(styleSpan_I, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //        setHighlightColor(Color.parseColor("#36969696"));
        //        setText(spannableString);
        /**
         * 在文本中插入图片
         */
        //        SpannableString spannableString = new SpannableString("在文本中添加图片（图）");
        //        Drawable drawable = getResources().getDrawable(R.mipmap.img_up_img);
        //        drawable.setBounds(0, 0, 80, 80);
        //        ImageSpan imageSpan = new ImageSpan(drawable);
        //        spannableString.setSpan(imageSpan, 6, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //        setText(spannableString);

        /**
         * 文本点击事件
         */
//        SpannableString spannableString = new SpannableString("她的名字叫欢欢");
//        MyClickableSpan relativeSizeSpan = new MyClickableSpan();
//        spannableString.setSpan(relativeSizeSpan, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//
//        setMovementMethod(LinkMovementMethod.getInstance());
//        setHighlightColor(Color.parseColor("#0099EE"));
//        setText(spannableString);

        /**
         * 设置超链接
         */
        SpannableString spannableString = new SpannableString("不知道的话百度一下");
        URLSpan urlSpan = new URLSpan("http://www.baidu.com");
        spannableString.setSpan(urlSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(Color.parseColor("#36969696"));
        setText(spannableString);
    }

   class MyClickableSpan extends ClickableSpan{

       @Override
       public void updateDrawState(TextPaint ds) {
           super.updateDrawState(ds);
           ds.setUnderlineText(false);
       }

       @Override
       public void onClick(View widget) {
           Intent intent = new Intent(getContext(), MainActivity.class);
           getContext().startActivity(intent);
       }
   }
}
