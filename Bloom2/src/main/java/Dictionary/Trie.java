package Dictionary;

import Dictionary.Node.NodeTrie;
import Dictionary.Node.SuggestionDictionay;
import File.MyFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Trie implements Idictionary, SuggestionDictionay {

    private NodeTrie rootNode = new NodeTrie();

    @Override
    public boolean add(String data) {
        NodeTrie current = rootNode ;
        for (char l : data.toCharArray()){
            //current = current.getChildren(l);
            if (current.getChildren(l) == null){
                current.computeNewNode(l);
            }
            current = current.getChildren(l);
        }
        current.setEndofWord(true);
        return true;
    }

    @Override
    public boolean contain(String data) {
        NodeTrie current = rootNode;
        for (int i = 0; i < data.length() ; i ++){
            Character c  = data.charAt(i);
            NodeTrie node = current.getChildren(c);
            if(node == null){
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    @Override
    public void searchDiction() {
        while ( true){
            Scanner scanner = new Scanner(System.in);
            String str;
            System.out.println("nhap tu can tim : ");
            str = scanner.nextLine().toLowerCase();
            System.out.println(contain(str));
            System.out.println("nhap 'thoat' ve menu :  ");
            str = scanner.nextLine().toLowerCase();
            if (str.equals("thoat")){break;}
        }
    }

    @Override
    public boolean addFile(String path) throws ParserConfigurationException, SAXException, IOException {
        MyFile files = new MyFile(path);
        files.getData(this);
        return true;
    }


    @Override
    public void suggestWord(String data) {
        String word="";
        NodeTrie current = rootNode;
        for (int i = 0 ; i <= data.length()/2 ; i++){
            Character c = data.charAt(i);
            current = current.getChildren(c);
            if (current == null){return;}
            word = word + c;
        }
        System.out.println("tu : " + word);
        current.getWord(word);
    }

    @Override
    public void suggestDiction() {
        while ( true){
            Scanner scanner = new Scanner(System.in);
            String str;
            System.out.println("nhap tu can tim : ");
            str = scanner.nextLine().toLowerCase();
            suggestWord(str);
            System.out.println("nhap 'thoat' ve menu :  ");
            str = scanner.nextLine().toLowerCase();
            if (str.equals("thoat")){break;}
        }
    }
}
