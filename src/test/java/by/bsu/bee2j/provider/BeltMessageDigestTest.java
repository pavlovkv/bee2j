package by.bsu.bee2j.provider;

import junit.framework.TestCase;
import java.security.*;
import java.security.MessageDigest;

/**
 * Created by user on 05.05.2016.
 */
public class BeltMessageDigestTest extends TestCase {

    public void testBeltMessageDigest() throws NoSuchAlgorithmException {
        Security.addProvider(new  by.bsu.bee2j.provider.Bee2SecurityProvider());
        MessageDigest beltHash = MessageDigest.getInstance("BeltHash");

        int[] mes_int = {0xB1,0x94,0xBA,0xC8,0x0A,0x08,0xF5,0x3B,0x36,0x6D,0x00,0x8E,0x58};

        int[] res_int =  {
                0xAB,0xEF,0x97,0x25,0xD4,0xC5,0xA8,0x35,0x97,0xA3,0x67,0xD1,0x44,0x94,0xCC,
                0x25,0x42,0xF2,0x0F,0x65,0x9D,0xDF,0xEC,0xC9,0x61,0xA3,0xEC,0x55,0x0C,0xBA,
                0x8C,0x75};

                byte[] mes = new byte[mes_int.length];
        for(int i=0;i<mes.length;i++) {
            mes[i] = (byte) mes_int[i];
        }
        byte[] res = new byte[res_int.length];
        for(int i = 0; i<res_int.length;i++){
            res[i]=(byte) res_int[i];
        }
        beltHash.update(mes);
        byte[] hash = beltHash.digest();

        assertEquals(hash.length,32);
        for(int i =0;i<hash.length;i++) {
            assertEquals(hash[i],res[i]);
        }
    }
}

