package Dictionary;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface Idictionary {
    public boolean add (String data);
    public boolean contain (String data);
    public void searchDiction ();
    public boolean addFile(String path) throws ParserConfigurationException, SAXException, IOException;
}
