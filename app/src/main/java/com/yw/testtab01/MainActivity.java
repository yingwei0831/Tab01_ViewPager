package com.yw.testtab01;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private PagerAdapter mPagerAdapter;
    private List<View> mViews = new ArrayList<>();

    private LinearLayout mTabHome;
    private LinearLayout mTabNearby;
    private LinearLayout mTabRelex;
    private LinearLayout mTabMine;

    private ImageButton mImgHome;
    private ImageButton mImgNearby;
    private ImageButton mImgRelex;
    private ImageButton mImgMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvents();
    }

    private void initEvents() {
        mTabHome.setOnClickListener(this);
        mTabNearby.setOnClickListener(this);
        mTabRelex.setOnClickListener(this);
        mTabMine.setOnClickListener(this);

        viewPager.addOnPageChangeListener(this);
    }

    private void initView() {
        viewPager = (ViewPager)findViewById(R.id.view_pager);
        mTabHome = (LinearLayout)findViewById(R.id.id_tab_home);
        mTabNearby = (LinearLayout)findViewById(R.id.id_tab_nearby);
        mTabRelex = (LinearLayout)findViewById(R.id.id_tab_relex);
        mTabMine = (LinearLayout)findViewById(R.id.id_tab_mine);

        mImgHome = (ImageButton)findViewById(R.id.id_tab_home_img);
        mImgNearby = (ImageButton)findViewById(R.id.id_tab_nearby_img);
        mImgRelex = (ImageButton)findViewById(R.id.id_tab_relex_img);
        mImgMine = (ImageButton)findViewById(R.id.id_tab_mine_img);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View tab_01 = inflater.inflate(R.layout.tab_01, null);
        View tab_02 = inflater.inflate(R.layout.tab_02, null);
        View tab_03 = inflater.inflate(R.layout.tab_03, null);
        View tab_04 = inflater.inflate(R.layout.tab_04, null);

        mViews.add(tab_01);
        mViews.add(tab_02);
        mViews.add(tab_03);
        mViews.add(tab_04);

        mPagerAdapter = new PagerAdapter() {

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(mViews.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View viwe = mViews.get(position);
                container.addView(viwe);
                return viwe;
            }

            @Override
            public int getCount() {
                return mViews.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
        viewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void onClick(View v) {
        resetImg();
        switch (v.getId()){
            case R.id.id_tab_home:
                viewPager.setCurrentItem(0);
                mImgHome.setImageResource(R.mipmap.tab_bar_home_selected);
                break;
            case R.id.id_tab_nearby:
                viewPager.setCurrentItem(1);
                mImgNearby.setImageResource(R.mipmap.tab_bar_nearby_selected);
                break;
            case R.id.id_tab_relex:
                viewPager.setCurrentItem(2);
                mImgRelex.setImageResource(R.mipmap.tab_bar_relex_selected);
                break;
            case R.id.id_tab_mine:
                viewPager.setCurrentItem(3);
                mImgMine.setImageResource(R.mipmap.tab_bar_mine_selected);
                break;
        }
    }

    /**
     * 将所有图标切换为暗色
     */
    private void resetImg() {
        mImgHome.setImageResource(R.mipmap.tab_bar_home_un_selected);
        mImgNearby.setImageResource(R.mipmap.tab_bar_nearby_un_selected);
        mImgRelex.setImageResource(R.mipmap.tab_bar_relex_un_selected);
        mImgMine.setImageResource(R.mipmap.tab_bar_mine_un_selected);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int currentItem = viewPager.getCurrentItem();
        resetImg();
        switch (currentItem){
            case 0:
                mImgHome.setImageResource(R.mipmap.tab_bar_home_selected);
                break;
            case 1:
                mImgNearby.setImageResource(R.mipmap.tab_bar_nearby_selected);
                break;
            case 2:
                mImgRelex.setImageResource(R.mipmap.tab_bar_relex_selected);
                break;
            case 3:
                mImgMine.setImageResource(R.mipmap.tab_bar_mine_selected);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
