package com.nablab.galeriacartoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.nablab.galeriacartoon.utilities.AndroidBus;
import com.squareup.otto.Bus;

import java.util.HashMap;

import butterknife.ButterKnife;

public class StoreFragment extends Fragment implements  BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener{


    private SliderLayout mDemoSliderBanner;
    private SliderLayout mDemoSlider;

    public static Bus bus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store, container, false);

        ButterKnife.inject(view);

        mDemoSlider = (SliderLayout)view.findViewById(R.id.slider);
        mDemoSliderBanner = (SliderLayout)view.findViewById(R.id.sliderBanner);

        bus = new AndroidBus();

        setUpBanner();

        setUpSlidingGallery();
        return view;
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
            TextSliderView textSliderView = new TextSliderView(getActivity(), true);
            // initialize a SliderLayout
            textSliderView
                    .description("")
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);

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

        mDemoSliderBanner.setPresetTransformer("Default");

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
            TextSliderView textSliderView = new TextSliderView(getActivity());
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

        mDemoSlider.setPresetTransformer("FlipHorizontal");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mDemoSlider.stopAutoCycle();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(),slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
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
