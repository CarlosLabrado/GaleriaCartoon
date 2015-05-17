package com.daimajia.slider.library.SliderTypes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.slider.library.R;

/**
 * This is a slider with a description TextView.
 */
public class TextSliderView extends BaseSliderView{

    boolean noBackground = false;

    public TextSliderView(Context context) {
        super(context);
    }


    public TextSliderView(Context context, boolean noBackground) {
        super(context);
        this.noBackground = noBackground;
    }

    @Override
    public View getView() {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.render_type_text,null);
        ImageView target = (ImageView)v.findViewById(R.id.daimajia_slider_image);
        if (noBackground) {
            LinearLayout linearLayout = (LinearLayout) v.findViewById(R.id.description_layout);
            linearLayout.setBackgroundColor(getContext().getResources().getColor(android.R.color.transparent));
        }
        TextView description = (TextView)v.findViewById(R.id.description);
        description.setText(getDescription());
        bindEventAndShow(v, target);
        return v;
    }
}
