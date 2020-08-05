import HashTable.HashTable;

public class demo {
    public static void main (String[] agrv ){
        HashTable a = new HashTable();
        a.htInsert("123", "trang");
        System.out.println(a.htSearch("123"));
        a.htInsert("123", "phuc");
        System.out.println(a.htSearch("123"));
        a.htDelete("123");
        System.out.println(a.htSearch("123"));
    }
}
