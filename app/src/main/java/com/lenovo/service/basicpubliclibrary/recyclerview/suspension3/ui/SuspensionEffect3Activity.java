package com.lenovo.service.basicpubliclibrary.recyclerview.suspension3.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lenovo.service.basicpubliclibrary.R;
import com.lenovo.service.basicpubliclibrary.dialog.util.DisplayUtil;
import com.lenovo.service.basicpubliclibrary.recyclerview.item.handle.listener.OnItemClickListener;
import com.lenovo.service.basicpubliclibrary.recyclerview.suspension.bean.City;
import com.lenovo.service.basicpubliclibrary.recyclerview.suspension3.adapter.SuspensionAdapter;
import com.lenovo.service.basicpubliclibrary.recyclerview.suspension3.listener.GroupListener;
import com.lenovo.service.basicpubliclibrary.recyclerview.suspension3.view.SuspensionItemDecoration;
import com.lenovo.service.basicpubliclibrary.utils.CitiesUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 悬浮效果演示界面
 * @author:袁东华
 * @time:2017/9/23 下午4:28
 */
public class SuspensionEffect3Activity extends AppCompatActivity {
    //今天的主角RecyclerView
    private RecyclerView recyclerView;
    private Context context = SuspensionEffect3Activity.this;

    private SuspensionAdapter suspensionAdapter;
    //城市列表数据
    private List<City.ProvincesBean.CitysBean> list;
    private int[] imgs = {R.drawable.icon_cloudy, R.drawable.icon_cloudy_nighttime,
            R.drawable.icon_gale, R.drawable.icon_heavy_rain,
            R.drawable.icon_heavy_snow, R.drawable.icon_meteor,
            R.drawable.icon_moon, R.drawable.icon_mostly_cloudy,
            R.drawable.icon_rain, R.drawable.icon_setting_sun,
            R.drawable.icon_snow, R.drawable.icon_stars,
            R.drawable.icon_sun, R.drawable.icon_sunrise_by_the_sea,
            R.drawable.icon_tornado, R.drawable.icon_rainbow,
            R.drawable.icon_rain_nighttime, R.drawable.icon_thundershower,
            R.drawable.icon_thunderstorm, R.drawable.icon_heavysnow};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setSubtitle("利用ItemDecoration的onDrawOver方法实现悬浮栏效果");
        setContentView(R.layout.activity_recyclerview_item_decoration);
        initView();
        initData();


    }

    private void initView() {
        //获取recyclerView对象
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //创建分割线
        SuspensionItemDecoration dividerItemDecoration = SuspensionItemDecoration.Builder.init(new GroupListener() {
            @Override
            public String getGroupName(int position) {
                if (list.size() > position) {

                    return list.get(position).getProvinceName();
                } else {
                    return null;
                }

            }

            /**
             * 获取分组的View
             *
             * @return
             */
            @Override
            public View getGroupView(int position) {
                if (list.size() > position) {
                    View view = getLayoutInflater().inflate(R.layout.item_group2, null, false);
                    TextView title_tv = view.findViewById(R.id.title_tv);
                    title_tv.setText(list.get(position).getProvinceName());
                    ImageView icon_iv = view.findViewById(R.id.icon_iv);
                    if (position < imgs.length) {
                        icon_iv.setImageResource(imgs[position]);
                    } else {
                        icon_iv.setImageResource(imgs[position%imgs.length]);
                    }


                    return view;
                } else {
                    return null;
                }
            }
        })
                .setColor(getResources().getColor(R.color.colorAccent))
                .setDividerHeight(DisplayUtil.dp2px(context, 1))
                .setGroupHeight(DisplayUtil.dp2px(context, 40))
                .setGroupColor(getResources().getColor(R.color.colorPrimaryDark))
                .setGroupTextColor(getResources().getColor(R.color.white))
                .setGroupTextSize(DisplayUtil.dp2px(context, 14)).build();


        //添加分割线
        recyclerView.addItemDecoration(dividerItemDecoration);
        suspensionAdapter = new SuspensionAdapter(this);
        recyclerView.setAdapter(suspensionAdapter);
        //点击条目
        suspensionAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(SuspensionEffect3Activity.this, "点击了条目" + (position + 1), Toast.LENGTH_SHORT).show();

            }
        });


    }

    /**
     * 设置数据
     */
    @TargetApi(Build.VERSION_CODES.N)
    private void initData() {
        City cities = CitiesUtil.getInstance().getCities(this);
        list = new ArrayList<>();
        if (cities != null && cities.getProvinces().size() > 0) {
            for (int i = 0; i < cities.getProvinces().size(); i++) {
                List<City.ProvincesBean.CitysBean> citys = cities.getProvinces().get(i).getCitys();
                if (citys != null && citys.size() > 0) {
                    for (int j = 0; j < citys.size(); j++) {
                        City.ProvincesBean.CitysBean citysBean = citys.get(j);
                        citysBean.setProvinceName(cities.getProvinces().get(i).getProvinceName());
                        list.add(citysBean);
                    }

                }
            }
        }


        suspensionAdapter.setData(list);

    }


}
