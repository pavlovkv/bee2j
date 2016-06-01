package by.bsu.bee2j;

/**
 * Created by user on 24.04.2016.
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
public class Bee2LibraryTest extends TestCase{

public void testBeltEncr()
{

    Bee2Library bee2 = Bee2Library.INSTANCE;
    int message_lenght = new Random().nextInt(50);
    byte[] encrypted = new byte[message_lenght];
    byte[] decrypted = new byte[message_lenght];
    byte[] key = "12345678123456781234567812345678".getBytes();
    //assertEquals(key.length, 32);
    //assertEquals(0, bee2.beltECBEncr(encrypted, "1234567890121234567890121234567890121234567890121".getBytes(), message_lenght, key, 32));
    System.out.println(bee2.beltECBEncr(encrypted, "1234567890121234567890121234567890121234567890121".getBytes(), message_lenght, key, 32));
   // assertEquals(0, bee2.beltECBDecr(decrypted, encrypted, message_lenght, key, 32));
    System.out.println(Arrays.toString(decrypted));
}
  public void testWrap() {

    Bee2Library bee2 = Bee2Library.INSTANCE;
    Bee2Library.RngFunc rng = new Bee2Library.RngFunc();
    int[] levels = { 128, 192, 256};

    for(int level: levels ) {

      BignParams bignParams = new BignParams(level);

      byte[] symkey = "12345678123456781234567812345678".getBytes();
      byte[] privKey = new byte[level/4];
      byte[] pubKey = new byte[level/2];

      assertEquals(bee2.bignGenKeypair(privKey, pubKey, bignParams, rng, null), 0);

      int token_len = 32 + 16 + level / 4;
      byte[] wrapped = new byte[token_len];

      byte[] unwrapped = new byte[32];
      assertEquals(0, bee2.bignKeyWrap(wrapped, bignParams, symkey, 32, "1234567890123456".getBytes(), pubKey, rng, null));
      assertEquals(0, bee2.bignKeyUnwrap(unwrapped, bignParams, wrapped, token_len, "1234567890123456".getBytes(), privKey));
      assertEquals(new String(symkey), new String(unwrapped));
    }
  }
}

