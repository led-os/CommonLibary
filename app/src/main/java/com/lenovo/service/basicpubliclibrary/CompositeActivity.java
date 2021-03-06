package com.lenovo.service.basicpubliclibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.getui.GetuiActivity;
import com.example.lenovo.cutphoto.ActivityRxPhoto;
import com.lenovo.service.basicpubliclibrary.aidls.AidlActivity;
import com.lenovo.service.basicpubliclibrary.alipay.AlipayActivity;
import com.lenovo.service.basicpubliclibrary.appupdate.AppUpdateActivity;
import com.lenovo.service.basicpubliclibrary.bezier.ShakeActivity;
import com.lenovo.service.basicpubliclibrary.bgaphotopicker.MomentListActivity;
import com.lenovo.service.basicpubliclibrary.cameraDemo.RecordMainAcitivity;
import com.lenovo.service.basicpubliclibrary.camerakit.CamerakitActivity;
import com.lenovo.service.basicpubliclibrary.charseperator.CharSeperatorActivity;
import com.lenovo.service.basicpubliclibrary.colorpickerview.ColorPickerViewActivity;
import com.lenovo.service.basicpubliclibrary.databinding.DataBindingActivity;
import com.lenovo.service.basicpubliclibrary.eventbus.EventBusActivity;
import com.lenovo.service.basicpubliclibrary.fingerutils.FingerprintActivity;
import com.lenovo.service.basicpubliclibrary.jniDemo.JNITestActivity;
import com.lenovo.service.basicpubliclibrary.jsBridge.activity.JSBridgeActivity;
import com.lenovo.service.basicpubliclibrary.jsBridge.common.LocalConstant;
import com.lenovo.service.basicpubliclibrary.linechart.ui.LineChartActivity;
import com.lenovo.service.basicpubliclibrary.opengl.SwitchRendererActivity;
import com.lenovo.service.basicpubliclibrary.permissionDemo.PermissionDemoActivity;
import com.lenovo.service.basicpubliclibrary.request.ui.RequestTestActivity;
import com.lenovo.service.basicpubliclibrary.rxjava.RxJavaActivity;
import com.lenovo.service.basicpubliclibrary.sadl.SADLActivity;
import com.lenovo.service.basicpubliclibrary.screenshot.ScreenShotActivity;
import com.lenovo.service.basicpubliclibrary.tencentx5.X5WebViewActivity;
import com.lenovo.service.basicpubliclibrary.validation.ValidateActivity;
import com.lenovo.service.basicpubliclibrary.videoplayer.VideoplayerActivity;
import com.lenovo.service.basicpubliclibrary.wechatpay.WeChatPayActivity;
import com.lenovo.service.basicpubliclibrary.zbar.ZbarActivity;
import com.lenovo.service.basicpubliclibrary.zxing.activity.ZxingActivity;


public class CompositeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView[] textviews;

    private int[] ids = new int[]{R.id.helloChart, R.id.jsBridge, R.id.SADL, R.id.ilog_demo,
             R.id.scan_code, R.id.tv_getui, R.id.tv_permission,R.id.tvEventBus,
            R.id.tv_request, R.id.tv_view1, R.id.tv_view2, R.id.tv_view3, R.id.tv_view4,
            R.id.tv_view5, R.id.tv_view6, R.id.tv_view7, R.id.tv_fingerprint, R.id.tvAppUpdate,
            R.id.tv_aidl, R.id.tv_opengl,R.id.tvUcrop,R.id.tv_shake,R.id.tv_aiSeperate,R.id.tv_screenShot
    };//R.id.tv_xmlparse,

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_composite);
        initView();
    }

    private void initView() {
        textviews = new TextView[ids.length];
        for (int i = 0; i < textviews.length; i++) {
            textviews[i] = (TextView) findViewById(ids[i]);
            textviews[i].setOnClickListener(this);
        }
    }

    public void startKotlin(View view) {
//        startActivity(new Intent(this, KotlinActivity.class));
    }

    public void startRx(View view) {
        startActivity(new Intent(this, RxJavaActivity.class));
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent();

        switch (view.getId()) {

            case R.id.helloChart:

                intent.setClass(this, LineChartActivity.class);

                break;

            case R.id.jsBridge:

                intent.setClass(this, JSBridgeActivity.class);
                intent.putExtra("extra1", LocalConstant.H5URL.page_register);

                break;
            case R.id.SADL:
                intent.setClass(this, SADLActivity.class);
                break;
            case R.id.ilog_demo:
                intent.setClass(this, ALogActivity.class);
                break;

            case R.id.tv_jnidemo:

                intent.setClass(this, JNITestActivity.class);

                break;
//            case R.id.tv_xmlparse:
//
//                intent.setClass(this, XmlParseActivity.class);
//
//                break;
            case R.id.scan_code:
                intent.setClass(this, ZxingActivity.class);
                break;

            case R.id.tv_getui:
                intent.setClass(this, GetuiActivity.class);
                break;

            case R.id.tv_permission:
                intent.setClass(this, PermissionDemoActivity.class);
                break;

            case R.id.tvEventBus:
                intent.setClass(this, EventBusActivity.class);
                break;
            case R.id.tv_request:

                intent.setClass(this, RequestTestActivity.class);

                break;
            case R.id.tv_view1:
                intent.setClass(this, com.lenovo.service.basicpubliclibrary.hencoder.hencoderpracticedraw1.MainActivity.class);
                break;
            case R.id.tv_view2:
                intent.setClass(this, com.lenovo.service.basicpubliclibrary.hencoder.hencoderpracticedraw2.MainActivity.class);
                break;
            case R.id.tv_view3:
                intent.setClass(this, com.lenovo.service.basicpubliclibrary.hencoder.hencoderpracticedraw3.MainActivity.class);
                break;
            case R.id.tv_view4:
                intent.setClass(this, com.lenovo.service.basicpubliclibrary.hencoder.hencoderpracticedraw4.MainActivity.class);
                break;
            case R.id.tv_view5:
                intent.setClass(this, com.lenovo.service.basicpubliclibrary.hencoder.hencoderpracticedraw5.MainActivity.class);
                break;
            case R.id.tv_view6:
                intent.setClass(this, com.lenovo.service.basicpubliclibrary.hencoder.hencoderpracticedraw6.MainActivity.class);
                break;
            case R.id.tv_view7:
                intent.setClass(this, com.lenovo.service.basicpubliclibrary.hencoder.hencoderpracticedraw7.MainActivity.class);
                break;
            case R.id.tv_fingerprint:
                intent.setClass(this, FingerprintActivity.class);
                break;

            case R.id.tx_x5:
                intent.setClass(this,X5WebViewActivity.class);
                break;
            case R.id.zbar:
                intent.setClass(this, ZbarActivity.class);
                break;
            case R.id.tvAppUpdate:
                intent.setClass(this, AppUpdateActivity.class);
                break;
            case R.id.tv_aidl:
                intent.setClass(this, AidlActivity.class);
                break;
            case R.id.tv_opengl:
                intent.setClass(this, SwitchRendererActivity.class);
                break;
            case R.id.tvUcrop://Ucrop图片裁剪+glide圆角头像
                intent.setClass(this, ActivityRxPhoto.class);
                break;
            case R.id.tv_shake:
                intent.setClass(this, ShakeActivity.class);
                break;
            case R.id.tv_aiSeperate:
                intent.setClass(this, CharSeperatorActivity.class);
                break;
            case R.id.tv_screenShot:
                intent.setClass(this, ScreenShotActivity.class);
                break;
        }
        startActivity(intent);
    }


    public void startDataBinding(View view) {
        startActivity(new Intent(this, DataBindingActivity.class));
    }

    public void recorder_video(View v) {
        startActivity(new Intent(this, RecordMainAcitivity.class));
    }

    public void startVideoPlayer(View v) {
        startActivity(new Intent(this, VideoplayerActivity.class));
    }

    public void startValidateActivity(View v) {
        startActivity(new Intent(this, ValidateActivity.class));
    }

    public void startCamerkitActivity(View view) {
        startActivity(new Intent(this, CamerakitActivity.class));
    }

    public void startAlipayActivity(View view) {
        startActivity(new Intent(this, AlipayActivity.class));
    }

    public void toWeChatPayActivity(View view) {
        startActivity(new Intent(this, WeChatPayActivity.class));
    }

    public void  getColorPickerView(View view) {
        startActivity(new Intent(this, ColorPickerViewActivity.class));
    }

    public void   sendWeChat(View view) {
        startActivity(new Intent(this, MomentListActivity.class));
    }
}
