package by.bsu.bee2j.provider;

import java.security.*;
import java.util.ArrayList;
import by.bsu.bee2j.*;
import com.sun.jna.ptr.IntByReference;

/**
 * Created by user on 14.05.2016.
 */
public class BignSignature extends Signature{
    Bee2Library bee2 = Bee2Library.INSTANCE;
    Bee2Library.RngFunc rng = new Bee2Library.RngFunc();

    public BignSignature() {
        super("BignSign");
    }

    BignKey privKey = null;
    BignKey pubKey = null;

    ArrayList<Byte> data = new ArrayList<Byte>();


    private byte[] hash(byte[] data, int len) {
        byte[] hash = new byte[len];
        System.arraycopy(new BeltMessageDigest().digest(data), 0, hash, 0, 32);
        return hash;
    }

    @Override
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        this.state = VERIFY;
        this.pubKey = new BignPublicKey(((BignPublicKey)publicKey).bytes);
    }

    @Override
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        this.state = SIGN;
        this.privKey = new BignPrivateKey(((BignPrivateKey) privateKey).bytes);
    }

    @Override
    public void engineUpdate(byte b) throws SignatureException {
        data.add(b);
    }

    @Override
    public void engineUpdate(byte[] b, int off, int len) throws SignatureException {
        for (int i=off; i<len; i++){
            data.add(b[i]);
        }
    }

    @Override
    public byte[] engineSign() throws SignatureException {

        byte[] sig = new byte[(privKey.bignParams.l * 3)/8];
        byte[] oid_der = new byte[256];
        IntByReference oid_len = new IntByReference(256);
        bee2.bignOidToDER(oid_der,oid_len,"1.2.112.0.2.0.34.101.31.81");
        byte[] hasher = hash(Util.bytes(data),privKey.bignParams.l/4);

        int res = bee2.bignSign(sig,
                privKey.bignParams.getPointer(),
                oid_der,
                oid_len.getValue(),
                hash(Util.bytes(data), privKey.bignParams.l/4),
                privKey.bytes, rng, null);
        System.out.println(res);
        return sig;
    }

    @Override
    public boolean engineVerify(byte[] sigBytes) throws SignatureException {
        assert this.pubKey != null;
        byte[] oid_der = new byte[256];
        IntByReference oid_len = new IntByReference(256);
        bee2.bignOidToDER(oid_der,oid_len,"1.2.112.0.2.0.34.101.31.81");
        int res = bee2.bignVerify(pubKey.bignParams.getPointer(),
                hash(Util.bytes(data), pubKey.bignParams.l/4),
                oid_der,
                oid_len.getValue(),
                sigBytes,
                pubKey.bytes);
        System.out.println(res);
        return res==0;

    }

    @Override
    public void engineSetParameter(String param, Object value) throws InvalidParameterException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object engineGetParameter(String param) throws InvalidParameterException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
