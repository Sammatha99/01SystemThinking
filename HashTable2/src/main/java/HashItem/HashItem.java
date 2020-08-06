package HashItem;

public class HashItem {
    String key ;
    String value ;

    static public int PRIME1 = 152, PRIME2 = 163;

    public HashItem(String key, String value) {
       this.key = key;
       this.value = value;
    }

    public HashItem() {
        this.key = null;
        this.value = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
