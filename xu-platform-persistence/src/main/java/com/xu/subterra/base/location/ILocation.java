package com.xu.subterra.base.location;

import java.util.List;

public interface ILocation {
    String COMPONENT_DELIM = "/";
    char COMPONENT_DELIM_CHAR = '/';

    boolean containsRepositoryName();

    boolean isRelative();

    ILocation getAbsoluteLocation(ILocation var1);

    ILocation getRelativeLocation(ILocation var1);

    boolean hasRootLocation(ILocation var1);

    int getComponentCount();

    String getLastComponent();


    String getLastComponentExtension();


    String getLastComponentWithoutExtension();

    String getFirstComponent();

    String getComponent(int var1);

    List getComponents();

    int findComponentSequence(List var1);

    int findComponentSequence(String var1);

    boolean containsComponentSequence(List var1);

    boolean containsComponentSequence(String var1);

    boolean containsComponent(String var1);

    boolean startsWithComponentSequence(List var1);

    boolean startsWithComponentSequence(String var1);

    ILocation removeFirstComponents(int var1);

    ILocation setComponent(int var1, String var2);

    ILocation addOneComponentTowards(String var1);

    ILocation append(String var1);

    ILocation append(ILocation var1);

    String getRepositoryName();

    ILocation setRepositoryName(String var1);

    ILocation removeRepositoryName();

    String getLocationPath();

    ILocation getParentLocation();

    String getRevision();

    ILocation removeRevision();

    ILocation setRevision(String var1);

    ILocation replaceLocationPath(String var1);

    boolean hasRevision();

    String serialize();
}