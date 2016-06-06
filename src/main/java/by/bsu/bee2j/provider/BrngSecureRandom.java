package by.bsu.bee2j.provider;

import by.bsu.bee2j.Bee2Library;
import com.sun.jna.Pointer;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import  by.bsu.bee2j.provider.Util;


/**
 * Created by user on 18.05.2016.
 */
public class BrngSecureRandom extends SecureRandomSpi {
    Bee2Library bee2 = Bee2Library.INSTANCE;
    @Override
    protected void engineNextBytes(byte[] bytes) {

        System.out.println(bee2.brngCTR_keep());
        Pointer p = bee2.beltGetH();
        byte[] b = p.getByteArray(0,256);
        byte[] state = new byte[1024];
        byte[] iv = new byte[32];
        byte[] theta = new byte[32];
        for(int i=128;i<128+32;i++)
            theta[i-128] = b[i];
        for(int i=128+64;i<128+64+32;i++)
            iv[i-128-64] =b[i];
        bee2.brngCTRStart(state,b,b);
        byte[] buf = new byte[1024];
        bee2.brngCTRStepR(buf,32,state);
        System.out.println(buf[0]);


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
