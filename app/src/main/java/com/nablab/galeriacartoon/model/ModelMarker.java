package com.nablab.galeriacartoon.model;


import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Vazh on 15/5/2015.
 */
@Table(name = "ModelMarkers")
public class ModelMarker {

    @Column
    public String title;

    @Column
    public LatLng latLng;

}
