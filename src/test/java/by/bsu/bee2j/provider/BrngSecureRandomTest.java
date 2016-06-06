package by.bsu.bee2j.provider;

/**
 * Created by user on 18.03.2016.
 */
import junit.framework.TestCase;
import by.bsu.bee2j.*;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

public class BrngSecureRandomTest extends TestCase {
    public void testBrng()throws NoSuchAlgorithmException
    {
       // System.out.println(bee2.brngCTR_keep());
        Security.addProvider(new Bee2SecurityProvider());
        SecureRandom b =SecureRandom.getInstance("brng");
        byte[] bytes = {123,-23};
        b.nextBytes(bytes);
    }
}
