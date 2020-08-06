package File.FileFilter;

import File.MyFile;

public interface FileFilter {
    boolean accept(MyFile pathname);
}
