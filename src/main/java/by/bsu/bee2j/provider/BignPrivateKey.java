package by.bsu.bee2j.provider;

import java.security.PrivateKey;

/**
 * Created by user on 05.05.2016.
 */
import by.bsu.bee2j.BignParams;

import java.security.PrivateKey;

public class BignPrivateKey extends BignKey implements PrivateKey{
    public BignPrivateKey() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public BignPrivateKey(byte[] bytes) {
        super(bytes);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void setBytes(byte[] bytes) {
        super.setBytes(bytes);
        bignParams = new BignParams(bytes.length * 4);
    }

}
