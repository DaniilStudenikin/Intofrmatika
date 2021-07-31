package ru.itis.proxy;

import java.io.InputStream;

public class FileAccessorProxy extends FileAccessor {

    private FileAccessor target;

    private After after;
    private Before before;

    public FileAccessorProxy(FileAccessor target) {
        this.target = target;
    }

    public void setAfter(After after) {
        this.after = after;
    }

    public void setBefore(Before before) {
        this.before = before;
    }

    @Override
    public InputStream openFile(String fileName) {
        if (before != null) {
            before.before();
        }
        InputStream result = target.openFile(fileName);

        if (after != null) {
            after.after();
        }
        return result;
    }
}
