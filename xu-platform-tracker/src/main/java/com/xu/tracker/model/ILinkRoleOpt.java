package com.xu.tracker.model;

import java.util.List;
import java.util.Set;

public interface ILinkRoleOpt {
    String PROPERTY_KEY_OPPOSITE_NAME = "oppositeName";
    String PROPERTY_PARENT = "parent";

    String getOppositeName();

    List<IRule> getRules();

    boolean isAllowed(String var1, String var2);

    boolean isAllowed(ITypeOpt var1, ITypeOpt var2);

    Set<String> isAllowedToTypes(String var1);

    boolean isAllowedFromAll();

    boolean isAllowedToAll();

    public interface IRule {
        Set<String> getFromTypes();

        Set<String> getToTypes();

        boolean isSameType();

        boolean isAllowed(String var1, String var2);

        Set<String> isAllowedToTypes(String var1);

        boolean isAllowedFromAll();

        boolean isAllowedToAll();
    }
}
