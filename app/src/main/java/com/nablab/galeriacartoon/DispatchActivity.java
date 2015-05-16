package com.nablab.galeriacartoon;

import com.parse.ui.ParseLoginDispatchActivity;

/**
 * This is some sort of "in the middle" activity that prevents the user from going forward if
 * he doesn't authenticates in the app
 */
public class DispatchActivity extends ParseLoginDispatchActivity {

    @Override
    protected Class<?> getTargetClass() {
        return MainActivity.class;
    }
}
