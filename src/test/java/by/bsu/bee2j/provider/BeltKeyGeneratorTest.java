package by.bsu.bee2j.provider;

import junit.framework.TestCase;

import javax.crypto.KeyGenerator;
import javax.crypto.KeyGeneratorSpi;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;


/**
 * Created by user on 05.05.2016.
 */
public class BeltKeyGeneratorTest extends TestCase {
    public void testBeltKeyGenerator()throws NoSuchAlgorithmException{
       // Provider a = new Bee2SecurityProvider();
        ///System.out.println(a.getServices());
KeyGenerator key = KeyGenerator.getInstance("Belt",new by.bsu.bee2j.provider.Bee2SecurityProvider());

        //key.getAlgorithm();
    }
}
