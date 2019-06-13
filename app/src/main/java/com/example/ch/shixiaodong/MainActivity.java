package com.example.ch.shixiaodong;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.ch.shixiaodong.fragment.CollectionFragment;
import com.example.ch.shixiaodong.fragment.HomeFragment;

import java.util.ArrayList;

//史晓东 142201200101034098
public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CollectionFragment());

        ArrayList<String> title = new ArrayList<>();
        title.add("校门");
        title.add("关注");

        VpAdapter adapter = new VpAdapter(getSupportFragmentManager(), fragments, title);
        mVp.setAdapter(adapter);

        mTab.setupWithViewPager(mVp);
    }
}
