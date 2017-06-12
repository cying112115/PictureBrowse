package com.dahe.picturebrowse.mvp.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dahe.picturebrowse.R;
import com.dahe.picturebrowse.constants.Constants;
import com.dahe.picturebrowse.mvp.ui.activity.PicturePreviewActivity;
import com.dahe.picturebrowse.utils.FileUtils;
import com.dahe.picturebrowse.utils.ScreenUtils;
import com.dahe.picturebrowse.utils.Utils;
import com.dahe.picturebrowse.widget.CustomDialog;
import com.dahe.picturebrowse.widget.dialog.SweetAlertDialog;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class PicturePreviewFragment extends Fragment {
    public static final String PATH = "path";
    private SweetAlertDialog dialog;
    private loadDataThread loadDataThread;
    private String directory_path;

    public static PicturePreviewFragment getInstance(String path) {
        PicturePreviewFragment fragment = new PicturePreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PATH, path);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_picture_preview, container, false);
        final PhotoView imageView = (PhotoView) contentView.findViewById(R.id.preview_image);
        final PhotoViewAttacher mAttacher = new PhotoViewAttacher(imageView);

        final String path = getArguments().getString(PATH);
        showPleaseDialog("请稍候...");
        Glide.with(container.getContext())
                .load(path)
                //.fitCenter()
                // .placeholder(R.drawable.icon_audio)//占位图片
                //.error(R.drawable.icon_audio) //load失败时加载的图片
                .thumbnail(0.1f)  //用原图的1/10作为缩略图
                .crossFade(500) //淡出时间
                //                    .transform(new BlurTransformation(context))
                .into(imageView);
        dismiss();

        mAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                if (getActivity() instanceof PicturePreviewActivity) {
                    activityFinish();
                } else {
                    getActivity().finish();
                    getActivity().overridePendingTransition(0, R.anim.toast_out);
                }
            }
        });
        mAttacher.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // 内部预览不保存
                if (hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    showDownLoadDialog(path);
                } else {
                    requestPermission(Constants.WRITE_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }

                return true;
            }
        });
        return contentView;
    }


    protected void activityFinish() {
        getActivity().finish();
        getActivity().overridePendingTransition(0, R.anim.toast_out);
    }

    /**
     * 下载图片提示
     */
    private void showDownLoadDialog(final String path) {
        final CustomDialog dialog = new CustomDialog(getContext(), ScreenUtils.getScreenWidth(getContext()) * 3 / 4,
                ScreenUtils.getScreenHeight(getContext()) / 4, R.layout.wind_base_dialog_xml, R.style.Theme_dialog);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        Button btn_commit = (Button) dialog.findViewById(R.id.btn_commit);
        TextView tv_title = (TextView) dialog.findViewById(R.id.tv_title);
        TextView tv_content = (TextView) dialog.findViewById(R.id.tv_content);
        tv_title.setText("提示");
        tv_content.setText("是否保存图片？");
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPleaseDialog("请稍候...");
                if (!Utils.isNull(path)) {
                    if (path.startsWith("http") || path.startsWith("https")) {
                        loadDataThread = new loadDataThread(path);
                        loadDataThread.start();
                    } else {
                        //  如果是浏览本地存储的图片的情况
                        String dirPath = createDir(System.currentTimeMillis() + ".png");
                        try {
                            FileUtils.copyFile(path, dirPath);
                            Toast.makeText(getActivity(), "图片保存成功至\n" + dirPath, Toast.LENGTH_SHORT).show();
                            dismiss();
                        } catch (IOException e) {
                            Toast.makeText(getActivity(), "图片保存失败\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            dismiss();
                            e.printStackTrace();
                        }
                    }
                }
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    // 进度条线程
    public class loadDataThread extends Thread {
        private String path;

        public loadDataThread(String path) {
            super();
            this.path = path;
        }

        public void run() {
            try {
                showLoadingImage(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 下载图片保存至手机
    public void showLoadingImage(String urlPath) {
        try {
            URL u = new URL(urlPath);
            String path = createDir(System.currentTimeMillis() + ".png");
            byte[] buffer = new byte[1024 * 8];
            int read;
            int ava = 0;
            long start = System.currentTimeMillis();
            BufferedInputStream bin;
            HttpURLConnection urlConn = (HttpURLConnection) u.openConnection();
            double fileLength = (double) urlConn.getContentLength();
            bin = new BufferedInputStream(u.openStream());
            BufferedOutputStream bout = new BufferedOutputStream(
                    new FileOutputStream(path));
            while ((read = bin.read(buffer)) > -1) {
                bout.write(buffer, 0, read);
                ava += read;
                int a = (int) Math.floor((ava / fileLength * 100));
                long speed = ava / (System.currentTimeMillis() - start);
                System.out.println("Download: " + ava + " byte(s)"
                        + "    avg speed: " + speed + "  (kb/s)");
            }
            bout.flush();
            bout.close();
            Message message = handler.obtainMessage();
            message.what = 200;
            message.obj = path;
            handler.sendMessage(message);
        } catch (IOException e) {
            Toast.makeText(getActivity(), "图片保存失败\n" + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    /**
     * 创建文件夹
     *
     * @param filename
     * @return
     */
    private String createDir(String filename) {
        String state = Environment.getExternalStorageState();
        File rootDir = state.equals(Environment.MEDIA_MOUNTED) ? Environment.getExternalStorageDirectory() : getActivity().getCacheDir();
        File path = new File(rootDir.getAbsolutePath() + "/PictureBrowse");
        if (!path.exists())
            // 若不存在，创建目录，可以在应用启动的时候创建
            path.mkdirs();

        return path + "/" + filename;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 200:
                    String path = (String) msg.obj;
                    // 通知图库更新
                    getActivity().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));
                    Toast.makeText(getActivity(), "保存成功", Toast.LENGTH_SHORT).show();
                    dismiss();
                    break;
            }
        }
    };


    /**
     * 提示框
     *
     * @param msg
     */
    private void showPleaseDialog(String msg) {
        if (!getActivity().isFinishing()) {
            dialog = new SweetAlertDialog(getActivity());
            dialog.setTitleText(msg);
            dialog.show();
        }
    }

    /**
     * 关闭提示框
     */
    private void dismiss() {
        if (dialog != null && dialog.isShowing()) {
            dialog.cancel();
        }
    }

    /**
     * 针对6.0动态请求权限问题
     * 判断是否允许此权限
     *
     * @param permissions
     * @return
     */
    protected boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(getActivity(), permission)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态请求权限
     *
     * @param code
     * @param permissions
     */
    protected void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(getActivity(), permissions, code);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Constants.WRITE_EXTERNAL_STORAGE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(getContext(), "读取内存卡权限已被拒绝", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (loadDataThread != null) {
            handler.removeCallbacks(loadDataThread);
            loadDataThread = null;
        }
    }
}
