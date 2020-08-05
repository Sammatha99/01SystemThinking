package File;

import java.io.*;

import javax.xml.parsers.*;

import Dictionary.Idictionary;
import File.FileFilter.XMLFileFilter;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class MyFile {
    private String strPath ;

    public MyFile(String strPath) {
        this.strPath = strPath;
    }


    public void readFile(File inputFile, Idictionary idictionary) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList nListDate = doc.getElementsByTagName("date");
        NodeList nListPost =doc.getElementsByTagName("post");
        for (int i = 0 ; i < nListDate.getLength(); i ++){
            Element element = (Element)nListDate.item(i);
            String[] word = element.getTextContent().trim().split("\\W");
            for ( String w : word){
                idictionary.add(w.toLowerCase());
            }
        }
        for (int i = 0 ; i < nListPost.getLength(); i ++){
            Element element = (Element)nListPost.item(i);
            String[] word = element.getTextContent().trim().split("\\W");
            for ( String w : word){
                idictionary.add(w.toLowerCase());
            }
        }
    }

    public void getData(Idictionary idictionary) throws IOException, ParserConfigurationException, SAXException {
        java.io.File dir  = new java.io.File(strPath);
        XMLFileFilter file = new XMLFileFilter();
        java.io.File[] xmlFiles = dir.listFiles(new XMLFileFilter());

        for (File xmlFile : xmlFiles){
            readFile(xmlFile , idictionary);
        }
    }


}
