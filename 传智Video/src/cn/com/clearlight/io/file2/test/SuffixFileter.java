package cn.com.clearlight.io.file2.test;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class SuffixFileter implements FilenameFilter {
    private String suffix;
    public SuffixFileter(String suffix) {
        super();
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }
}
