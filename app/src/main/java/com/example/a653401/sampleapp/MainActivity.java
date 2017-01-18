package com.example.a653401.sampleapp;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolBr;
    TabLayout tabLayout;
//    ViewPager pager;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    int SelectedIndex ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_main);
        toolBr = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolBr);
        getSupportActionBar().setTitle("My custom toolbar!");
//        pager = (ViewPager)(findViewById(R.id.pager));
//        tabLayout = (TabLayout) (findViewById(R.id.tabBar));
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView = (NavigationView)findViewById(R.id.navigationView);
        setUpNavigationView();
//        setUpPager();
//        tabLayout.setupWithViewPager(pager);
        if(savedInstanceState==null) {

            selectNavigationMenu();
        }

    }
    public void setUpNavigationView()
    {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.drawerItem1:
                        SelectedIndex = 0;
                        loadFragment(0);
                        break;
                    case R.id.drawerItem2:
                        SelectedIndex = 1;
                        loadFragment(1);
                        break;
                    case R.id.drawerItem3:
                        SelectedIndex = 2;
                        loadFragment(2);
                        break;
                    case R.id.drawerItem4:
                        break;
                }
                if(item.isChecked())
                    item.setChecked(false);
                    else
                    item.setChecked(true);
                return true;
            }
        });
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolBr,R.string.drawer_open,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
/*    public void setUpPager(){
        pageAdapter pagerAdapter = new pageAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new CountryFragment(),"Country");
        pagerAdapter.addFragment(new StateFragment(),"State");
        pager.setAdapter(pagerAdapter);

    }*/
    class pageAdapter extends FragmentPagerAdapter{

        private ArrayList<Fragment> fragments = new ArrayList<>();
        private ArrayList<String> fragmentName = new ArrayList<>();
        public pageAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentName.get(position);
        }

        public void addFragment(Fragment fragment,String title)
        {
            fragments.add(fragment);
            fragmentName.add(title);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }

    private void selectNavigationMenu(){
        navigationView.getMenu().getItem(0).setChecked(true);
        loadFragment(0);

    }
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment).addToBackStack(fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    public void loadFragment(int index) {
        switch (index) {
            case 0:
                addFragment(R.id.fragmentContainer,new CountryFragment());
                break;
            case 1:
                addFragment(R.id.fragmentContainer,new StateFragment());
                break;
            case 2:
                addFragment(R.id.fragmentContainer,new RecyclerViewSample());
                break;

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt("ItemIndex",SelectedIndex);
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
