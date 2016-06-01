package by.bsu.bee2j.provider;

import by.bsu.bee2j.BignParams;
import junit.framework.TestCase;

import javax.crypto.*;
import java.security.*;


import by.bsu.bee2j.Bee2Library;



/**
 * Created by user on 05.05.2016.
 */
public class BignKeyPairGenerationTest extends TestCase{
    public void testBignKeyPairGeneration()throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException{
        Security.addProvider(new Bee2SecurityProvider());

        BignKeyPairGenerator gen = new BignKeyPairGenerator();
        int[] levels = {128, 192, 256};
        for(int level: levels) {
            gen.initialize(level);
            KeyPair keys = gen.generateKeyPair();
            PrivateKey pr = keys.getPrivate();
            PublicKey pub = keys.getPublic();
            BignParams params = new BignParams(level);
            assertEquals(Bee2Library.INSTANCE.bignValPubkey(params,pub.getEncoded()),0);
        }
    }
}
