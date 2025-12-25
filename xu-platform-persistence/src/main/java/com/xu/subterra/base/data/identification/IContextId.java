package com.xu.subterra.base.data.identification;

public interface IContextId {

    String CLUSTER_START_DELIM = "/";
    char CLUSTER_START_DELIM_CHAR = '/';
    String CLUSTER_END_DELIM = "/";
    char CLUSTER_END_DELIM_CHAR = '/';
    String BASELINE_DELIM = "/";
    char BASELINE_DELIM_CHAR = '/';

    String getClusterName();

    String getContextName();

    IContextId removeClusterName();

    IContextId setClusterName(String var1);

    String getBaseline();

    IContextId removeBaseline();

    IContextId setBaseline(String var1);

    String toNormalizedString();
}
