package File.FileFilter;
import  java.io.File;
import java.io.FileFilter;

public class XMLFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {

        if (!pathname.isFile()) {
            return false;
        }

        if (pathname.getAbsolutePath().endsWith(".xml")) {
            return true;
        }

        return false;
    }

}
