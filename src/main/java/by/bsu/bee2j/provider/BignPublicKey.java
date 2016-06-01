package by.bsu.bee2j.provider;

import by.bsu.bee2j.BignParams;

import java.security.PublicKey;
/**
 * Created by user on 05.05.2016.
 */
public class BignPublicKey extends BignKey implements PublicKey {
    @Override
    public void setBytes(byte[] bytes) {
        super.setBytes(bytes);
        bignParams = new BignParams(bytes.length * 2);
    }

    public BignPublicKey() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public BignPublicKey(byte[] bytes) {
        super(bytes);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
