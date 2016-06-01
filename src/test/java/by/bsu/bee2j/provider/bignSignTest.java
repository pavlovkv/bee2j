package by.bsu.bee2j.provider;

import by.bsu.bee2j.Bee2Library;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import junit.framework.TestCase;

import java.security.*;
import java.security.Security;
import java.security.Signature;
import java.util.Arrays;

/**
 * Created by user on 14.05.2016.
 */
public class bignSignTest extends TestCase{
    public void testBignSign() throws NoSuchAlgorithmException,InvalidKeyException,SignatureException
    {
        int[] message_int = {
                0xB1,0x94,0xBA,0xC8,0x0A,0x08,0xF5,0x3B,0x36,0x6D,0x00,0x8E,0x58
        };

        byte[] mes = new byte[message_int.length];
        for(int i=0;i<mes.length;i++)
            mes[i] = (byte)message_int[i];
        Security.addProvider(new Bee2SecurityProvider());
        Signature sign = Signature.getInstance("Bign");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("Bign");
        SecureRandom sr = new SecureRandom();
        keyPairGenerator.initialize(128,sr);
        KeyPair keys = keyPairGenerator.generateKeyPair();
        System.out.println(keys.getPublic().getFormat());

        sign.initSign(keys.getPrivate());
        sign.update(mes);
        byte[] sigBytes = sign.sign();
        System.out.println(Arrays.toString(sigBytes));
        Signature signVer = Signature.getInstance("Bign");
        signVer.initVerify(keys.getPublic());
        signVer.update(mes);
        //System.out.println(signVer.verify(sigBytes));
       // assertTrue(signVer.verify(sigBytes));


    }
}
