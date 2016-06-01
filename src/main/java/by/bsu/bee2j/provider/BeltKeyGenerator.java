package by.bsu.bee2j.provider;

import javax.crypto.KeyGenerator;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;

/**
 * Created by user on 05.05.2016.
 */
public class BeltKeyGenerator extends KeyGeneratorSpi {

    private String algorithm;


   // public static KeyGenerator getInstance(String alg) throws NoSuchAlgorithmException{
       // return  new KeyGenerator(alg);
    //}


    @Override
    protected void engineInit(SecureRandom secureRandom) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    @Override
    protected void engineInit(int i, SecureRandom secureRandom) {
        //To change body of implemented methods use File | Settings | File Templates.

    }

    public  SecretKey engineInit()
    {
        return new SecretKeySpec(new SecureRandom().generateSeed(32), "Belt");
    }
    @Override
    protected SecretKey engineGenerateKey() {
        return new SecretKeySpec(new SecureRandom().generateSeed(32), "Belt");
    }
}
