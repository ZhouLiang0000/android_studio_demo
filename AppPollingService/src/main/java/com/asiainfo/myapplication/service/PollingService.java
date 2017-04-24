package com.asiainfo.myapplication.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.asiainfo.myapplication.R;
import com.asiainfo.myapplication.activity.MainActivity;

/**
 * Created by zhouliang on 2017/4/19.
 */

public class PollingService extends Service {
    public static final String ACTION = "com.ryantang.service.PollingService";
    private NotificationManager mManager;
    /* Notification构造器 */
    private NotificationCompat.Builder mBuilder;
    /* Notification的ID */
    private int notifyId = 1000;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        initNotifiManager();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Log.i("PollingService","---------------------"+"开启服务");
        new PollingThread().start();
    }

    //初始化通知栏配置
    private void initNotifiManager() {
        mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setContentTitle("定时Title"+String.valueOf(count))
                .setContentText("定时Context"+String.valueOf(count))
                .setContentIntent(getDefalutIntent(Notification.FLAG_AUTO_CANCEL))
//              .setNumber(number)//显示数量
                .setTicker("")//通知首次出现在通知栏，带上升动画效果的
                .setPriority(Notification.PRIORITY_DEFAULT)//设置该通知优先级
//              .setAutoCancel(true)//设置这个标志当用户单击面板就可以让通知将自动取消
                .setOngoing(false)//ture，设置他为一个正在进行的通知。他们通常是用来表示一个后台任务,用户积极参与(如播放音乐)或以某种方式正在等待,因此占用设备(如一个文件下载,同步操作,主动网络连接)
                .setDefaults(Notification.DEFAULT_ALL)//向通知添加声音、闪灯和振动效果的最简单、最一致的方式是使用当前的用户默认设置，使用defaults属性，可以组合：
                //Notification.DEFAULT_ALL  Notification.DEFAULT_SOUND 添加声音 // requires VIBRATE permission
                .setSmallIcon(R.mipmap.ic_launcher);
    }

    //弹出Notification
    private void showNotification() {
        Log.i("PollingServicec","---------------------"+notifyId);
        //Navigator to the new activity when click the notification title
        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        mManager.notify(notifyId, mBuilder.build());
    }

    /**
     * Polling thread
     * 模拟向Server轮询的异步线程
     *
     * @Author Ryan
     * @Create 2013-7-13 上午10:18:34
     */
    int count = 0;

    class PollingThread extends Thread {
        @Override
        public void run() {
            System.out.println("Polling...");
            count++;
            //当计数能被5整除时弹出通知
            if (count % 5 == 0) {
                showNotification();
                System.out.println("New message!");
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Service:onDestroy");
    }
    /**
     * @获取默认的pendingIntent,为了防止2.3及以下版本报错
     * @flags属性:
     * 在顶部常驻:Notification.FLAG_ONGOING_EVENT
     * 点击去除： Notification.FLAG_AUTO_CANCEL
     */
    public PendingIntent getDefalutIntent(int flags){
        PendingIntent pendingIntent= PendingIntent.getActivity(this, 1, new Intent(), flags);
        return pendingIntent;
    }
}
