package HashTable;

import HashItem.HashItem;

public class HashTable {
    public int PRIME1 =  151, PRIME2 = 163 , HTINITIALBASESIZE = 53;
    public HashItem DELETE_ITEM = new HashItem(null, null);

    int size;
    int count;
    HashItem[] items = null;

    public HashTable(){
        size = 53;
        count =0;
        items = new HashItem[53];
    }

    public HashTable(int x){
        size = x;
        count =0;
        items = new HashItem[x];
    }

    private int isPrime(int x){
        if (x < 2) { return -1; }
        if (x < 4) { return 1; }
        if ((x % 2) == 0) { return 0; }
        for (int i = 3; i <= Math.sqrt((double) x); i += 2) {
            if ((x % i) == 0) {
                return 0;
            }
        }
        return 1;
    }

    int nextPrime (int x){
        while(isPrime(x)!=1){
            x++;
        }
        return x;
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
        int load = count * 100 /size ;
        if(load < 10 ){
            htResizeUp();
        }

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
        int load = count * 100 /size ;
        if(load >70 ){
            htResizeUp();
        }

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

    public void htResize (int newSize){
        if(newSize < HTINITIALBASESIZE){
            return;
        }
        newSize =nextPrime(newSize);
        HashTable newTable = new HashTable(newSize);
        for (int i=0; i < size ; i++){
            HashItem item = items[i];
            if(item != null){
                newTable.htInsert(item.getKey(),item.getValue());
            }
        }
        this.size = newTable.size;
        this.items= newTable.items;
        this.count = newTable.count;
    }

    public void htResizeUp(){
        htResize(size * 2);
    }

    public void htResizeDown(){
        htResize(size /2);
    }

    public int getSize() {
        return size;
    }
}
