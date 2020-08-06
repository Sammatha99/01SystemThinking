package test;

import Dictionary.Bloom;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BloomTest {
@Test
    public void test (){
        Bloom bloom = new Bloom(100000 , 4);
        assertEquals(bloom.contain("consider"), false);
        bloom.add("consider");
        assertEquals(bloom.contain("consider"), true);
        assertEquals(bloom.contain("considerasd"), true);
    }
}