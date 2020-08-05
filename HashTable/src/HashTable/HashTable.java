package HashTable;

import HashItem.HashItem;

public class HashTable {
    public int PRIME1 =  151, PRIME2 = 163;
    public HashItem DELETE_ITEM = new HashItem(null, null);

    int size;
    int count;
    HashItem[] items = null;

    public HashTable(){
        size = 53;
        count =0;
        items = new HashItem[53];
    }

    public int htHash (String s, int a, int m){
        long hash =0;
        int len = s.length();
        for (int i=0; i< len ; i++){
            hash += (long)( Math.pow(a, len - (i+1))*s.charAt(i));
            hash = hash%m;
        }
        return (int)hash;
    }

    public int htGetHash(String s, int a, int attempt){
        int hashA = htHash(s, PRIME1 , a);
        int hashB = htHash(s, PRIME2, a);
        return (hashA + (attempt*(hashB + 1)))%a;
    }

    public String htSearch (String key){
        int index = htGetHash(key, size, 0);
        HashItem item = items[index];
        int i= 1;
        while (item != null){
            if(item.getKey().equals(key)){
                return item.getValue();
            }
            index = htGetHash(key, size, i);
            item = items[index];
            i++;
        }
        return null;
    }

    public void htDelete (String key){
        int index = htGetHash(key, size, 0);
        HashItem item = items[index];
        int i=1;
        while (item != null ){
            if (item.getKey().equals(key)){
                items[index] = null;
            }
            index= htGetHash(key, size, i);
            item = items[index];
            i++;
        }
        count--;
    }

    public void htInsert (String key, String value){
        HashItem item = new HashItem(key, value);
        int index = htGetHash(key, size, 0);
        HashItem curItem = items[index];
        int i=1;
        while (curItem != null){
                if(curItem.getKey().equals(key)){
                    items[index] = item;
                    return;
                }
                index = htGetHash(key, size, i);
                curItem = items[index];
                i++;
        }
        items[index] = item;
        count ++;
    }


}
