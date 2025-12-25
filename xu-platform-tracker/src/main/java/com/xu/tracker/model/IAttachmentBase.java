package com.xu.tracker.model;

import com.xu.projects.model.IUniqueObject;
import com.xu.projects.model.IUser;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public interface IAttachmentBase extends IUniqueObject {
    String KEY_AUTHOR = "author";
    String KEY_FILE_NAME = "fileName";
    String KEY_URL = "url";
    String KEY_CONTENT = "content";
    String KEY_TITLE = "title";
    String KEY_UPDATED = "updated";
    String KEY_LENGTH = "length";

    IUser getAuthor();

    String getFileName();

    URL getURL();

    String getTitle();

    InputStream getDataStream();

    void setDataStream(InputStream var1);

    long getLength();

    Date getUpdated();

    IAttachmentViews views();
}