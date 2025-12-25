package com.xu.tracker.spi.model;

import java.nio.file.Path;

public interface IHasRelativeFilePath {
    Path toRelativeFilePath();
}
