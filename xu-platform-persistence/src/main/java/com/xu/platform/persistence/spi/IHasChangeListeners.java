package com.xu.platform.persistence.spi;

import com.xu.platform.persistence.model.IChangeListener;

public interface IHasChangeListeners {
    void addChangeListener(IChangeListener changeListener);
}
