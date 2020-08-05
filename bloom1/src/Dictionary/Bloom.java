package Dictionary;

import File.MyFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class Bloom implements Idictionary {
    private byte[] filter;
    private int hashFunction;
    private static int tweak = 1024079;

    public Bloom(byte[] Filter, int HashFunction) {
        this.filter = Filter;
        this.hashFunction = HashFunction;
    }

    public Bloom(int length, int HashFuntion){
        this.filter = new byte[length];
        this.hashFunction = HashFuntion;
    }

    public void setFilter(byte[] Filter) {
        this.filter = Filter;
    }

    public int getHashfunction() {
        return hashFunction;
    }

    public void setHashfunction(int HashFunction) {
        this.hashFunction = HashFunction;
    }

    private static int murmurhash3bit (int hashNum, byte[] data, long Tweak)
    {
        return murmurhash3 (data, 0, data.length, (int) (hashNum * 0xFBA4C795L + Tweak));
    }

    private static int murmurhash3 (byte[] data, int offset, int len, int seed)
    {
        int c1 = 0xcc9e2d51;
        int c2 = 0x1b873593;

        int h1 = seed;
        int roundedEnd = offset + (len & 0xfffffffc); // round down to 4 byte block

        for ( int i = offset; i < roundedEnd; i += 4 )
        {
            // little endian load order
            int k1 = (data[i] & 0xff) | ((data[i + 1] & 0xff) << 8) | ((data[i + 2] & 0xff) << 16) | (data[i + 3] << 24);
            k1 *= c1;
            k1 = (k1 << 15) | (k1 >>> 17); // ROTL32(k1,15);
            k1 *= c2;

            h1 ^= k1;
            h1 = (h1 << 13) | (h1 >>> 19); // ROTL32(h1,13);
            h1 = h1 * 5 + 0xe6546b64;
        }

        // tail
        int k1 = 0;

        switch ( len & 0x03 )
        {
            case 3:
                k1 = (data[roundedEnd + 2] & 0xff) << 16;
                // fallthrough
            case 2:
                k1 |= (data[roundedEnd + 1] & 0xff) << 8;
                // fallthrough
            case 1:
                k1 |= data[roundedEnd] & 0xff;
                k1 *= c1;
                k1 = (k1 << 15) | (k1 >>> 17); // ROTL32(k1,15);
                k1 *= c2;
                h1 ^= k1;
            default:
        }

        // finalization
        h1 ^= len;

        // fmix(h1);
        h1 ^= h1 >>> 16;
        h1 *= 0x85ebca6b;
        h1 ^= h1 >>> 13;
        h1 *= 0xc2b2ae35;
        h1 ^= h1 >>> 16;

        return h1;
    }

    private void setBit (int n)
    {
        filter[n >>> 3] |= 1 << (7 & n);
    }

    private boolean testBit (int n)
    {
        return (filter[n >>> 3] & 1 << (7 & n)) != 0;
    }

    @Override
    public boolean add (String data)
    {
        for (int i = 0; i < hashFunction; ++i )
        {
            setBit ((int) ((murmurhash3bit (i, data.getBytes(), tweak) & 0xFFFFFFFFL) % (filter.length * 8)));
        }
        return true;
    }

    @Override
    public boolean contain(String data) {
        for (int i = 0; i < hashFunction; ++i )
        {
            if ( !testBit ((int) ((murmurhash3bit (i, data.getBytes(), tweak) & 0xFFFFFFFFL) % (filter.length * 8))) )
            {
                return false;
            }
        }
        return true;
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

}
