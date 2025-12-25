package com.xu.platform.persistence.spi;

import com.xu.platform.persistence.IEnumOption;

import java.util.Properties;

public class EnumOption implements IEnumOption {

    private final String enumId;

    private final String id;

    private final String name;


    public EnumOption(String enumId, String id) {
        this.enumId = enumId;
        this.id = id;
        this.name = null;
    }

    public EnumOption(String enumId, String id, String name) {
        this.enumId = enumId;
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean isPhantom() {
        return false;
    }

    public String getEnumId() {
        return this.enumId;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int getSequenceNumber() {
        return 0;
    }

    @Override
    public boolean isDefault() {
        return false;
    }

    @Override
    public String getProperty(String var1) {
        return "";
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public boolean isHidden() {
        return false;
    }
}
