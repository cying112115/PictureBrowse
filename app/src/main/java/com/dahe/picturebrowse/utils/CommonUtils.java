package com.dahe.picturebrowse.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dahe.picturebrowse.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by xk on 2017/4/13.
 */

public class CommonUtils {

    public static int ERROR = 0;
    public static int SUCCESS = 1;


    public static String getDeviceId(Context context){
        TelephonyManager telePhonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return telePhonyManager.getDeviceId();
    }


    /**
     * @param context
     * @param resId
     */
    public static void customToast(Context context, int resId , int flag){

        View layout = LayoutInflater.from(context).inflate(R.layout.cn_custom_toast_layout, null);
        ImageView imageView = (ImageView) layout.findViewById(R.id.spinnerImageView);
        TextView toastText = (TextView) layout.findViewById(R.id.message);
        Toast toast = new Toast(context);
        String message = context.getResources().getString(resId);
        toastText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
        toastText.setText(message);
        if(ERROR == flag){
            imageView.setImageResource(R.mipmap.wrong);
        }else if(SUCCESS == flag){
            imageView.setImageResource(R.mipmap.right);
        }

        toast.setGravity(Gravity.CENTER , 0, 0);//CENTER
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    /**
     *
     * @param context
     * @param msg
     */
    public static void customToast(Context context, String msg , int flag){

        View layout = LayoutInflater.from(context).inflate(R.layout.cn_custom_toast_layout, null);

        ImageView imageView = (ImageView) layout.findViewById(R.id.spinnerImageView);
        TextView toastText = (TextView) layout.findViewById(R.id.message);

        Toast toast = new Toast(context);
        toastText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
        toastText.setText(msg);
        if(ERROR == flag){
            imageView.setImageResource(R.mipmap.wrong);
        }else if(SUCCESS == flag){
            imageView.setImageResource(R.mipmap.right);
        }
        toast.setGravity(Gravity.CENTER , 0, 0);//CENTER
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    private static long dayMillisecond = 24*60*60*1000;

    /**
     * Description：<code> 处理过去时间显示效果 </code>
     * @param createAt
     *            Data 类型
     * @return { String }
     */
    public static String getInterval(Date createAt) {
        //定义最终返回的结果字符串。
        String interval = null;

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Calendar old = Calendar.getInstance();
        old.setTime(createAt);
        //当天
        if(now.get(Calendar.YEAR)==old.get(Calendar.YEAR)
                &&now.get(Calendar.MONTH)==old.get(Calendar.MONTH)
                &&now.get(Calendar.DAY_OF_MONTH)==old.get(Calendar.DAY_OF_MONTH)){
            long millisecond = new Date().getTime() - createAt.getTime();
            long second = millisecond / 1000;
            if (second <= 0) {
                second = 0;
            }
            if (second == 0) {
                interval = "刚刚";
            } else if (second < 30) {
                interval = second + "秒以前";
            } else if (second >= 30 && second < 60) {
                interval = "半分钟前";
            } else if (second >= 60 && second < 60 * 60) {
                long minute = second / 60;
                interval = minute + "分钟前";
            } else if (second >= 60 * 60 && second < 60 * 60 * 24) {
                long hour = (second / 60) / 60;
                interval = hour + "小时前";
            }
            return interval;
        }
        long millisecond = new Date().getTime() - createAt.getTime();
        if(millisecond<7*dayMillisecond){//七天内
            long day = millisecond/dayMillisecond;
            if(day == 1||day==0){
                interval = "昨天 "+(new SimpleDateFormat("HH:mm").format(createAt));
            }else if(day == 2){
                interval = "前天";
            }else if(day < 7){
                interval = day + "天前";
            }else if(day==0){
                interval = "昨天";
            }
            return interval;
        }else{//七天以上
            String publishYear = new SimpleDateFormat("yyyy").format(createAt);
            String nowYear = new SimpleDateFormat("yyyy").format(new Date());

            if(publishYear.substring(0, 4).equals(nowYear)){
                return new SimpleDateFormat("MM-dd HH:mm").format(createAt);
            }else{
                return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(createAt);
            }
        }
    }

    public static final View.OnTouchListener TouchDark = new View.OnTouchListener()
    {

        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
            if (event.getAction() == MotionEvent.ACTION_DOWN)
            {
                v.setAlpha(0.7f);
            }
            else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL)
            {
                v.setAlpha(1.0f);
            }
            return false;
        }
    };


    public static int getScreenWith(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private static int calculateTabWidth(TabLayout tabLayout) {
        int tabWidth = 0;
        for (int i = 0; i < tabLayout.getChildCount(); i++) {
            final View view = tabLayout.getChildAt(i);
            view.measure(0, 0); // 通知父view测量，以便于能够保证获取到宽高
            tabWidth += view.getMeasuredWidth();
        }
        return tabWidth;
    }

    public static void dynamicSetTabLayoutMode(TabLayout tabLayout, Context context) {
        int tabWidth = calculateTabWidth(tabLayout);
        int screenWidth = getScreenWith(context);

        if (tabWidth <= screenWidth) {
            tabLayout.setTabMode(TabLayout.MODE_FIXED);
        } else {
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }
    }

    /***
     *   过滤 HTML 标签
     *
     *
     * @param htmlStr
     * @return
     */
    public static String delHTMLTag(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }



}
