package com.xu.platform.persistence;

import java.util.Properties;

public interface IEnumOption {

    String PROPERTY_KEY_ICON_URL = "iconURL";
    String PROPERTY_KEY_COLOR = "color";
    String PROPERTY_KEY_DEFAULT = "default";
    String PROPERTY_KEY_DESCRIPTION = "description";
    String PROPERTY_KEY_HIDDEN = "hidden";
    String PROPERTY_KEY_URI = "uri";
    String PROPERTY_KEY_UI_LINK = "uiLink";

    boolean isPhantom();

    String getEnumId();

    String getId();

    String getName();

    int getSequenceNumber();

    boolean isDefault();

    String getProperty(String var1);

    Properties getProperties();

    boolean isHidden();
}
