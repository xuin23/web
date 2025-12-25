package com.xu.platform.persistence.model;

public interface IPObject extends IChangeListener, IAdaptable, IHasValues {

    IPrototype getPrototype();

}
