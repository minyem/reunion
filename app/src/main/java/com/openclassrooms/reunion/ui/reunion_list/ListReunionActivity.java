package com.openclassrooms.reunion.ui.reunion_list;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.openclassrooms.reunion.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListReunionActivity extends AppCompatActivity  {

    // UI Components
    @BindView(R.id.main_content)
    TabLayout mTabLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.container)
    ViewPager mViewPager;

    ListReunionPagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_reunion);


        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mPagerAdapter = new ListReunionPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
       mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
      mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

   // @OnClick(R.id.add_neighbour)
   // void addNeighbour() {
   //     AddNeighbourActivity.navigate(this);
   // }

  //  @Override
  //  public void apply() {

  //      reunionFavorisFragment neighbourFavorisFragment = (NeighbourFavorisFragment) getSupportFragmentManager().getFragments().get(1);
  //      neighbourFavorisFragment.initList();
  //      mViewPager.setCurrentItem(1);
  //  }
}
