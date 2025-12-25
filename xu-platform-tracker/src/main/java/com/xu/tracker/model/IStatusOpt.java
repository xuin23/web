package com.xu.tracker.model;

import com.xu.platform.persistence.IEnumOption;

public interface IStatusOpt extends IEnumOption {
    String PROPERTY_KEY_DESCRIPTION = "description";
    String PROPERTY_KEY_TERMINAL = "terminal";

    boolean isTerminal();
}
