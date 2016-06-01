package by.bsu.bee2j.provider;

import by.bsu.bee2j.Bee2Library;
import com.sun.jna.Pointer;

import java.security.SecureRandom;
import java.security.SecureRandomSpi;


/**
 * Created by user on 18.05.2016.
 */
public class BrngSecureRandom extends SecureRandomSpi {
    Bee2Library bee2 = Bee2Library.INSTANCE;
    @Override
    protected void engineNextBytes(byte[] bytes) {

        System.out.println(bee2.brngCTR_keep());

    }

    @Override
    protected byte[] engineGenerateSeed(int numBytes) {
        byte [] ctr = new byte[1];
        ctr[0] = (byte)numBytes;
        byte[] iv = new byte[1];
        iv[0] = ctr[0];
       // bee2.brngCTRStart(new Pointer(),ctr,iv);
       // Pointer pi = new Pointer();
        return new byte[0];
    }

    @Override
    protected void engineSetSeed(byte[] seed) {

    }
}
