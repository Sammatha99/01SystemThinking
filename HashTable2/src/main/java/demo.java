import HashTable.HashTable;

import java.util.Random;

public class demo {

    public static String[] generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(11)+5]; // words of length 5 through 15.
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    public static void main (String[] agrv ){
        HashTable a = new HashTable();
        int size =50;
        String[] test = generateRandomWords(size);
        for ( int i=0 ; i < size ; i++){
            String key = "";
            a.htInsert(key + i%size, test[i]);
        }

        System.out.println(a.htSearch("10") + " " + a.getSize());
    }
}
