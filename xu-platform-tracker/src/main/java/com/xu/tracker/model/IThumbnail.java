package com.xu.tracker.model;

import java.io.InputStream;

public interface IThumbnail {
    InputStream getContent();

    boolean isGenerated();
}
