package by.bsu.bee2j.provider;

/**
 * Created by user on 03.05.2016.
 */

import java.security.*;
public final class Bee2SecurityProvider extends Provider{
    public Bee2SecurityProvider()
    {
        super("Bee2", 1.0, "Bee2 Security Provider v1.0");
        put("MessageDigest.BeltHash", "by.bsu.bee2j.provider.BeltMessageDigest");
        put("Signature.Bign", "by.bsu.bee2j.provider.BignSignature");
        put("KeyPairGenerator.Bign", "by.bsu.bee2j.provider.BignKeyPairGenerator");
        put("Cipher.Belt", "by.bsu.bee2j.provider.BeltCipher");
        put("Cipher.Bign", "by.bsu.bee2j.provider.BignCipherSpi");
        put("KeyGenerator.Belt", BeltKeyGenerator.class.getName());
        put("SecureRandom.brng",BrngSecureRandom.class.getName());
    }
}
