package by.bsu.bee2j.provider;

import by.bsu.bee2j.Bee2Library;

import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * Created by user on 18.05.2016.
 */
public class BashMessageDigest extends MessageDigest {
    ArrayList<Byte> data = new ArrayList<Byte>();
    public BashMessageDigest() {
        super("Bash");
    }
    protected void engineUpdate(byte input) {
        data.add(input);
    }

    protected void engineUpdate(byte[] input){
        for(byte b: input)
            data.add(b);
    }
    @Override
    protected void engineUpdate(byte[] input, int offset, int len) {
        for (byte b: input)
            data.add(b);
    }
    protected byte[] engineDigest() {

        byte[] bytes= Util.bytes(data);

        Bee2Library bee2 = Bee2Library.INSTANCE;
        byte[] hash = new byte[32];

        int res = bee2.beltHash(hash,bytes, bytes.length);
        if(res!=0)
            throw new RuntimeException("Bash hash was broken");
        return hash;
    }
    protected void engineReset() {
        data.clear();
    }

    @Override
    protected int engineGetDigestLength() {
        return 32;
    }
}
