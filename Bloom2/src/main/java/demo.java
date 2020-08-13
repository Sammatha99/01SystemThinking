import Dictionary.Bloom;
import Dictionary.Trie;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        Scanner scanner = new Scanner(System.in);
        int i;
        Bloom bloom = new Bloom(10000000,4 );
        bloom.addFile("D:/git/bloom1/fakeBlogs");
        Trie trie= new Trie();
        trie.addFile("D:/git/bloom1/fakeBlogs");

        while(true){
            System.out.println("chon : \n\t 1. tim tu voi bloom \n\t 2. tim tu voi trie \n\t 3. goi y tu gan dung\n\t -khac : thoat ");
            i = scanner.nextInt();
            switch (i){
                case 1: bloom.searchDiction();
                    break;
                case 2: trie.searchDiction();
                    break;
                case 3: trie.suggestDiction();
                    break;
                default: break;
            }
        }
    }
}

/*
bt3 :  multithread , concurrency !!!!!!!!

bt4 :
database : ddl , dml
relational db : sql ascii 92

noSQL  : mấy loại
redis dùng loại nào

bt5 : micro service - message queue

 */