package benchmark;

import Dictionary.Bloom;
import Dictionary.Trie;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.xml.sax.SAXException;
import sun.net.dns.ResolverConfiguration;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1,jvmArgs =  {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 1)
@Measurement(iterations = 3)
public class BenchMark {
    //@Param({"100","1000","10000"})
    @Param({"1000000"})
    public int numberOfWords;
    public String[] str;
    private Bloom bloom;
    private Trie trie;

    public static void main(String[] args) throws IOException, RunnerException {
        //org.openjdk.jmh.Main.main(args);
        Options opt = new OptionsBuilder()
                .include(BenchMark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }

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

    @Setup
    public void setup() throws IOException, SAXException, ParserConfigurationException {
        bloom = new Bloom(10000000 , 4);
        trie = new Trie();

        bloom.addFile("D:/git/bloom1/fakeBlogs");
        trie.addFile("D:/git/bloom1/fakeBlogs");

        str = generateRandomWords(numberOfWords);
    }

    @Benchmark
    public boolean searchBloom(){
        for(int i=0 ; i <100 ; i++){
            for( int j=0; j < str.length ; j++){
                bloom.contain(str[j]);
            }
        }
        return true;
    }

    @Benchmark
    public boolean searchTrie(){
        for(int i=0 ; i <100 ; i++){
            for( int j=0; j < str.length ; j++){
                trie.contain(str[j]);
            }
        }
        return true;
    }

}

