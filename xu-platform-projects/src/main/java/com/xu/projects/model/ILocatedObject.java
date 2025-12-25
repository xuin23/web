package com.xu.projects.model;

import com.xu.subterra.base.location.ILocation;

public interface ILocatedObject {
    String KEY_LOCATION = "location";

    ILocation getLocation();
}
