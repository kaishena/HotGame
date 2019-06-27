package com.example.hotgame.activity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.downloader.Error;
import com.downloader.OnCancelListener;
import com.downloader.OnDownloadListener;
import com.downloader.OnPauseListener;
import com.downloader.OnProgressListener;
import com.downloader.OnStartOrResumeListener;
import com.downloader.PRDownloader;
import com.downloader.Progress;
import com.downloader.Status;
import com.example.hotgame.R;
import com.example.hotgame.utils.DownloadUtils;

public class DownloadActivity extends BaseActivity{

    private static String dirPath;
    private Button btn_cancel,btn;
    private ProgressBar progressBar;
    private TextView tv_progress;
    int downloadId;
    private String downloadUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        dirPath = DownloadUtils.getRootDirPath(getApplicationContext());


        initView();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        downloadUrl = bundle.getString("downloadUrl");

        onClickListener();

    }
    private void initView(){
        initNavBar(true,"下载中心",false);
        btn=findViewById(R.id.button);
        btn_cancel=findViewById(R.id.buttonCancel);
        tv_progress=findViewById(R.id.textViewProgress);
        progressBar=findViewById(R.id.progressBar);








    }
    public void onClickListener() {
        btn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                if (Status.RUNNING == PRDownloader.getStatus(downloadId)) {
                    PRDownloader.pause(downloadId);
                    return;
                }

                btn.setEnabled(false);
                progressBar.setIndeterminate(true);
                progressBar.getIndeterminateDrawable().setColorFilter(
                        Color.BLUE, android.graphics.PorterDuff.Mode.SRC_IN);

                if (Status.PAUSED == PRDownloader.getStatus(downloadId)) {
                    PRDownloader.resume(downloadId);
                    return;
                }
                downloadId= PRDownloader.download(downloadUrl, dirPath, "wandoujia.apk")
                        .build()
                        .setOnStartOrResumeListener(new OnStartOrResumeListener() {
                            @Override
                            public void onStartOrResume() {
                                progressBar.setIndeterminate(false);
                                btn.setEnabled(true);
                                btn.setText("暂 停");
                                btn_cancel.setEnabled(true);
                                btn_cancel.setText("取 消");
                            }
                        })
                        .setOnPauseListener(new OnPauseListener() {
                            @Override
                            public void onPause() {
                                btn.setText("继 续");
                            }
                        })
                        .setOnCancelListener(new OnCancelListener() {
                            @Override
                            public void onCancel() {
                                downloadId = 0;
                                btn.setText("开 始");
                                btn_cancel.setEnabled(false);
                                progressBar.setProgress(0);
                                tv_progress.setText("");
                                progressBar.setIndeterminate(false);
                            }
                        })
                        .setOnProgressListener(new OnProgressListener() {
                            @Override
                            public void onProgress(Progress progress) {
                                long progressPercent = progress.currentBytes * 100 / progress.totalBytes;
                                progressBar.setProgress((int) progressPercent);
                                tv_progress.setText(DownloadUtils.getProgressDisplayLine(progress.currentBytes, progress.totalBytes));

                            }
                        })
                        .start(new OnDownloadListener() {
                            @Override
                            public void onDownloadComplete() {
                                btn.setEnabled(false);
                                btn_cancel.setEnabled(false);
                                btn.setText("完 成");
                            }



                            @Override
                            public void onError(Error error) {
                                btn.setText("开 始");
                                Toast.makeText(getApplicationContext(), "some errors" , Toast.LENGTH_SHORT).show();
                                tv_progress.setText("");
                                progressBar.setProgress(0);
                                downloadId = 0;
                                btn_cancel.setEnabled(false);
                                progressBar.setIndeterminate(false);
                                btn.setEnabled(true);
                            }
                        });
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PRDownloader.cancel(downloadId);
            }
        });
    }

}
