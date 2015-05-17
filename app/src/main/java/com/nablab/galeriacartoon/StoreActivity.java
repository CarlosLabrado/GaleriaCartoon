package com.nablab.galeriacartoon;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.nablab.galeriacartoon.custom.ImageSlider.ChildAnimationExample;
import com.nablab.galeriacartoon.custom.navigationDrawer.NavDrawerItem;
import com.nablab.galeriacartoon.custom.navigationDrawer.NavDrawerListAdapter;
import com.nablab.galeriacartoon.utilities.AndroidBus;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class StoreActivity extends AppCompatActivity implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{


    private SliderLayout mDemoSliderBanner;
    private SliderLayout mDemoSlider;

    // Navigation Drawer
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mTitle;

//    @InjectView(R.id.list_slidermenu)
//    ListView mDrawerList;
//    @InjectView(R.id.drawer_layout)
//    DrawerLayout mDrawerLayout;
//    @InjectView(R.id.linearLayoutDrawer)
//    RelativeLayout mDrawerRelativeLayout;

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    public static Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        ButterKnife.inject(this);

        mDemoSlider = (SliderLayout)findViewById(R.id.slider);
        mDemoSliderBanner = (SliderLayout)findViewById(R.id.sliderBanner);

        bus = new AndroidBus();
        bus.register(this);

        /**toolBar **/
        setUpToolBar();

//        setUpDrawer();

        setUpBanner();

        setUpSlidingGallery();

    }

    private void setUpBanner() {
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("1",R.drawable.c_1_banner);
        file_maps.put("2",R.drawable.c_2_banner);
        file_maps.put("3",R.drawable.c_3_banner);
        file_maps.put("4",R.drawable.c_4_banner);
        file_maps.put("5",R.drawable.c_5_banner);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this, true);
            // initialize a SliderLayout
            textSliderView
                    .description("")
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSliderBanner.addSlider(textSliderView);
        }
        mDemoSliderBanner.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSliderBanner.setPresetIndicator(SliderLayout.PresetIndicators.Right_Bottom);
//        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
//        mDemoSlider.setDuration(4000);
        mDemoSliderBanner.addOnPageChangeListener(this);
//        ListView l = (ListView)findViewById(R.id.transformers);
//        l.setAdapter(new TransformerAdapter(this));
//        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
//                Toast.makeText(StoreActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

        mDemoSliderBanner.setPresetTransformer("Default");
//        mDemoSliderBanner.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));

    }

    private void setUpSlidingGallery() {
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");
        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Boda",R.drawable.i_boda);
        file_maps.put("Cartoon",R.drawable.i_cartoon);
        file_maps.put("Corporativo",R.drawable.i_corporativo);
        file_maps.put("Digital Sombreado",R.drawable.i_digital_sombreado);
        file_maps.put("Digital",R.drawable.i_digital);
        file_maps.put("Feria",R.drawable.i_feria);
        file_maps.put("Monero",R.drawable.i_monero);
        file_maps.put("Pareja",R.drawable.i_pareja);
        file_maps.put("Perfilete",R.drawable.i_perfilete);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterInside)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
//        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
//        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
//        ListView l = (ListView)findViewById(R.id.transformers);
//        l.setAdapter(new TransformerAdapter(this));
//        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                mDemoSlider.setPresetTransformer(((TextView) view).getText().toString());
//                Toast.makeText(StoreActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });

        mDemoSlider.setPresetTransformer("FlipHorizontal");
    }

    /**
     * sets up the top bar
     */
    private void setUpToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

//    /**
//     * Finishes to draw the drawer
//     */
//    private void setUpDrawer() {
//        // load slide menu items
//        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
//
//        // nav drawer icons from resources
//        navMenuIcons = getResources()
//                .obtainTypedArray(R.array.nav_drawer_icons);
//        navDrawerItems = new ArrayList<NavDrawerItem>();
//
//        // Home
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
//        // Store
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
//        // Contact
//        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
//        // Recycle the typed array
//        navMenuIcons.recycle();
//        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
//
//        // setting the nav drawer list adapter
//        adapter = new NavDrawerListAdapter(getApplicationContext(),
//                navDrawerItems);
//        mDrawerList.setAdapter(adapter);
//
//        mDrawerToggle = new ActionBarDrawerToggle(
//                this,
//                mDrawerLayout,
//                toolbar,
//                R.string.navigation_drawer_open, R.string.navigation_drawer_close
//        ) {
//            public void onDrawerClosed(View view) {
//                getSupportActionBar().setTitle(mTitle);
//                // calling onPrepareOptionsMenu() to show action bar icons
//                invalidateOptionsMenu();
//            }
//
//            public void onDrawerOpened(View drawerView) {
//                mDrawerList.setItemChecked(1, true);
//                mDrawerList.setSelection(1);
//                getSupportActionBar().setTitle(R.string.app_name);
//                // calling onPrepareOptionsMenu() to hide action bar icons
//                invalidateOptionsMenu();
//            }
//        };
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//
//        mDrawerToggle.syncState();
//    }

    /**
     * Slide menu item click listener
     */
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            // display view for selected nav drawer item
            //reactToDrawerClick(position);
        }
    }


    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mDemoSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_custom_indicator:
//                mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator));
                break;
            case R.id.action_custom_child_animation:
                mDemoSlider.setCustomAnimation(new ChildAnimationExample());
                break;
            case R.id.action_restore_default:
                mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                mDemoSlider.setCustomAnimation(new DescriptionAnimation());
                break;
            case R.id.action_github:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/daimajia/AndroidImageSlider"));
                startActivity(browserIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {}
}
